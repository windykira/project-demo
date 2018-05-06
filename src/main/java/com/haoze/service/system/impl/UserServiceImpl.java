package com.haoze.service.system.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoze.dao.system.DepartmentDao;
import com.haoze.dao.system.UserDao;
import com.haoze.dao.system.UserOracleDao;
import com.haoze.dao.system.UserRoleDao;
import com.haoze.model.system.entity.UserEntity;
import com.haoze.model.system.entity.UserRoleEntity;
import com.haoze.model.system.vo.UserVO;
import com.haoze.service.system.UserService;
import com.haoze.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户数据服务接口实现类。
 * @author maxl
 * @time 2018-05-02。
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userMapper;
    @Autowired
    UserOracleDao userOracleMapper;
    @Autowired
    UserRoleDao userRoleMapper;
    @Autowired
    DepartmentDao deptMapper;

    @Override
    public List<UserEntity> list(Map<String, Object> map) {
        return userMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        //return userMapper.count(map);
        return userOracleMapper.countForOracle(map);
    }

    @Override
    public Page<UserEntity> listByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return userOracleMapper.listByPage();
    }

    @Override
    public UserEntity get(Long id) {

        List<Long> roleIds = userRoleMapper.listRoleId(id);
        UserEntity user = userMapper.get(id);
        user.setDeptName(deptMapper.get(user.getDeptId()).getName());
        user.setRoleIds(roleIds);
        return user;
    }

    public int update(UserEntity user) {
        int r = userMapper.update(user);
        Long userId = user.getUserId();
        List<Long> roles = user.getRoleIds();
        userRoleMapper.removeByUserId(userId);
        List<UserRoleEntity> list = new ArrayList<>();
        for (Long roleId : roles) {
            UserRoleEntity ur = new UserRoleEntity();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        if (list.size() > 0) {
            userRoleMapper.batchSave(list);
        }
        return r;
    }

    @Override
    @Transactional
    public int adminResetPwd(UserVO userVO) throws Exception {

        UserEntity userDO =get(userVO.getUserEntity().getUserId());
        if("admin".equals(userDO.getUsername())){
            throw new Exception("超级管理员的账号不允许直接重置！");
        }
        userDO.setPassword(MD5Util.encrypt(userDO.getUsername(), userVO.getPwdNew()));
        return userMapper.update(userDO);
    }
}

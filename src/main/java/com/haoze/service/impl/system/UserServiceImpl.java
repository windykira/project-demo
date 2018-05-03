package com.haoze.service.impl.system;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoze.common.model.PaginationResult;
import com.haoze.dao.system.UserDao;
import com.haoze.model.system.UserEntity;
import com.haoze.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 用户数据服务接口实现类。
 * @author maxl 2018-05-02。
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userMapper;

    @Override
    public List<UserEntity> list(Map<String, Object> map) {
        return userMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userMapper.count(map);
    }

    @Override
    public Page<UserEntity> listByPage(int pageNo, int pageSize) {

        PageHelper.startPage(pageNo, pageSize);
        return userMapper.listByPage();
    }
}

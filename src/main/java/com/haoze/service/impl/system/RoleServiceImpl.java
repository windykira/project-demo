package com.haoze.service.impl.system;

import com.haoze.dao.system.RoleDao;
import com.haoze.dao.system.RoleMenuDao;
import com.haoze.model.system.RoleEntity;
import com.haoze.model.system.RoleMenuEntity;
import com.haoze.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/5/2.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleMapper;
    @Autowired
    RoleMenuDao roleMenuMapper;

    @Override
    public RoleEntity get(Long id) {
        return roleMapper.get(id);
    }

    @Override
    public List<RoleEntity> list() {
        return roleMapper.list(new HashMap());
    }

    @Transactional
    public int save(RoleEntity role) {

        int count = roleMapper.save(role);
        List<Long> menuIds = role.getMenuIds();
        Long roleId = role.getRoleId();
        List<RoleMenuEntity> roleMenus = new ArrayList();
        for (Long menuId : menuIds) {
            RoleMenuEntity rmDo = new RoleMenuEntity();
            rmDo.setRoleId(roleId);
            rmDo.setMenuId(menuId);
            roleMenus.add(rmDo);
        }
        roleMenuMapper.removeByRoleId(roleId);
        if (roleMenus.size() > 0) {
            roleMenuMapper.batchSave(roleMenus);
        }
        return count;
    }
}

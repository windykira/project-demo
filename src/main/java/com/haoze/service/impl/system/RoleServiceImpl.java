package com.haoze.service.impl.system;

import com.haoze.dao.system.RoleDao;
import com.haoze.model.system.RoleEntity;
import com.haoze.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/5/2.
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleDao roleMapper;

    @Override
    public List<RoleEntity> list() {
        return roleMapper.list(new HashMap());
    }
}

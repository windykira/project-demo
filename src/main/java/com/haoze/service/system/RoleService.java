package com.haoze.service.system;

import com.haoze.model.system.entity.RoleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/5/2.
 */
@Service
public interface RoleService {

    RoleEntity get(Long id);
    List<RoleEntity> list();
    int save(RoleEntity role);
    List<RoleEntity> list(Long userId);
    int update(RoleEntity role);
}

package com.haoze.service.system;

import com.haoze.model.system.RoleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/5/2.
 */
@Service
public interface RoleService {

    List<RoleEntity> list();
}

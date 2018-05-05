package com.haoze.dao.system;

import com.haoze.model.system.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/2.
 */
@Mapper
public interface RoleDao {

    RoleEntity get(Long roleId);
    List<RoleEntity> list(Map<String,Object> map);
    int save(RoleEntity role);
    int update(RoleEntity role);

}

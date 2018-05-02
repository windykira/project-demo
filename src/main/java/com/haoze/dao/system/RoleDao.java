package com.haoze.dao.system;

import com.haoze.model.system.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/2.
 */
@Mapper
public interface RoleDao {

    List<RoleEntity> list(Map<String,Object> map);
}

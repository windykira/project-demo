package com.haoze.dao.system;

import com.haoze.model.system.entity.DepartmentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 部门数据操作类。
 * @author maxl 2018-04-27。
 */
@Mapper
public interface DepartmentDao {

    List<DepartmentEntity> list(Map<String,Object> map);
    DepartmentEntity get(Long deptId);
}

package com.haoze.dao.system;

import com.haoze.model.system.RoleMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色菜单关联数据操作类。
 * @author maxl 2018-05-03。
 */
@Mapper
public interface RoleMenuDao {

    int removeByRoleId(Long roleId);

    int batchSave(List<RoleMenuEntity> list);
}
package com.haoze.dao.system;

import com.haoze.model.system.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by haoz-dev4 on 2018/5/5.
 */
@Mapper
public interface UserRoleDao {

    List<Long> listRoleId(Long userId);
    int removeByUserId(Long userId);
    int batchSave(List<UserRoleEntity> list);
}

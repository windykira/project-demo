package com.haoze.dao.system;

import com.haoze.model.system.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户数据操作类。
 * @author maxl 2018-04-27。
 */
@Mapper
public interface UserDao {

    List<UserEntity> list(Map<String,Object> map);
    int count(Map<String,Object> map);
}

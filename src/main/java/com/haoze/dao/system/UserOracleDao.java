package com.haoze.dao.system;

import com.github.pagehelper.Page;
import com.haoze.model.system.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 用户数据操作类。
 * @author maxl
 * @time 2018-05-04。
 */
@Mapper
public interface UserOracleDao {

    Page<UserEntity> listByPage();
    int countForOracle(Map<String,Object> map);
}

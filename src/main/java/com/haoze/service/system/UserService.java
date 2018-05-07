package com.haoze.service.system;

import com.github.pagehelper.Page;
import com.haoze.model.system.entity.UserEntity;
import com.haoze.model.system.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户数据服务接口。
 * @author maxl
 * @time 2018-05-02。
 */
@Service
public interface UserService {

    /**
     * 查询用户列表信息
     * @param map
     * @return
     */
    List<UserEntity> list(Map<String, Object> map);

    /**
     * 统计用户数量
     * @param map
     * @return
     */
    int count(Map<String, Object> map);

    Page<UserEntity> listByPage(int pageNo, int pageSize);

    UserEntity get(Long id);

    int update(UserEntity user);

    int adminResetPwd(UserVO UserVo) throws Exception;
}

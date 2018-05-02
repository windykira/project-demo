package com.haoze.service.system;

import com.haoze.common.model.Tree;
import com.haoze.model.system.DepartmentEntity;
import org.springframework.stereotype.Service;

/**
 * 部门数据服务接口。
 * @author maxl 2018-05-02。
 */
@Service
public interface DepartmentService {

    Tree<DepartmentEntity> getTree();
}

package com.haoze.controller.system;

import com.haoze.common.controller.BaseController;
import com.haoze.common.model.Tree;
import com.haoze.model.system.DepartmentEntity;
import com.haoze.service.system.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户部门控制器信息。
 * @author maxl 2018-05-02。
 */
@Controller
@RequestMapping("/system/sysDept")
public class DepartmentController extends BaseController{

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/tree")
    @ResponseBody
    public Tree<DepartmentEntity> tree() {
        Tree<DepartmentEntity> tree = departmentService.getTree();
        return tree;
    }
}

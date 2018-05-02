package com.haoze.controller.system;

import com.haoze.common.model.QueryParam;
import com.haoze.model.system.UserEntity;
import com.haoze.service.system.UserService;
import com.haoze.utils.PageUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 用户相关控制器信息。
 * @author maxl 2018-05-02。
 */
@RequestMapping("/sys/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    private String prefix="system/user";

    @RequiresPermissions("sys:user:user")
    @GetMapping("")
    String user(Model model) {
        return prefix + "/user";
    }

    @GetMapping("/list")
    @ResponseBody
    PageUtil list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        QueryParam queryParam = new QueryParam(params);
        List<UserEntity> sysUserList = userService.list(queryParam);
        int total = userService.count(queryParam);
        PageUtil pageUtil = new PageUtil(sysUserList, total);
        return pageUtil;
    }
}

package com.haoze.controller.system;

import com.haoze.common.annotation.Note;
import com.haoze.common.controller.BaseController;
import com.haoze.common.model.AjaxResult;
import com.haoze.common.model.Constant;
import com.haoze.model.system.entity.RoleEntity;
import com.haoze.service.system.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户角色控制器信息。
 * @author maxl
 * @time 2018-05-03。
 */
@RequestMapping("/sys/role")
@Controller
public class RoleController extends BaseController{

    String prefix = "system/role";
    @Autowired
    RoleService roleService;

    @RequiresPermissions("sys:role:role")
    @GetMapping()
    String role() {
        return prefix + "/role";
    }

    @RequiresPermissions("sys:role:role")
    @GetMapping("/list")
    @ResponseBody()
    List<RoleEntity> list() {
        List<RoleEntity> roles = roleService.list();
        return roles;
    }

    @Note("添加角色")
    @RequiresPermissions("sys:role:add")
    @GetMapping("/add")
    String add() {
        return prefix + "/add";
    }

    @Note("编辑角色")
    @RequiresPermissions("sys:role:edit")
    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        RoleEntity roleDO = roleService.get(id);
        model.addAttribute("role", roleDO);
        return prefix + "/edit";
    }

    @Note("保存角色")
    @RequiresPermissions("sys:role:add")
    @PostMapping("/save")
    @ResponseBody()
    AjaxResult save(RoleEntity role) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return AjaxResult.failure(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (roleService.save(role) > 0) {
            return AjaxResult.success();
        } else {
            return AjaxResult.failure(1, "保存失败");
        }
    }

    @Note("更新角色")
    @RequiresPermissions("sys:role:edit")
    @PostMapping("/update")
    @ResponseBody()
    AjaxResult update(RoleEntity role) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return AjaxResult.failure(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (roleService.update(role) > 0) {
            return AjaxResult.success();
        } else {
            return AjaxResult.failure(1, "保存失败");
        }
    }
}

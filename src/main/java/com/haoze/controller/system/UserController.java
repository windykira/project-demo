package com.haoze.controller.system;

import com.haoze.common.annotation.Note;
import com.haoze.common.controller.BaseController;
import com.haoze.common.model.AjaxResult;
import com.haoze.common.model.Constant;
import com.haoze.common.model.QueryParam;
import com.haoze.model.system.entity.RoleEntity;
import com.haoze.model.system.entity.UserEntity;
import com.haoze.model.system.vo.UserVO;
import com.haoze.service.system.RoleService;
import com.haoze.service.system.UserService;
import com.haoze.utils.PageUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户相关控制器信息。
 * @author maxl 2018-05-02。
 */
@RequestMapping("/sys/user")
@Controller
public class UserController extends BaseController{

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

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

    @GetMapping("/listByPage")
    @ResponseBody
    PageUtil listForPage(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        /*QueryParam queryParam = new QueryParam(params);
        Page<UserEntity> sysUserList = userService.listByPage(queryParam.getPage(),queryParam.getLimit());
        int total = userService.count(queryParam);
        PageUtil pageUtil = new PageUtil(sysUserList, total);
        new PaginationResult(sysUserList);
        return pageUtil;*/
        return null;
    }

    @RequiresPermissions("sys:user:add")
    @Note("添加用户")
    @GetMapping("/add")
    String add(Model model) {
        List<RoleEntity> roles = roleService.list();
        model.addAttribute("roles", roles);
        return prefix + "/add";
    }

    @RequiresPermissions("sys:user:edit")
    @Note("编辑用户")
    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable("id") Long id) {
        UserEntity userDO = userService.get(id);
        model.addAttribute("user", userDO);
        List<RoleEntity> roles = roleService.list(id);
        model.addAttribute("roles", roles);
        return prefix+"/edit";
    }

    @RequiresPermissions("sys:user:edit")
    @Note("更新用户")
    @PostMapping("/update")
    @ResponseBody
    AjaxResult update(UserEntity user) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return AjaxResult.failure(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (userService.update(user) > 0) {
            return AjaxResult.success();
        }
        return AjaxResult.success();
    }

    @RequiresPermissions("sys:user:resetPwd")
    @Note("请求更改用户密码")
    @GetMapping("/resetPwd/{id}")
    String resetPwd(@PathVariable("id") Long userId, Model model) {

        UserEntity userDO = new UserEntity();
        userDO.setUserId(userId);
        model.addAttribute("user", userDO);
        return prefix + "/reset_pwd";
    }

    @RequiresPermissions("sys:user:resetPwd")
    @Note("admin提交更改用户密码")
    @PostMapping("/adminResetPwd")
    @ResponseBody
    AjaxResult adminResetPwd(UserVO userVO) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return AjaxResult.failure(1, "演示系统不允许修改,完整体验请部署程序");
        }
        try{
            userService.adminResetPwd(userVO);
            return AjaxResult.success();
        }catch (Exception e){
            return AjaxResult.failure(1,e.getMessage());
        }

    }
}

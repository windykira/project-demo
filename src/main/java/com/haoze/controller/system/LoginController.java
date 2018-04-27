package com.haoze.controller.system;

import com.haoze.common.annotation.Note;
import com.haoze.common.controller.BaseController;
import com.haoze.common.entity.Tree;
import com.haoze.model.system.MenuEntity;
import com.haoze.service.system.MenuService;
import com.haoze.utils.AjaxResult;
import com.haoze.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoz-dev4 on 2018/4/27.
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    MenuService menuService;
    /*@GetMapping({ "/", "" })
    String welcome(Model model) {
        return "redirect:/blog";
    }*/

    @GetMapping({ "/", "" })
    String welcome(Model model) {

        return "system/index/main";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @Note("登录")
    @PostMapping("/login")
    @ResponseBody
    AjaxResult userLogin(String username, String password) {

        /*password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return AjaxResult.ok();
        } catch (AuthenticationException e) {
            return AjaxResult.error("用户或密码错误");
        }*/
        return AjaxResult.ok();
    }

    @Note("请求访问主页")
    @GetMapping({ "/index" })
    String index(Model model) {
        List<Tree<MenuEntity>> menus = menuService.listMenuTree(1L);

        List<Tree<MenuEntity>> newMenus = new ArrayList();
        for(Tree<MenuEntity> menuEntityTree : menus){
            if(menuEntityTree.getId().equals("1") || menuEntityTree.getId().equals("3")){
                newMenus.add(menuEntityTree);
            }
        }
        model.addAttribute("menus", newMenus);
        model.addAttribute("name", "超级管理员");
        /*FileDO fileDO = fileService.get(getUser().getPicId());
        if(fileDO!=null&&fileDO.getUrl()!=null){
            if(fileService.isExist(fileDO.getUrl())){
                model.addAttribute("picUrl",fileDO.getUrl());
            }else {
                model.addAttribute("picUrl","/img/photo_s.jpg");
            }
        }else {
            model.addAttribute("picUrl","/img/photo_s.jpg");
        }*/
        model.addAttribute("picUrl","/img/photo_s.jpg");
        model.addAttribute("username", "admin");
        return "index_v2";
    }
}

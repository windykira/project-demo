package com.haoze.controller.system;

import com.haoze.common.annotation.Note;
import com.haoze.common.controller.BaseController;
import com.haoze.common.model.AjaxResult;
import com.haoze.common.model.Constant;
import com.haoze.common.model.Tree;
import com.haoze.model.system.entity.MenuEntity;
import com.haoze.service.system.MenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 系统菜单控制器信息。
 * @author maxl 2018-05-03。
 */
@RequestMapping("/sys/menu")
@Controller
public class MenuController extends BaseController{

    String prefix = "system/menu";
    @Autowired
    MenuService menuService;

    @RequiresPermissions("sys:menu:menu")
    @GetMapping()
    String menu(Model model) {
        return prefix+"/menu";
    }

    @RequiresPermissions("sys:menu:menu")
    @RequestMapping("/list")
    @ResponseBody
    List<MenuEntity> list(@RequestParam Map<String, Object> params) {

        List<MenuEntity> menus = menuService.list(params);
        return menus;
    }

    @Note("添加菜单")
    @RequiresPermissions("sys:menu:add")
    @GetMapping("/add/{pId}")
    String add(Model model, @PathVariable("pId") Long pId) {
        model.addAttribute("pId", pId);
        if (pId == 0) {
            model.addAttribute("pName", "根目录");
        } else {
            model.addAttribute("pName", menuService.get(pId).getName());
        }
        return prefix + "/add";
    }

    @Note("保存菜单")
    @RequiresPermissions("sys:menu:add")
    @PostMapping("/save")
    @ResponseBody
    AjaxResult save(MenuEntity menu) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return AjaxResult.failure(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (menuService.save(menu) > 0) {
            return AjaxResult.success();
        } else {
            return AjaxResult.failure(1, "保存失败");
        }
    }

    @Note("编辑菜单")
    @RequiresPermissions("sys:menu:edit")
    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable("id") Long id) {
        MenuEntity menuEntity = menuService.get(id);
        Long pId = menuEntity.getParentId();
        model.addAttribute("pId", pId);
        if (pId == 0) {
            model.addAttribute("pName", "根目录");
        } else {
            model.addAttribute("pName", menuService.get(pId).getName());
        }
        model.addAttribute("menu", menuEntity);
        return prefix+"/edit";
    }

    @Note("更新菜单")
    @RequiresPermissions("sys:menu:edit")
    @PostMapping("/update")
    @ResponseBody
    AjaxResult update(MenuEntity menu) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return AjaxResult.failure(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (menuService.update(menu) > 0) {
            return AjaxResult.success();
        } else {
            return AjaxResult.failure(1, "更新失败");
        }
    }

    @Note("删除菜单")
    @RequiresPermissions("sys:menu:remove")
    @PostMapping("/remove")
    @ResponseBody
    AjaxResult remove(Long id) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return AjaxResult.failure(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (menuService.remove(id) > 0) {
            return AjaxResult.success();
        } else {
            return AjaxResult.failure(1, "删除失败");
        }
    }

    @GetMapping("/tree/{roleId}")
    @ResponseBody
    Tree<MenuEntity> tree(@PathVariable("roleId") Long roleId) {
        Tree<MenuEntity> tree = menuService.getTree(roleId);
        return tree;
    }

    @GetMapping("/tree")
    @ResponseBody
    Tree<MenuEntity> tree() {

        Tree<MenuEntity> tree = menuService.getTree();
        return tree;
    }
}

package com.haoze.service.system.impl;

import com.haoze.common.model.Tree;
import com.haoze.dao.system.MenuDao;
import com.haoze.dao.system.RoleMenuDao;
import com.haoze.model.system.entity.MenuEntity;
import com.haoze.service.system.MenuService;
import com.haoze.utils.TreeBuildUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 菜单数据服务类。
 * @author maxl 2018-04-27。
 */
@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuDao menuMapper;
	@Autowired
	RoleMenuDao roleMenuMapper;

	/**
	 * @param
	 * @return 树形菜单
	 */
	@Cacheable
	@Override
	public Tree<MenuEntity> getSysMenuTree(Long id) {
		List<Tree<MenuEntity>> trees = new ArrayList<Tree<MenuEntity>>();
		List<MenuEntity> MenuEntitys = menuMapper.listMenuByUserId(id);
		for (MenuEntity sysMenuEntity : MenuEntitys) {
			Tree<MenuEntity> tree = new Tree<MenuEntity>();
			tree.setId(sysMenuEntity.getMenuId().toString());
			tree.setParentId(sysMenuEntity.getParentId().toString());
			tree.setText(sysMenuEntity.getName());
			Map<String, Object> attributes = new HashMap<>(16);
			attributes.put("url", sysMenuEntity.getUrl());
			attributes.put("icon", sysMenuEntity.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<MenuEntity> t = TreeBuildUtil.build(trees);
		return t;
	}

	@Override
	public List<MenuEntity> list(Map<String, Object> params) {
		List<MenuEntity> menus = menuMapper.list(params);
		return menus;
	}

	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public int remove(Long id) {
		int result = menuMapper.remove(id);
		return result;
	}
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public int save(MenuEntity menu) {
		int r = menuMapper.save(menu);
		return r;
	}

	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public int update(MenuEntity menu) {
		int r = menuMapper.update(menu);
		return r;
	}

	@Override
	public MenuEntity get(Long id) {
		MenuEntity MenuEntity = menuMapper.get(id);
		return MenuEntity;
	}

	@Override
	public Tree<MenuEntity> getTree() {

		List<Tree<MenuEntity>> trees = new ArrayList();
		List<MenuEntity> MenuEntitys = menuMapper.list(new HashMap());
		for (MenuEntity sysMenuEntity : MenuEntitys) {
			Tree<MenuEntity> tree = new Tree();
			tree.setId(sysMenuEntity.getMenuId().toString());
			tree.setParentId(sysMenuEntity.getParentId().toString());
			tree.setText(sysMenuEntity.getName());
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<MenuEntity> t = TreeBuildUtil.build(trees);
		return t;
	}

	@Override
	public Tree<MenuEntity> getTree(Long id) {
		// 根据roleId查询权限
		List<MenuEntity> menus = menuMapper.list(new HashMap<String, Object>(16));
		List<Long> menuIds = roleMenuMapper.listMenuIdByRoleId(id);
		List<Long> temp = menuIds;
		for (MenuEntity menu : menus) {
			if (temp.contains(menu.getParentId())) {
				menuIds.remove(menu.getParentId());
			}
		}
		List<Tree<MenuEntity>> trees = new ArrayList();
		List<MenuEntity> MenuEntitys = menuMapper.list(new HashMap<String, Object>(16));
		for (MenuEntity sysMenuEntity : MenuEntitys) {
			Tree<MenuEntity> tree = new Tree();
			tree.setId(sysMenuEntity.getMenuId().toString());
			tree.setParentId(sysMenuEntity.getParentId().toString());
			tree.setText(sysMenuEntity.getName());
			Map<String, Object> state = new HashMap<>(16);
			Long menuId = sysMenuEntity.getMenuId();
			if (menuIds.contains(menuId)) {
				state.put("selected", true);
			} else {
				state.put("selected", false);
			}
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<MenuEntity> t = TreeBuildUtil.build(trees);
		return t;
	}

	@Override
	public Set<String> listPerms(Long userId) {
		List<String> perms = menuMapper.listUserPerms(userId);
		Set<String> permsSet = new HashSet<>();
		for (String perm : perms) {
			if (StringUtils.isNotBlank(perm)) {
				permsSet.addAll(Arrays.asList(perm.trim().split(",")));
			}
		}
		return permsSet;
	}

	@Override
	public List<Tree<MenuEntity>> listMenuTree(Long id) {

		List<Tree<MenuEntity>> trees = new ArrayList();
		List<MenuEntity> MenuEntitys = menuMapper.listMenuByUserId(id);
		for (MenuEntity sysMenuEntity : MenuEntitys) {
			Tree<MenuEntity> tree = new Tree<MenuEntity>();
			tree.setId(sysMenuEntity.getMenuId().toString());
			tree.setParentId(sysMenuEntity.getParentId().toString());
			tree.setText(sysMenuEntity.getName());
			Map<String, Object> attributes = new HashMap<>(16);
			attributes.put("url", sysMenuEntity.getUrl());
			attributes.put("icon", sysMenuEntity.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		List<Tree<MenuEntity>> list = TreeBuildUtil.buildList(trees, "0");
		return list;
	}

}

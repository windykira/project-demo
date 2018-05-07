package com.haoze.service.system;

import com.haoze.common.model.Tree;
import com.haoze.model.system.entity.MenuEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 菜单数据服务接口。
 * @author maxl
 * @time 2018-04-27。
 */
@Service
public interface MenuService {
	Tree<MenuEntity> getSysMenuTree(Long id);

	List<Tree<MenuEntity>> listMenuTree(Long id);

	Tree<MenuEntity> getTree();

	Tree<MenuEntity> getTree(Long id);

	List<MenuEntity> list(Map<String, Object> params);

	int remove(Long id);

	int save(MenuEntity menu);

	int update(MenuEntity menu);

	MenuEntity get(Long id);

	Set<String> listPerms(Long userId);
}

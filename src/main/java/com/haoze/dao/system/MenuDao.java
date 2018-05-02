package com.haoze.dao.system;

import com.haoze.model.system.MenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 菜单数据操作类。
 * @author maxl 2018-04-27。
 */
@Mapper
public interface MenuDao {

	MenuEntity get(Long menuId);
	
	List<MenuEntity> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MenuEntity menu);
	
	int update(MenuEntity menu);
	
	int remove(Long menuId);
	
	int batchRemove(Long[] menuIds);
	
	List<MenuEntity> listMenuByUserId(Long id);
	
	List<String> listUserPerms(Long id);
}

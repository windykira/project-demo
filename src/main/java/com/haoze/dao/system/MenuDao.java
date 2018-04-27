package com.haoze.dao.system;

import com.haoze.model.system.MenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 09:45:09
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

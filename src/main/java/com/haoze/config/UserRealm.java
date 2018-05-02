package com.haoze.config;

import com.haoze.model.system.UserEntity;
import com.haoze.utils.ShiroUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 用户授权认证信息。
 * @author maxl 2018-04-27。
 */
public class UserRealm extends AuthorizingRealm {

	/*@Autowired
	UserDao userMapper;
	@Autowired
	MenuService menuService;*/

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		Long userId = ShiroUtil.getUserId();
		//MenuService menuService = ApplicationContextRegister.getBean(MenuService.class);
		//Set<String> perms = menuService.listPerms(userId);
		Set<String> perms = new HashSet();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(perms);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		Map<String, Object> map = new HashMap(16);
		map.put("username", username);
		String password = new String((char[]) token.getCredentials());

		//UserEntity userMapper = ApplicationContextRegister.getBean(UserDao.class);
		// 查询用户信息
		//UserDO user = userMapper.list(map).get(0);

		// 账号不存在
		/*if (user == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}*/

		// 密码错误
		/*if (!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("账号或密码不正确");
		}*/

		// 账号锁定
		/*if (user.getStatus() == 0) {
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}*/
		UserEntity user = new UserEntity();
		user.setUserId(1L);
		user.setName("超级管理员");
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

}

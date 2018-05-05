package com.haoze.common.controller;

import com.haoze.model.system.entity.UserEntity;
import com.haoze.utils.ShiroUtil;
import org.springframework.stereotype.Controller;

/**
 * 基础Controller。
 * @author maxl 2018-04-27。
 */
@Controller
public class BaseController {

	public UserEntity getUser() {
		return ShiroUtil.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}
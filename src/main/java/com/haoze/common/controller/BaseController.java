package com.haoze.common.controller;

import com.haoze.model.system.UserEntity;
import com.haoze.utils.ShiroUtils;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

	public UserEntity getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}
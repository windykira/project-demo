package com.haoze.model.system.vo;

import com.haoze.model.system.entity.UserEntity;

/**
 * Created by haoz-dev4 on 2018/5/5.
 */
public class UserVO {

    /**
     * 更新的用户对象
     */
    private UserEntity userEntity = new UserEntity();
    /**
     * 旧密码
     */
    private String pwdOld;
    /**
     * 新密码
     */
    private String pwdNew;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getPwdOld() {
        return pwdOld;
    }

    public void setPwdOld(String pwdOld) {
        this.pwdOld = pwdOld;
    }

    public String getPwdNew() {
        return pwdNew;
    }

    public void setPwdNew(String pwdNew) {
        this.pwdNew = pwdNew;
    }
}

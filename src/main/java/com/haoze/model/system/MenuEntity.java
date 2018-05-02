package com.haoze.model.system;

import java.io.Serializable;
import java.util.Date;
/**
 * 菜单数据基本信息。
 * @author maxl 2018-04-27。
 */
public class MenuEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long menuId;
    private Long parentId;// 父菜单ID，一级菜单为0
    private String name;// 菜单名称
    private String url;// 菜单URL
    private String perms;// 授权(多个用逗号分隔，如：user:list,user:create)
    private Integer type;// 类型 0：目录 1：菜单 2：按钮
    private String icon;// 菜单图标
    private Integer orderNum;// 排序
    private Date gmtCreate;// 创建时间
    private Date gmtModified;// 修改时间

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getPerms() {
        return perms;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    @Override
    public String toString() {
        return "MenuEntity{" +
                "menuId=" + menuId +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", perms='" + perms + '\'' +
                ", type=" + type +
                ", icon='" + icon + '\'' +
                ", orderNum=" + orderNum +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}

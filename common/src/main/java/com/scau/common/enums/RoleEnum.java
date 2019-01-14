/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */
package com.scau.common.enums;
/**
 * 角色枚举类
 * @author showtime
 * @date 2019/1/12 20:56
 * @version V1.0
 */
public enum RoleEnum {
    STUDENT("ROLE_STUDENT"),TEACHER("ROLE_TEACHER"),ADMINI("ROLE_ADMIN"),SUPER_ADMIN("ROLE_SUPER_ADMIN");
    private final String name;

    private RoleEnum(String name)
    {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

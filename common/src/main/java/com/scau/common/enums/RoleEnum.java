/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */
package com.scau.common.enums;

import com.scau.common.exception.BusinessException;
import com.scau.common.exception.ExceptionCode;

/**
 * 角色枚举类
 * @author showtime
 * @date 2019/1/12 20:56
 * @version V1.0
 */
public enum RoleEnum {
    STUDENT("ROLE_STUDENT",0),TEACHER("ROLE_TEACHER",1),ADMINI("ROLE_ADMIN",2),SUPER_ADMIN("ROLE_SUPER_ADMIN",3);
    private final String name;
    private  Integer index;
     RoleEnum(String name,Integer index)
    {
        this.name = name;
        this.index = index;
    }
    public String getName() {
        return name;
    }
    public Integer getIndex(){
         return this.index;
    }
   public static String getName(Integer index){
         for (RoleEnum r : RoleEnum.values()){
             if (r.getIndex().equals(index)){
                 return r.name;
             }
         }
    throw  new BusinessException(ExceptionCode.NO_EXIST_ROLE);
   }

}

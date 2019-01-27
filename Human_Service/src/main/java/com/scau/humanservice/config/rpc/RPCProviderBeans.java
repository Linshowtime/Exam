/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.humanservice.config.rpc;

import com.scau.common.service.human.IEchoService;
import com.scau.common.service.human.IUserService;
import com.taobao.hsf.app.spring.util.HSFSpringProviderBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 对外提供服务
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/12 17:58
 */
@Configuration
public class RPCProviderBeans {
    @Resource
    HumanRpcConfig humanRpcConfig;
    @Resource
    IEchoService echoServiceImpl;
    @Resource
    IUserService userServiceImpl;
    @Bean(initMethod = "init", name = "echoService")
    public HSFSpringProviderBean echoService() {
        HSFSpringProviderBean hsfSpringProviderBean = new HSFSpringProviderBean();
        hsfSpringProviderBean.setServiceInterface("com.scau.common.service.human.IEchoService");
        hsfSpringProviderBean.setTarget(echoServiceImpl);
        hsfSpringProviderBean.setGroup(humanRpcConfig.getServiceGroup());
        hsfSpringProviderBean.setVersion(humanRpcConfig.getVersion());
        hsfSpringProviderBean.setClientTimeout(Integer.valueOf(humanRpcConfig.getTimeout()));
        return hsfSpringProviderBean;
    }
    @Bean(initMethod = "init", name = "userService")
    public HSFSpringProviderBean userService() {
        HSFSpringProviderBean hsfSpringProviderBean = new HSFSpringProviderBean();
        hsfSpringProviderBean.setServiceInterface("com.scau.common.service.human.IUserService");
        hsfSpringProviderBean.setTarget(userServiceImpl);
        hsfSpringProviderBean.setGroup(humanRpcConfig.getServiceGroup());
        hsfSpringProviderBean.setVersion(humanRpcConfig.getVersion());
        hsfSpringProviderBean.setClientTimeout(Integer.valueOf(humanRpcConfig.getTimeout()));
        return hsfSpringProviderBean;
    }
}

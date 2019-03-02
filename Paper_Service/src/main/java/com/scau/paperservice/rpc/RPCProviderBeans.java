/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.paperservice.rpc;

import com.scau.common.service.paper.IPaperService;
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
    PaperRpcConfig paperRpcConfig;

    @Resource
    IPaperService paperServiceImpl;
    @Bean(initMethod = "init", name = "paperService")
    public HSFSpringProviderBean paperService() {
        HSFSpringProviderBean hsfSpringProviderBean = new HSFSpringProviderBean();
        hsfSpringProviderBean.setServiceInterface("com.scau.common.service.paper.IPaperService");
        hsfSpringProviderBean.setTarget(paperServiceImpl);
        hsfSpringProviderBean.setGroup(paperRpcConfig.getServiceGroup());
        hsfSpringProviderBean.setVersion(paperRpcConfig.getVersion());
        hsfSpringProviderBean.setClientTimeout(Integer.valueOf(paperRpcConfig.getTimeout()));
        return hsfSpringProviderBean;
    }
}

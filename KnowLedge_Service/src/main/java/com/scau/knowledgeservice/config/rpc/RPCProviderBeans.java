/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.knowledgeservice.config.rpc;

import com.scau.common.service.knowledge.IKnowledgeService;
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
    KnowledgeRpcConfig knowledgeRpcConfig;
    @Resource
    IKnowledgeService knowledgeServiceImpl;

    @Bean(initMethod = "init", name = "knowledgeService")
    public HSFSpringProviderBean knowledgeService() {
        HSFSpringProviderBean hsfSpringProviderBean = new HSFSpringProviderBean();
        hsfSpringProviderBean.setServiceInterface("com.scau.common.service.knowledge.IKnowledgeService");
        hsfSpringProviderBean.setTarget(knowledgeServiceImpl);
        hsfSpringProviderBean.setGroup(knowledgeRpcConfig.getServiceGroup());
        hsfSpringProviderBean.setVersion(knowledgeRpcConfig.getVersion());
        hsfSpringProviderBean.setClientTimeout(Integer.valueOf(knowledgeRpcConfig.getTimeout()));
        return hsfSpringProviderBean;
    }
}

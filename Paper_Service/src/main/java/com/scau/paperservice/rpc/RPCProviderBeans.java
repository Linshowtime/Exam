/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.paperservice.rpc;

import com.scau.common.service.knowledge.IKnowledgeService;
import com.taobao.hsf.app.spring.util.HSFSpringProviderBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.awt.print.Paper;

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


    @Bean(initMethod = "init", name = "knowledgeService")
    public HSFSpringProviderBean knowledgeService() {
        HSFSpringProviderBean hsfSpringProviderBean = new HSFSpringProviderBean();
        hsfSpringProviderBean.setServiceInterface("com.scau.common.service.");
        hsfSpringProviderBean.setTarget(knowledgeServiceImpl);
        hsfSpringProviderBean.setGroup(paperRpcConfig.getServiceGroup());
        hsfSpringProviderBean.setVersion(paperRpcConfig.getVersion());
        hsfSpringProviderBean.setClientTimeout(Integer.valueOf(paperRpcConfig.getTimeout()));
        return hsfSpringProviderBean;
    }
}

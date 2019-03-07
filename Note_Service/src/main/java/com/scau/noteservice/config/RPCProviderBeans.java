/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.noteservice.config;

import com.scau.common.service.knowledge.IKnowledgeService;
import com.scau.common.service.note.INoteService;
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
    NoteRpcConfig noteRpcConfig;
    @Resource
    INoteService noteServiceImpl;
    @Bean(initMethod = "init", name = "noteService")
    public HSFSpringProviderBean noteService() {
        HSFSpringProviderBean hsfSpringProviderBean = new HSFSpringProviderBean();
        hsfSpringProviderBean.setServiceInterface("com.scau.common.service.note.INoteService");
        hsfSpringProviderBean.setTarget(noteServiceImpl);
        hsfSpringProviderBean.setGroup(noteRpcConfig.getServiceGroup());
        hsfSpringProviderBean.setVersion(noteRpcConfig.getVersion());
        hsfSpringProviderBean.setClientTimeout(Integer.valueOf(noteRpcConfig.getTimeout()));
        return hsfSpringProviderBean;
    }
}

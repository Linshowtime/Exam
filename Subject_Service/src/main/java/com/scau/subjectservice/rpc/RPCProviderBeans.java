/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.subjectservice.rpc;

import com.scau.common.service.subject.ISubjectService;
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
    SubjectRpcConfig subjectRpcConfig;
   @Resource
    ISubjectService subjectServiceImpl;

    @Bean(initMethod = "init", name = "subjectService")
    public HSFSpringProviderBean subjectService() {
        HSFSpringProviderBean hsfSpringProviderBean = new HSFSpringProviderBean();
        hsfSpringProviderBean.setServiceInterface("com.scau.common.service.subject.ISubjectService");
        hsfSpringProviderBean.setTarget(subjectServiceImpl);
        hsfSpringProviderBean.setGroup(subjectRpcConfig.getServiceGroup());
        hsfSpringProviderBean.setVersion(subjectRpcConfig.getVersion());
        hsfSpringProviderBean.setClientTimeout(Integer.valueOf(subjectRpcConfig.getTimeout()));
        return hsfSpringProviderBean;
    }
}

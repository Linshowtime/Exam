/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.humanservice.config.rpc;

import com.scau.common.service.human.*;
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
    @Resource
    ICourseService courseServiceImpl;
    @Resource
    IOrgService orgServiceImpl;
    @Resource
    ISegmentService segmentServiceImpl;
    @Resource
    IGradeService gradeServiceImpl;
    @Resource
    IClassService classServiceImpl;
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

    @Bean(initMethod = "init", name = "courseService")
    public HSFSpringProviderBean courseService() {
        HSFSpringProviderBean hsfSpringProviderBean = new HSFSpringProviderBean();
        hsfSpringProviderBean.setServiceInterface("com.scau.common.service.human.ICourseService");
        hsfSpringProviderBean.setTarget(courseServiceImpl);
        hsfSpringProviderBean.setGroup(humanRpcConfig.getServiceGroup());
        hsfSpringProviderBean.setVersion(humanRpcConfig.getVersion());
        hsfSpringProviderBean.setClientTimeout(Integer.valueOf(humanRpcConfig.getTimeout()));
        return hsfSpringProviderBean;
    }
    @Bean(initMethod = "init", name = "orgService")
    public HSFSpringProviderBean orgService() {
        HSFSpringProviderBean hsfSpringProviderBean = new HSFSpringProviderBean();
        hsfSpringProviderBean.setServiceInterface("com.scau.common.service.human.IOrgService");
        hsfSpringProviderBean.setTarget(orgServiceImpl);
        hsfSpringProviderBean.setGroup(humanRpcConfig.getServiceGroup());
        hsfSpringProviderBean.setVersion(humanRpcConfig.getVersion());
        hsfSpringProviderBean.setClientTimeout(Integer.valueOf(humanRpcConfig.getTimeout()));
        return hsfSpringProviderBean;
    }
    @Bean(initMethod = "init", name = "segmentService")
    public HSFSpringProviderBean segmentService() {
        HSFSpringProviderBean hsfSpringProviderBean = new HSFSpringProviderBean();
        hsfSpringProviderBean.setServiceInterface("com.scau.common.service.human.ISegmentService");
        hsfSpringProviderBean.setTarget(segmentServiceImpl);
        hsfSpringProviderBean.setGroup(humanRpcConfig.getServiceGroup());
        hsfSpringProviderBean.setVersion(humanRpcConfig.getVersion());
        hsfSpringProviderBean.setClientTimeout(Integer.valueOf(humanRpcConfig.getTimeout()));
        return hsfSpringProviderBean;
    }
    @Bean(initMethod = "init", name = "gradeService")
    public HSFSpringProviderBean gradeService() {
        HSFSpringProviderBean hsfSpringProviderBean = new HSFSpringProviderBean();
        hsfSpringProviderBean.setServiceInterface("com.scau.common.service.human.IGradeService");
        hsfSpringProviderBean.setTarget(gradeServiceImpl);
        hsfSpringProviderBean.setGroup(humanRpcConfig.getServiceGroup());
        hsfSpringProviderBean.setVersion(humanRpcConfig.getVersion());
        hsfSpringProviderBean.setClientTimeout(Integer.valueOf(humanRpcConfig.getTimeout()));
        return hsfSpringProviderBean;
    }
    @Bean(initMethod = "init", name = "classService")
    public HSFSpringProviderBean classService() {
        HSFSpringProviderBean hsfSpringProviderBean = new HSFSpringProviderBean();
        hsfSpringProviderBean.setServiceInterface("com.scau.common.service.human.IClassService");
        hsfSpringProviderBean.setTarget(classServiceImpl);
        hsfSpringProviderBean.setGroup(humanRpcConfig.getServiceGroup());
        hsfSpringProviderBean.setVersion(humanRpcConfig.getVersion());
        hsfSpringProviderBean.setClientTimeout(Integer.valueOf(humanRpcConfig.getTimeout()));
        return hsfSpringProviderBean;
    }

}

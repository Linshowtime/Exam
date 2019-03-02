/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.examapi.config;

import com.taobao.hsf.app.spring.util.HSFSpringConsumerBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/12 19:15
 */
@Configuration
public class ConsumerBeans {
    @Resource
    RPCConfig rpcConfig;
    @Bean(initMethod = "init", name = "echoService")
    public HSFSpringConsumerBean echoService(){
        HSFSpringConsumerBean hsfSpringConsumerBean=new HSFSpringConsumerBean();
        hsfSpringConsumerBean.setInterface("com.scau.common.service.human.IEchoService");
        hsfSpringConsumerBean.setGroup(rpcConfig.getServiceGroup());
        hsfSpringConsumerBean.setVersion(rpcConfig.getVersion());
        hsfSpringConsumerBean.setClientTimeout(Integer.valueOf(rpcConfig.getTimeout()));
        return  hsfSpringConsumerBean;
    }

    @Bean(initMethod = "init", name = "userService")
    public HSFSpringConsumerBean userService(){
        HSFSpringConsumerBean hsfSpringConsumerBean=new HSFSpringConsumerBean();
        hsfSpringConsumerBean.setInterface("com.scau.common.service.human.IUserService");
        hsfSpringConsumerBean.setGroup(rpcConfig.getServiceGroup());
        hsfSpringConsumerBean.setVersion(rpcConfig.getVersion());
        hsfSpringConsumerBean.setClientTimeout(Integer.valueOf(rpcConfig.getTimeout()));
        return  hsfSpringConsumerBean;
    }
    @Bean(initMethod = "init", name = "knowledgeService")
    public HSFSpringConsumerBean knowledgeService(){
        HSFSpringConsumerBean hsfSpringConsumerBean=new HSFSpringConsumerBean();
        hsfSpringConsumerBean.setInterface("com.scau.common.service.knowledge.IKnowledgeService");
        hsfSpringConsumerBean.setGroup(rpcConfig.getServiceGroup());
        hsfSpringConsumerBean.setVersion(rpcConfig.getVersion());
        hsfSpringConsumerBean.setClientTimeout(Integer.valueOf(rpcConfig.getTimeout()));
        return  hsfSpringConsumerBean;
    }
    @Bean(initMethod = "init", name = "courseService")
    public HSFSpringConsumerBean courseService(){
        HSFSpringConsumerBean hsfSpringConsumerBean=new HSFSpringConsumerBean();
        hsfSpringConsumerBean.setInterface("com.scau.common.service.human.ICourseService");
        hsfSpringConsumerBean.setGroup(rpcConfig.getServiceGroup());
        hsfSpringConsumerBean.setVersion(rpcConfig.getVersion());
        hsfSpringConsumerBean.setClientTimeout(Integer.valueOf(rpcConfig.getTimeout()));
        return  hsfSpringConsumerBean;
    }
    @Bean(initMethod = "init", name = "orgService")
    public HSFSpringConsumerBean orgService(){
        HSFSpringConsumerBean hsfSpringConsumerBean=new HSFSpringConsumerBean();
        hsfSpringConsumerBean.setInterface("com.scau.common.service.human.IOrgService");
        hsfSpringConsumerBean.setGroup(rpcConfig.getServiceGroup());
        hsfSpringConsumerBean.setVersion(rpcConfig.getVersion());
        hsfSpringConsumerBean.setClientTimeout(Integer.valueOf(rpcConfig.getTimeout()));
        return  hsfSpringConsumerBean;
    }
    @Bean(initMethod = "init", name = "segmentService")
    public HSFSpringConsumerBean segmentService(){
        HSFSpringConsumerBean hsfSpringConsumerBean=new HSFSpringConsumerBean();
        hsfSpringConsumerBean.setInterface("com.scau.common.service.human.ISegmentService");
        hsfSpringConsumerBean.setGroup(rpcConfig.getServiceGroup());
        hsfSpringConsumerBean.setVersion(rpcConfig.getVersion());
        hsfSpringConsumerBean.setClientTimeout(Integer.valueOf(rpcConfig.getTimeout()));
        return  hsfSpringConsumerBean;
    }
    @Bean(initMethod = "init", name = "gradeService")
    public HSFSpringConsumerBean gradeService(){
        HSFSpringConsumerBean hsfSpringConsumerBean=new HSFSpringConsumerBean();
        hsfSpringConsumerBean.setInterface("com.scau.common.service.human.IGradeService");
        hsfSpringConsumerBean.setGroup(rpcConfig.getServiceGroup());
        hsfSpringConsumerBean.setVersion(rpcConfig.getVersion());
        hsfSpringConsumerBean.setClientTimeout(Integer.valueOf(rpcConfig.getTimeout()));
        return  hsfSpringConsumerBean;
    }
    @Bean(initMethod = "init", name = "subjectService")
    public HSFSpringConsumerBean subjectService(){
        HSFSpringConsumerBean hsfSpringConsumerBean=new HSFSpringConsumerBean();
        hsfSpringConsumerBean.setInterface("com.scau.common.service.subject.ISubjectService");
        hsfSpringConsumerBean.setGroup(rpcConfig.getServiceGroup());
        hsfSpringConsumerBean.setVersion(rpcConfig.getVersion());
        hsfSpringConsumerBean.setClientTimeout(Integer.valueOf(rpcConfig.getTimeout()));
        return  hsfSpringConsumerBean;
    }
    @Bean(initMethod = "init", name = "paperService")
    public HSFSpringConsumerBean paperService(){
        HSFSpringConsumerBean hsfSpringConsumerBean=new HSFSpringConsumerBean();
        hsfSpringConsumerBean.setInterface("com.scau.common.service.paper.IPaperService");
        hsfSpringConsumerBean.setGroup(rpcConfig.getServiceGroup());
        hsfSpringConsumerBean.setVersion(rpcConfig.getVersion());
        hsfSpringConsumerBean.setClientTimeout(Integer.valueOf(rpcConfig.getTimeout()));
        return  hsfSpringConsumerBean;
    }
}

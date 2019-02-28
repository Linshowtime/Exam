package com.scau.subjectservice.rpc;

import com.taobao.hsf.app.spring.util.HSFSpringConsumerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-28 10:34
 */
@Configuration
public class ComsumerBeans {
    @Autowired
    SubjectRpcConfig subjectRpcConfig;
    @Bean(initMethod = "init", name = "knowledgeService")
    public HSFSpringConsumerBean knowledgeService(){
        HSFSpringConsumerBean hsfSpringConsumerBean=new HSFSpringConsumerBean();
        hsfSpringConsumerBean.setInterface("com.scau.common.service.knowledge.IKnowledgeService");
        hsfSpringConsumerBean.setGroup(subjectRpcConfig.getServiceGroup());
        hsfSpringConsumerBean.setVersion(subjectRpcConfig.getVersion());
        hsfSpringConsumerBean.setClientTimeout(Integer.valueOf(subjectRpcConfig.getTimeout()));
        return  hsfSpringConsumerBean;
    }
    @Bean(initMethod = "init", name = "courseService")
    public HSFSpringConsumerBean courseService(){
        HSFSpringConsumerBean hsfSpringConsumerBean=new HSFSpringConsumerBean();
        hsfSpringConsumerBean.setInterface("com.scau.common.service.human.ICourseService");
        hsfSpringConsumerBean.setGroup(subjectRpcConfig.getServiceGroup());
        hsfSpringConsumerBean.setVersion(subjectRpcConfig.getVersion());
        hsfSpringConsumerBean.setClientTimeout(Integer.valueOf(subjectRpcConfig.getTimeout()));
        return  hsfSpringConsumerBean;
    }
}

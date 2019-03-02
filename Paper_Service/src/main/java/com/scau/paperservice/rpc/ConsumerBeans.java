package com.scau.paperservice.rpc;

import com.taobao.hsf.app.spring.util.HSFSpringConsumerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-01 21:48
 */
@Configuration
public class ConsumerBeans {
    @Autowired
    PaperRpcConfig paperRpcConfig;
    @Bean(initMethod = "init", name = "subjectService")
    public HSFSpringConsumerBean subjectService(){
        HSFSpringConsumerBean hsfSpringConsumerBean=new HSFSpringConsumerBean();
        hsfSpringConsumerBean.setInterface("com.scau.common.service.subject.ISubjectService");
        hsfSpringConsumerBean.setGroup(paperRpcConfig.getServiceGroup());
        hsfSpringConsumerBean.setVersion(paperRpcConfig.getVersion());
        hsfSpringConsumerBean.setClientTimeout(Integer.valueOf(paperRpcConfig.getTimeout()));
        return  hsfSpringConsumerBean;
    }
}

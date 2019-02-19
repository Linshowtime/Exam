/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.knowledgeservice;

import com.taobao.pandora.boot.PandoraBootstrap;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/12 15:27
 */

@SpringBootApplication
@MapperScan(basePackages = "com.scau.knowledgeservice.mapper")
@EnableTransactionManagement
public class KnowledgeServiceApplication {
    public static void main(String[] args) {
        // 启动 Pandora Boot 用于加载 Pandora 容器
        PandoraBootstrap.run(args);
        SpringApplication.run(KnowledgeServiceApplication.class, args);
        // 标记服务启动完成,并设置线程 wait。防止业务代码运行完毕退出后，导致容器退出。
        PandoraBootstrap.markStartupAndWait();
    }
}

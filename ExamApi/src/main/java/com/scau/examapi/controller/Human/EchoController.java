/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.examapi.controller.Human;

import com.scau.common.service.human.IEchoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/12 19:28
 */
@Api(value = "Human", description ="测试")
@RestController
public class EchoController {
    @Autowired
    private IEchoService service;
    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    public String Echo(){
        return  service.echo("haha");
    }
}

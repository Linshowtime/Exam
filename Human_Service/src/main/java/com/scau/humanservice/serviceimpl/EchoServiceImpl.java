/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.humanservice.serviceimpl;

import com.scau.common.service.human.IEchoService;
import org.springframework.stereotype.Service;

/**
 * 测试实现类
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/12 14:40
 */
@Service("echoServiceImpl")
public class EchoServiceImpl implements IEchoService {
    public String echo(String string) {
        return string;
    }
}

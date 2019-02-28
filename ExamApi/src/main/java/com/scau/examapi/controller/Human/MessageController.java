/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.examapi.controller.Human;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.scau.common.util.CommonUtil;
import com.scau.examapi.Constant.ErrorCodeEnum;
import com.scau.examapi.exception.AppErrorCodeEnum;
import com.scau.examapi.exception.AppRunTimeException;
import com.scau.examapi.net.Result;
import com.scau.examapi.util.AliyunMessageUtil;
import com.scau.examapi.util.MD5Utils;
import com.scau.examapi.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 短信api接口
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/24 23:27
 */
@Api(value = "Message", description = "验证码短信服务相关接口")
@RestController
@RequestMapping("human/message/api")
public class MessageController {
    private static final String KEY = "abc123"; // KEY为自定义秘钥
    @ApiOperation(value = "发送验证码")
    @PostMapping(value = "/sendMsg")
    public Map<String, Object> sendMsg(@RequestBody Map<String, Object> requestMap) {
        String phoneNumber = requestMap.get("phoneNumber").toString();
        String randomNum = CommonUtil.createRandomNum(6);// 生成随机数
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, 5);
        String currentTime = sf.format(c.getTime());// 生成5分钟后时间，用户校验是否过期
        sendMsg(phoneNumber,randomNum); //此处执行发送短信验证码方法
        String hash = MD5Utils.getMD5Code(KEY + "@" + currentTime + "@" + randomNum);//生成MD5值
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("hash", hash);
        resultMap.put("tamp", currentTime);
        return resultMap; //将hash值和tamp时间返回给前端
    }
    @ApiOperation(value = "校验验证码")
    @PostMapping(value = "/validateNum")
    public Result validateNum(@RequestBody Map<String, Object> requestMap) {
        String requestHash = requestMap.get("hash").toString();
        String tamp = requestMap.get("tamp").toString();
        String msgNum = requestMap.get("msgNum").toString();
        String hash = MD5Utils.getMD5Code(KEY + "@" + tamp + "@" + msgNum);
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        String currentTime = sf.format(c.getTime());// 生成5分钟后时间，用户校验是否过期
        if (tamp.compareTo(currentTime) > 0) {
            if (hash.equalsIgnoreCase(requestHash)) {
                //校验成功
                return ResultUtil.success();
            } else {
                //验证码不正确，校验失败
                return ResultUtil.error(ErrorCodeEnum.INVALID_MESSAGE_CODE, "验证码不正确");
            }
        } else {
            // 超时
            return ResultUtil.error(ErrorCodeEnum.MESSAGE_CODE_TIMEOUT, "验证码过期");
        }
    }

    public void sendMsg( String phoneNumber,String randomNum)  {
        String jsonContent = "{\"code\":\"" + randomNum + "\"}";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("phoneNumber", phoneNumber);
        paramMap.put("msgSign", "林秀泰");
        paramMap.put("templateCode", "SMS_129660018");
        paramMap.put("jsonContent", jsonContent);
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = AliyunMessageUtil.sendSms(paramMap);
        } catch (ClientException e) {
            e.printStackTrace();
            throw new AppRunTimeException(AppErrorCodeEnum.MESSAGE_ERROE);
        }
        if (!(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK"))) {
            if (sendSmsResponse.getCode() == null) {
                throw new AppRunTimeException(AppErrorCodeEnum.MESSAGE_ERROE);
            }
            if (!sendSmsResponse.getCode().equals("OK")) {
                throw new AppRunTimeException(AppErrorCodeEnum.MESSAGE_ERROE);
            }
        }
    }


}

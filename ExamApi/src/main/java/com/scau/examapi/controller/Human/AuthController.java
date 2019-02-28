package com.scau.examapi.controller.Human;

import com.scau.examapi.net.Result;
import com.scau.examapi.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  用于前端页面token校验
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-24 18:37
 */
@RestController
@RequestMapping("/api/auth/")
public class AuthController {
    @GetMapping("get")
    public Result get(){
        return ResultUtil.success("TOKEN有效");
    }
}

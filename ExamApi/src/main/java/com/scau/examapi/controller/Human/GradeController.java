package com.scau.examapi.controller.Human;

import com.scau.common.service.human.IGradeService;
import com.scau.examapi.net.Result;
import com.scau.examapi.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-28 19:57
 */
@Api(value = "Human", description = "人力资源相关接口")
@RestController
@RequestMapping("/human/grade/api")
public class GradeController {
    @Autowired
    private IGradeService gradeService;
    @ApiOperation(value = "获取学科")
    @GetMapping("/getAllGrade")
    public Result getAllGrade(){
        return ResultUtil.success(gradeService.getAllGrade());
    }

}

package com.scau.examapi.controller.Human;

import com.scau.common.service.human.ICourseService;
import com.scau.examapi.net.Result;
import com.scau.examapi.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-22 09:24
 */
@Api(value = "Human", description = "人力资源相关接口")
@RestController
@RequestMapping("/human/course/api")
public class CourseController {
    @Autowired
    private ICourseService courseService;
    @ApiOperation(value = "获取学科")
    @GetMapping("/getAllCourse")
    public Result getAllCourse(){
        return ResultUtil.success(courseService.getAllCourse());
    }
    @ApiOperation(value = "根据id获取学科")
    @GetMapping("/course/{id}")
    public Result getCourse(@PathVariable Integer id){
        return ResultUtil.success(courseService.getCourseById(id));
    }

}

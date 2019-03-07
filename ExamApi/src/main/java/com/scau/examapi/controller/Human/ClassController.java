package com.scau.examapi.controller.Human;

import com.scau.common.dto.human.TClass.ClassDto;
import com.scau.common.dto.human.TClass.ClassStudentDto;
import com.scau.common.service.human.IClassService;
import com.scau.examapi.net.Result;
import com.scau.examapi.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-03 23:54
 */
@Api(value = "Human", description = "人力资源相关接口")
@RestController
@RequestMapping("/human/class/api")
public class ClassController {
    @Autowired
    private IClassService classService;
    @ApiOperation(value = "添加新班级")
    @PostMapping("/add")
    public Result add(@RequestBody ClassDto classDto){
        classService.addClass(classDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "修改班级信息")
    @PostMapping("/modify")
    public Result modify(@RequestBody ClassDto classDto){
        classService.modifyClass(classDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "获取指定教师班级")
    @GetMapping("/searchClass/{registerNo}")
    public Result searchClass(@PathVariable String registerNo){
        return ResultUtil.success(classService.searchByRegisterNo(registerNo));
    }
    @ApiOperation(value = "添加学生至班级")
    @PostMapping("/add/student")
    public Result addStudent(@RequestBody ClassStudentDto classStudentDto){
        classService.addStudentToClass(classStudentDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "从班级中删除学生")
    @PostMapping("/remove/student")
    public Result deleteStudent(@RequestBody ClassStudentDto classStudentDto){
        classService.removeStudentFromClass(classStudentDto);
        return ResultUtil.success(null);
    }
}

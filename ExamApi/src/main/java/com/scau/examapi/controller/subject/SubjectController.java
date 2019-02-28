package com.scau.examapi.controller.subject;

import com.scau.common.dto.subject.AddSubjectDto;
import com.scau.common.dto.subject.SubjectReqDto;
import com.scau.common.service.subject.ISubjectService;
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
 * @date 2019-02-28 10:50
 */
@Api(value = "Subject", description = "题目相关接口")
@RestController
@RequestMapping("/api/subject/")
public class SubjectController {
    @Autowired
    ISubjectService subjectService;
    @ApiOperation(value = "增加题目")
    @PostMapping("add")
    public Result add(@RequestBody AddSubjectDto addSubjectDto) {
        subjectService.addSubject(addSubjectDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "修改题目")
    @PostMapping("modify")
    public Result modify(@RequestBody AddSubjectDto addSubjectDto) {
        subjectService.modifySubject(addSubjectDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "删除题目")
    @GetMapping("delete/{id}")
    public Result modify(@PathVariable Integer id) {
        subjectService.removeSubjet(id);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "分页查询题目")
    @PostMapping("query/{pageNo}/{pageSize}")
    public Result query(@RequestBody SubjectReqDto subjectReqDto,@PathVariable Integer pageNo,@PathVariable Integer pageSize) {
        return ResultUtil.success(subjectService.querySubject(subjectReqDto,pageNo,pageSize));
    }
}

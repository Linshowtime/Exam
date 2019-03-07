package com.scau.examapi.controller.Paper;

import com.scau.common.dto.paper.*;
import com.scau.common.dto.paper.reponse.PaperRepDto;
import com.scau.common.dto.subject.response.SubjectDto;
import com.scau.common.protocol.PageResult;
import com.scau.common.service.paper.IPaperService;
import com.scau.examapi.net.Result;
import com.scau.examapi.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-01 15:16
 */
@Api(value = "ExamPaper", description = "试卷服务相关接口")
@RestController
@RequestMapping("/api/paper/")
public class PaperController {
    @Autowired
    IPaperService paperService;
    @ApiOperation(value = "增加试卷")
    @PostMapping("add")
    public Result add(@RequestBody AddPaperDto addPaperDto) {
        paperService.addPaper(addPaperDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "修改试卷")
    @PostMapping("modify")
    public Result modify(@RequestBody PaperReqDto paperReqDto) {
        paperService.modifyPaper(paperReqDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "删除试卷")
    @GetMapping("delete/{id}")
    public Result delete(@PathVariable Integer id) {
        paperService.deletePaper(id);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "分页查询试卷")
    @PostMapping("/query/{pageNo}/{pageSize}")
    public Result queryPaper(@RequestBody PaperReqDto paperReqDto, @PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        PageResult<PaperRepDto> paperRepDtoPageResult = paperService.queryPaper(paperReqDto, pageNo, pageSize);
        return ResultUtil.success(paperRepDtoPageResult);
    }
    @ApiOperation(value = "增加题目至试卷")
    @PostMapping("add/subject")
    public Result addSubject(@RequestBody SubjectExamDto subjectExamDto) {
        paperService.addSubjectToPaper(subjectExamDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "从试卷中删除题目")
    @PostMapping("delete/subject")
    public Result deleteSubject(@RequestBody SubjectExamDto subjectExamDto) {
        paperService.deleteSubjectFromPaper(subjectExamDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "更新试卷题目信息")
    @PostMapping("update/subject")
    public Result updateSubject(@RequestBody List<SubjectExamDto> subjectExamDtos) {
        paperService.updateSubjectToPaper(subjectExamDtos);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "查询试卷已有的题目id")
    @GetMapping("subjectId/{paperId}")
    public Result selectSubjectIds(@PathVariable Integer paperId) {
        return ResultUtil.success( paperService.searchSubjectIds(paperId));
    }
    @ApiOperation(value = "查询试卷题目信息")
    @GetMapping("subject/{paperId}")
    public Result selectSubjects(@PathVariable Integer paperId) {
        return ResultUtil.success( paperService.searchSubjects(paperId));
    }
    @ApiOperation(value = "发布考试")
    @PostMapping("add/exam/record")
    public Result addExamRecord(@RequestBody ExamRecordDto examRecordDto) {
        paperService.addExamRecord(examRecordDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "获取考试信息")
    @PostMapping("get/exam/record")
    public Result getExamRecord(@RequestBody ExamReqDto examReqDto) {
        return ResultUtil.success(paperService.searchExamRecord(examReqDto));
    }
    @ApiOperation(value = "提交考试试卷")
    @PostMapping("submit/record/answer/{recordId}")
    public Result submitRecordAnswer(@RequestBody List<SubjectDto> subjectDtos,@PathVariable Integer recordId) {
        paperService.submitExamAnswer(recordId,subjectDtos);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "获取考试结果")
    @GetMapping("exam/result/{recordId}")
    public Result getExamResult(@PathVariable Integer recordId) {
        return ResultUtil.success( paperService.getExamResult(recordId));
    }
    @ApiOperation(value = "获取错题本")
    @GetMapping("record/error/{registerNo}")
    public Result getErrorRecord(@PathVariable String registerNo) {
        return ResultUtil.success( paperService.searchErrorSubject(registerNo));
    }
}

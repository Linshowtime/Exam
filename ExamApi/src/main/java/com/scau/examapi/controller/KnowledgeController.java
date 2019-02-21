package com.scau.examapi.controller;

import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import com.scau.common.dto.knowledge.AddKnowledgeDto;
import com.scau.common.dto.knowledge.Response.KnowledgeDto;
import com.scau.common.dto.knowledge.UpdateKnowledgeDto;
import com.scau.common.protocol.PageResult;
import com.scau.common.service.knowledge.IKnowledgeService;
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
 * @date 2019-02-21 21:13
 */
@Api(value = "Knowledge", description = "知识点相关接口")
@RestController
@RequestMapping("/api/knowledge/")
public class KnowledgeController {
    @Autowired
    private IKnowledgeService knowledgeService;

    @ApiOperation(value = "增加知识点")
    @PostMapping("add")
    public Result add(@RequestBody AddKnowledgeDto addKnowledgeDto) {
        knowledgeService.insert(addKnowledgeDto);
        return ResultUtil.success(null);
    }

    @ApiOperation(value = "更新知识点")
    @PostMapping("update")
    public Result update(@RequestBody UpdateKnowledgeDto updateKnowledgeDto) {
        knowledgeService.update(updateKnowledgeDto);
        return ResultUtil.success(null);
    }

    @ApiOperation(value = "删除知识点")
    @GetMapping("delete/{knowledgeId}")
    public Result delete(@PathVariable("knowledgeId") String knowledgeId) {
        if (StringUtils.isEmpty(knowledgeId)) {
            return ResultUtil.error(400, "知识点id不能为空");
        }
        knowledgeService.delete(knowledgeId);
        return ResultUtil.success(null);
    }

    @ApiOperation(value = "分页查询知识点")
    @PostMapping("/query/{pageNo}/{pageSize}")
    public Result queryKnowledge(@RequestBody UpdateKnowledgeDto knowledge, @PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        PageResult<KnowledgeDto> knowledgeDtoPageResult = knowledgeService.queryKnowledge(knowledge, pageNo, pageSize);
        return ResultUtil.success(knowledgeDtoPageResult);
    }


}

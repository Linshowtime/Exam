package com.scau.examapi.controller.Human;

import com.scau.common.service.human.ISegmentService;
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
 * @date 2019-02-27 09:32
 */
@Api(value = "Human", description = "人力资源相关接口")
@RestController
@RequestMapping("/human/segment/api")
public class SegmentController {
    @Autowired
    private ISegmentService segmentService;
    @ApiOperation(value = "获取学科")
    @GetMapping("/getAllSegment")
    public Result getAllSegment(){
        return ResultUtil.success(segmentService.getAllSegment());
    }
    @ApiOperation(value = "根据id获取学段")
    @GetMapping("/segment/{id}")
    public Result getSegment(@PathVariable Integer id){
        return ResultUtil.success(segmentService.getSegmentById(id));
    }
}

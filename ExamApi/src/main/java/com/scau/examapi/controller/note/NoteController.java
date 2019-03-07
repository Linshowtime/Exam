package com.scau.examapi.controller.note;

import com.scau.common.dto.note.NoteDto;
import com.scau.common.service.note.INoteService;
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
 * @date 2019-03-07 19:45
 */
@Api(value = "NoteEntity", description = "笔记服务")
@RestController
@RequestMapping("/api/note/")
public class NoteController {
    @Autowired
    INoteService noteService;
    @ApiOperation(value = "记录笔记")
    @PostMapping("save")
    public Result save(@RequestBody NoteDto noteDto) {
        noteService.addNoteRecod(noteDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "获取个人笔记")
    @GetMapping("get/{registerNo}")
    public Result get(@PathVariable String registerNo) {
        return ResultUtil.success(noteService.findNoteRecord(registerNo));
    }

}

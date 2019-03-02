package com.scau.paperservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scau.paperservice.model.ExamPaper;

import java.util.List;

public interface ExamPaperMapper extends BaseMapper<ExamPaper> {
  List<ExamPaper> queryPaper(ExamPaper examPaper);
}
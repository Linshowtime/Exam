package com.scau.common.service.paper;

import com.scau.common.dto.paper.*;
import com.scau.common.dto.paper.reponse.ExamRecordRepDto;
import com.scau.common.dto.paper.reponse.ExamResultDto;
import com.scau.common.dto.paper.reponse.PaperRepDto;
import com.scau.common.dto.subject.response.SubjectDto;
import com.scau.common.protocol.PageResult;

import java.util.List;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-01 14:39
 */
public interface IPaperService {
    void addPaper(AddPaperDto addPaperDto);
    void modifyPaper(PaperReqDto paperReqDto);
    void deletePaper(Integer id);
    PageResult<PaperRepDto> queryPaper(PaperReqDto paperReqDtoDto, Integer pageNo, Integer pageSize);
    void addSubjectToPaper(SubjectExamDto subjectExamDto);
    void deleteSubjectFromPaper(SubjectExamDto subjectExamDto);
    void updateSubjectToPaper(List<SubjectExamDto> subjectExamDtos);
    List<Integer> searchSubjectIds(Integer paperId);
    List<SubjectDto> searchSubjects(Integer paperId);
    void addExamRecord(ExamRecordDto examRecordDto);
    List<ExamRecordRepDto> searchExamRecord(ExamReqDto examReqDto);
    void submitExamAnswer(Integer recordId ,List<SubjectDto> subjectDtos);
    ExamResultDto getExamResult(Integer recordId);
    List<SubjectDto> searchErrorSubject(String registerNo);
}

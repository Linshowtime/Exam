package com.scau.common.service.subject;

import com.scau.common.dto.subject.AddSubjectDto;
import com.scau.common.dto.subject.SubjectReqDto;
import com.scau.common.dto.subject.response.SubjectDto;
import com.scau.common.protocol.PageResult;

import java.util.List;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-28 09:48
 */
public interface ISubjectService {
    void addSubject(AddSubjectDto addSubjectDto);
    void modifySubject(AddSubjectDto subjectDto);
    void removeSubjet(Integer id);
    PageResult<SubjectDto> querySubject(SubjectReqDto subjectReqDto,Integer pageNo,Integer pageSize);
    List<SubjectDto> querySubjectByIds(List<Integer> subjectIds);
}

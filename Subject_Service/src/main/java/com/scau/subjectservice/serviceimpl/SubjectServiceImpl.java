package com.scau.subjectservice.serviceimpl;


import com.github.pagehelper.PageHelper;
import com.scau.common.dto.subject.AddSubjectDto;
import com.scau.common.dto.subject.SubjectReqDto;
import com.scau.common.dto.subject.response.SubjectDto;
import com.scau.common.protocol.PageResult;
import com.scau.common.service.human.ICourseService;
import com.scau.common.service.knowledge.IKnowledgeService;
import com.scau.common.service.subject.ISubjectService;
import com.scau.subjectservice.mapper.SubjectMapper;
import com.scau.subjectservice.model.Subject;
import com.scau.subjectservice.util.PageResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 知识点服务实现类
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-20 10:35
 */
@Service("subjectServiceImpl")
public class SubjectServiceImpl implements ISubjectService {
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
   private IKnowledgeService knowledgeService;
   @Autowired
  private ICourseService courseService;
    @Override
    public void addSubject(AddSubjectDto addSubjectDto) {
        Subject subject = new Subject();
        BeanUtils.copyProperties(addSubjectDto,subject);
        subjectMapper.insert(subject);
    }

    @Override
    public void modifySubject(AddSubjectDto subjectDto) {
        Subject subject = new Subject();
        BeanUtils.copyProperties(subjectDto,subject);
        subjectMapper.updateById(subject);
    }

    @Override
    public void removeSubjet(Integer id) {
     subjectMapper.deleteById(id);
    }

    @Override
    public PageResult<SubjectDto> querySubject(SubjectReqDto subjectReqDto,Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Subject subject = new Subject();
        BeanUtils.copyProperties(subjectReqDto,subject);
        List<Subject> subjects = subjectMapper.querySubject(subject);
        List<SubjectDto> subjectDtos = new ArrayList<>(subjects.size());
        subjects.stream().forEach(e->{
              SubjectDto subjectDto = new SubjectDto();
              BeanUtils.copyProperties(e,subjectDto);
              List<String> optionLists = new ArrayList<>(4);
              if(e.getChoice1()!=null){
                optionLists.add(e.getChoice1());
            }
            if(e.getChoice2()!=null){
                optionLists.add(e.getChoice2());
            }
            if(e.getChoice3()!=null){
                optionLists.add(e.getChoice3());
            }
            if(e.getChoice4()!=null){
                optionLists.add(e.getChoice4());
            }
           subjectDto.setOptionList(optionLists);
            subjectDto.setCourseName(courseService.getCourseById(e.getCourseId()).getName());
            subjectDto.setKnowledgeName(knowledgeService.getById(e.getKnowledgeId()).getName());
           subjectDtos.add(subjectDto);
        });
        return PageResultUtil.convertPageBean(subjects,subjectDtos);
    }
}

package com.scau.paperservice.serviceimpl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.scau.common.dto.human.TClass.ClassDto;
import com.scau.common.dto.human.student.StudentDto;
import com.scau.common.dto.human.student.reponse.StudentRepDto;
import com.scau.common.dto.paper.*;
import com.scau.common.dto.paper.reponse.ExamRecordRepDto;
import com.scau.common.dto.paper.reponse.ExamResultDto;
import com.scau.common.dto.paper.reponse.PaperRepDto;
import com.scau.common.dto.subject.SubjectReqDto;
import com.scau.common.dto.subject.response.SubjectDto;
import com.scau.common.exception.ExceptionCode;
import com.scau.common.exception.bussiness.InvalidUserException;
import com.scau.common.protocol.PageResult;
import com.scau.common.service.human.IClassService;
import com.scau.common.service.human.IUserService;
import com.scau.common.service.paper.IPaperService;
import com.scau.common.service.subject.ISubjectService;
import com.scau.paperservice.mapper.*;
import com.scau.paperservice.model.ExamPaper;
import com.scau.paperservice.model.ExamRecord;
import com.scau.paperservice.model.RecordAnswer;
import com.scau.paperservice.model.SubjectExamRel;
import com.scau.paperservice.util.PageResultUtil;
import com.scau.paperservice.util.SubjectComparator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 知识点服务实现类
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-20 10:35
 */
@Service("paperServiceImpl")
public class PaperServiceImpl implements IPaperService {
    @Autowired
    private ExamPaperMapper examPaperMapper;
    @Autowired
    private ExamTypeMapper examTypeMapper;
    @Autowired
    private ISubjectService subjectService;
    @Autowired
    private SubjectExamRelMapper subjectExamRelMapper;
    @Autowired
    private ExamRecordMapper examRecordMapper;
    @Autowired
    private IUserService userService;
    @Autowired
    private IClassService classService;
    @Autowired
    private RecordAnswerMapper recordAnswerMapper;
    @Override
    public void addPaper(AddPaperDto addPaperDto) {
        ExamPaper examPaper = new ExamPaper();
        BeanUtils.copyProperties(addPaperDto,examPaper);
        examPaperMapper.insert(examPaper);
        if(Objects.equals(addPaperDto.getType(),1)){
            ExamPaper examPaper1= examPaperMapper.selectOne(new LambdaQueryWrapper<ExamPaper>().eq(ExamPaper::getName,examPaper.getName())
                    .eq(ExamPaper::getCourseId,examPaper.getCourseId())
                    .eq(ExamPaper::getOrgId,examPaper.getOrgId())
                    .eq(ExamPaper::getGradeId,examPaper.getGradeId()).last("order by create_at limit 1"));
            int count =0;//题目总数；
            if(addPaperDto.getSelectCount()!=null){
                SubjectReqDto subjectReqDto = new SubjectReqDto();
                subjectReqDto.setSubjectTypeId(2);
                subjectReqDto.setCourseId(addPaperDto.getCourseId());
                subjectReqDto.setDifficulty(addPaperDto.getDifficulty());
                PageResult<SubjectDto> subjectDtoPageResult = subjectService.querySubject(subjectReqDto,1,addPaperDto.getSelectCount());
                List<SubjectDto> subjectDtos = subjectDtoPageResult.getList();
                count+=subjectDtos.size();
                subjectDtos.stream().forEach(subjectDto -> {
                    SubjectExamRel subjectExamRel = new SubjectExamRel();
                    subjectExamRel.setSubjectId(subjectDto.getId());
                    subjectExamRel.setExamPaperId(examPaper1.getId());
                    subjectExamRel.setOrderNo(0);
                    subjectExamRel.setScore(10.0);
                    subjectExamRelMapper.insert(subjectExamRel);
                });
            }
            if(addPaperDto.getBankCount()!=null){
                SubjectReqDto subjectReqDto = new SubjectReqDto();
                subjectReqDto.setSubjectTypeId(1);
                subjectReqDto.setCourseId(addPaperDto.getCourseId());
                subjectReqDto.setDifficulty(addPaperDto.getDifficulty());
                PageResult<SubjectDto> subjectDtoPageResult = subjectService.querySubject(subjectReqDto,1,addPaperDto.getBankCount());
                List<SubjectDto> subjectDtos = subjectDtoPageResult.getList();
                count+=subjectDtos.size();
                subjectDtos.stream().forEach(subjectDto -> {
                    SubjectExamRel subjectExamRel = new SubjectExamRel();
                    subjectExamRel.setSubjectId(subjectDto.getId());
                    subjectExamRel.setExamPaperId(examPaper1.getId());
                    subjectExamRel.setOrderNo(1);
                    subjectExamRel.setScore(10.0);
                    subjectExamRelMapper.insert(subjectExamRel);
                });
            }
            if(addPaperDto.getJudgeCount()!=null){
                SubjectReqDto subjectReqDto = new SubjectReqDto();
                subjectReqDto.setSubjectTypeId(3);
                subjectReqDto.setCourseId(addPaperDto.getCourseId());
                subjectReqDto.setDifficulty(addPaperDto.getDifficulty());
                PageResult<SubjectDto> subjectDtoPageResult = subjectService.querySubject(subjectReqDto,1,addPaperDto.getJudgeCount());
                List<SubjectDto> subjectDtos = subjectDtoPageResult.getList();
                count+=subjectDtos.size();
                subjectDtos.stream().forEach(subjectDto -> {
                    SubjectExamRel subjectExamRel = new SubjectExamRel();
                    subjectExamRel.setSubjectId(subjectDto.getId());
                    subjectExamRel.setExamPaperId(examPaper1.getId());
                    subjectExamRel.setOrderNo(2);
                    subjectExamRel.setScore(10.0);
                    subjectExamRelMapper.insert(subjectExamRel);
                });
            }
            examPaper1.setScore(count*10.0);
            examPaper1.setState(1);
            examPaperMapper.updateById(examPaper1);
        }

    }

    @Override
    public void modifyPaper(PaperReqDto paperReqDto) {
    ExamPaper examPaper = new ExamPaper();
    BeanUtils.copyProperties(paperReqDto,examPaper);
    examPaperMapper.updateById(examPaper);
    }

    @Override
    @Transactional
    public void deletePaper(Integer id) {
    examPaperMapper.deleteById(id);

    }

    @Override
    public PageResult<PaperRepDto> queryPaper(PaperReqDto paperReqDto, Integer pageNo, Integer pageSize) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        PageHelper.startPage(pageNo, pageSize);
        ExamPaper examPaper = new ExamPaper();
        BeanUtils.copyProperties(paperReqDto,examPaper);
        List<ExamPaper> examPaperList = examPaperMapper.queryPaper(examPaper);
        List<PaperRepDto> paperRepDtos = new ArrayList<>(examPaperList.size());
        examPaperList.stream().forEach(e->{
            PaperRepDto paperRepDto = new PaperRepDto();
            paperRepDto.setId(e.getId());
            paperRepDto.setName(e.getName());
            paperRepDto.setType(e.getType());
            paperRepDto.setScore(e.getScore());
            paperRepDto.setCreateDate(sdf.format(e.getCreateAt()));
            paperRepDto.setPaperTypeName(examTypeMapper.selectById(e.getPaperTypeId()).getName());
            paperRepDtos.add(paperRepDto);
        });
    return PageResultUtil.convertPageBean(examPaperList,paperRepDtos);
    }

    @Override
    public void addSubjectToPaper(SubjectExamDto subjectExamDto) {
        SubjectExamRel subjectExamRel = new SubjectExamRel();
        BeanUtils.copyProperties(subjectExamDto,subjectExamRel);
        SubjectExamRel subjectExamRel1 =subjectExamRelMapper.selectOne(new LambdaQueryWrapper<SubjectExamRel>().
                eq(SubjectExamRel::getExamPaperId,subjectExamDto.getExamPaperId())
                 .eq(SubjectExamRel::getSubjectId,subjectExamDto.getSubjectId()));
        if(subjectExamRel1!=null){
            throw new InvalidUserException(ExceptionCode.EXIST_SUBJECT_IN_PAPER);
        }
        subjectExamRelMapper.insert(subjectExamRel);
    }

    @Override
    public void deleteSubjectFromPaper(SubjectExamDto subjectExamDto) {
        subjectExamRelMapper.delete(new LambdaQueryWrapper<SubjectExamRel>().eq(SubjectExamRel::getExamPaperId,subjectExamDto.getExamPaperId())
           .eq(SubjectExamRel::getSubjectId,subjectExamDto.getSubjectId()));
    }

    @Override
    @Transactional
    public void updateSubjectToPaper(List<SubjectExamDto> subjectExamDtos) {
        //先删除试卷所有题目，一次保存的题目都是都一套试卷，所以这里可以拿一个paerId即可
        subjectExamRelMapper.delete(new LambdaQueryWrapper<SubjectExamRel>().eq(SubjectExamRel::getExamPaperId,subjectExamDtos.get(0).getExamPaperId()));
        subjectExamDtos.stream().forEach(e->{
            SubjectExamRel subjectExamRel = new SubjectExamRel();
            BeanUtils.copyProperties(e,subjectExamRel);
            subjectExamRelMapper.insert(subjectExamRel);

        });
        Double Score = 0.0;
        for(SubjectExamDto subjectExamDto:subjectExamDtos){
            Score+=subjectExamDto.getScore();
        }
        ExamPaper examPaper =new ExamPaper();
        examPaper.setId(subjectExamDtos.get(0).getExamPaperId());
        examPaper.setScore(Score);
        examPaper.setState(1);
        examPaperMapper.updateById(examPaper);
    }

    @Override
    public List<Integer> searchSubjectIds(Integer paperId) {
       List<SubjectExamRel> examRels = subjectExamRelMapper.selectList(new LambdaQueryWrapper<SubjectExamRel>().
                eq(SubjectExamRel::getExamPaperId,paperId));
       List<Integer> subjectIds = new ArrayList<>(examRels.size());
        examRels.stream().forEach(e->{
            subjectIds.add(e.getSubjectId());
        });
        return subjectIds;
    }

    @Override
    public List<SubjectDto> searchSubjects(Integer paperId) {
        List<SubjectExamRel> examRels = subjectExamRelMapper.selectList(new LambdaQueryWrapper<SubjectExamRel>().
                eq(SubjectExamRel::getExamPaperId,paperId));
        List<Integer> subjectIds = new ArrayList<>(examRels.size());
        examRels.stream().forEach(e->{
            subjectIds.add(e.getSubjectId());
        });
        List<SubjectDto> subjectDtos = subjectService.querySubjectByIds(subjectIds);
        for(SubjectDto subjectDto : subjectDtos){
            for(SubjectExamRel subjectExamRel : examRels){
                if(subjectDto.getId().equals(subjectExamRel.getSubjectId())) {
                    subjectDto.setOrderNo(subjectExamRel.getOrderNo());
                    subjectDto.setScore(subjectExamRel.getScore());
                    break;
                }
            }
        }
        Collections.sort(subjectDtos,new SubjectComparator());
        return subjectDtos;
    }

    @Override
    public void addExamRecord(ExamRecordDto examRecordDto) {
        StudentDto studentDto = new StudentDto();
        studentDto.setClassId(examRecordDto.getClassId());
        PageResult<StudentRepDto> result =userService.queryStudent(studentDto,1,100);
        List<StudentRepDto> studentDtos = result.getList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        studentDtos.parallelStream().forEach(e->
        {
            ExamRecord examRecord = new ExamRecord();
            examRecord.setPaperId(examRecordDto.getPaperId());
            examRecord.setStudentNo(e.getStudentNo());
            examRecord.setTotalTime(examRecordDto.getTotalTime());
            examRecord.setStartTime(sdf.format(examRecordDto.getStartTime()));
            examRecord.setEndTime(sdf.format(examRecordDto.getEndTime()));
            examRecordMapper.insert(examRecord);
        });

    }
    @Override
    public List<ExamRecordRepDto> searchExamRecord(ExamReqDto examReqDto) {
        List<ExamRecordRepDto> examRecordRepDtos = new ArrayList<>();
       if(Objects.equals(examReqDto.getType(),0)){
           String paperName = examPaperMapper.selectById(examReqDto.getPaperId()).getName();
           List<ClassDto> classDtos = classService.searchByRegisterNo(examReqDto.getRegisterNo());
           classDtos.stream().forEach(e->{
               StudentDto studentDto = new StudentDto();
               studentDto.setClassId(e.getId());
              PageResult<StudentRepDto>  result =userService.queryStudent(studentDto,1,100);
              List<StudentRepDto> studentRepDtos = result.getList();
              studentRepDtos.stream().forEach(studentRepDto->{
               ExamRecord examRecord =   examRecordMapper.selectOne(new LambdaQueryWrapper<ExamRecord>().eq(ExamRecord::getPaperId,examReqDto.getPaperId()).
                          eq(ExamRecord::getStudentNo,studentRepDto.getStudentNo()));
                  ExamRecordRepDto examRecordRepDto = new ExamRecordRepDto();
                  BeanUtils.copyProperties(examRecord,examRecordRepDto);
                  examRecordRepDto.setPaperName(paperName);
                  examRecordRepDto.setStudentName(studentRepDto.getName());
                  examRecordRepDtos.add(examRecordRepDto);
              });

           });
       }
       else {
         StudentRepDto studentRepDto = userService.findStudentByRegisterNo(examReqDto.getRegisterNo());
         String studentName = studentRepDto.getName();
         List<ExamRecord> examRecords = examRecordMapper.selectList(new LambdaQueryWrapper<ExamRecord>()
         .eq(ExamRecord::getStudentNo,studentRepDto.getStudentNo()));
         examRecords.stream().forEach(examRecord -> {
             String paperName = examPaperMapper.selectById(examRecord.getPaperId()).getName();
             ExamRecordRepDto examRecordRepDto = new ExamRecordRepDto();
             BeanUtils.copyProperties(examRecord,examRecordRepDto);
             examRecordRepDto.setPaperName(paperName);
             examRecordRepDto.setStudentName(studentName);
             examRecordRepDtos.add(examRecordRepDto);
         });

       }
       return  examRecordRepDtos;
    }

    @Override
    public void submitExamAnswer(Integer recordId, List<SubjectDto> subjectDtos) {
    Double score = 0.0;
    for(SubjectDto e:subjectDtos)
    {
        RecordAnswer recordAnswer = new RecordAnswer();
        recordAnswer.setRecordId(recordId);
        recordAnswer.setAnswer(e.getUserAnswer());
        recordAnswer.setSubjectId(e.getId());
        if(Objects.equals(e.getAnswer(),e.getUserAnswer())){
            recordAnswer.setResult("T");
            score+=e.getScore();
        }
        else{
            recordAnswer.setResult("F");
        }
     recordAnswerMapper.insert(recordAnswer);
    }
    ExamRecord examRecord = new ExamRecord();
    examRecord.setId(recordId);
    examRecord.setScore(score);
    examRecord.setState(1);
    examRecordMapper.updateById(examRecord);
    }

    @Override
    public ExamResultDto getExamResult(Integer recordId) {
        ExamResultDto examResultDto =new ExamResultDto();
      ExamRecord examRecord = examRecordMapper.selectById(recordId);
      ExamPaper examPaper = examPaperMapper.selectById(examRecord.getPaperId());
      examResultDto.setPaperName(examPaper.getName());
      examResultDto.setScore(examPaper.getScore());
      examResultDto.setUserScore(examRecord.getScore());
      List<SubjectDto> subjectDtos = this.searchSubjects(examRecord.getPaperId());
      List<RecordAnswer> recordAnswers = recordAnswerMapper.selectList(new LambdaQueryWrapper<RecordAnswer>().eq(RecordAnswer::getRecordId,recordId));
      subjectDtos.stream().forEach(subjectDto->{
         recordAnswers.stream().forEach(recordAnswer -> {
             if(recordAnswer.getSubjectId().equals(subjectDto.getId())){
                 subjectDto.setUserAnswer(recordAnswer.getAnswer());
                 return;
             }
         });
      });
      examResultDto.setSubjectDtos(subjectDtos);
      return examResultDto;
    }
    @Override
    public List<SubjectDto> searchErrorSubject(String registerNo) {
        List<SubjectDto> results = new ArrayList<>();
        StudentRepDto student  = userService.findStudentByRegisterNo(registerNo);
        List<ExamRecord> examRecords = examRecordMapper.selectList(new LambdaQueryWrapper<ExamRecord>().eq(ExamRecord::getStudentNo,student.getStudentNo()));
        for(ExamRecord examRecord : examRecords) {
          List<RecordAnswer> recordAnswers =  recordAnswerMapper.selectList(new LambdaQueryWrapper<RecordAnswer>().eq(RecordAnswer::getRecordId,examRecord.getId()).eq(RecordAnswer::getResult,"F"));
          List<Integer> subjectIds = recordAnswers.stream().map(e->{
              return e.getSubjectId();
          }).collect(Collectors.toList());
         List<SubjectDto> subjectDtos =subjectService.querySubjectByIds(subjectIds);
            subjectDtos.stream().forEach(subjectDto -> {
                recordAnswers.stream().forEach(recordAnswer -> {
                    if(recordAnswer.getSubjectId().equals(subjectDto.getId())){
                        subjectDto.setUserAnswer(recordAnswer.getAnswer());
                        return;
                    }
                });
            });
            results.addAll(subjectDtos);
        }
      Set set = new HashSet<>(results);
      results = new ArrayList<>(set);
      return results;
    }


}

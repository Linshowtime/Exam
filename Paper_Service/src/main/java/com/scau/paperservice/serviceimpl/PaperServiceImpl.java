package com.scau.paperservice.serviceimpl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.scau.common.dto.paper.AddPaperDto;
import com.scau.common.dto.paper.PaperReqDto;
import com.scau.common.dto.paper.SubjectExamDto;
import com.scau.common.dto.paper.reponse.PaperRepDto;
import com.scau.common.dto.subject.response.SubjectDto;
import com.scau.common.protocol.PageResult;
import com.scau.common.service.paper.IPaperService;
import com.scau.common.service.subject.ISubjectService;
import com.scau.paperservice.mapper.ExamPaperMapper;
import com.scau.paperservice.mapper.ExamTypeMapper;
import com.scau.paperservice.mapper.SubjectExamRelMapper;
import com.scau.paperservice.model.ExamPaper;
import com.scau.paperservice.model.ExamType;
import com.scau.paperservice.model.SubjectExamRel;
import com.scau.paperservice.util.PageResultUtil;
import com.scau.paperservice.util.SubjectComparator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
//    @Autowired
//    private ISubjectService subjectService;
    @Autowired
    private SubjectExamRelMapper subjectExamRelMapper;
    @Override
    public void addPaper(AddPaperDto addPaperDto) {
        ExamPaper examPaper = new ExamPaper();
        BeanUtils.copyProperties(addPaperDto,examPaper);
        examPaperMapper.insert(examPaper);
    }

    @Override
    public void modifyPaper(PaperReqDto paperReqDto) {
    ExamPaper examPaper = new ExamPaper();
    BeanUtils.copyProperties(paperReqDto,examPaper);
    examPaperMapper.updateById(examPaper);
    }

    @Override
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
        subjectExamRelMapper.insert(subjectExamRel);
    }

    @Override
    public void deleteSubjectFromPaper(SubjectExamDto subjectExamDto) {
        subjectExamRelMapper.delete(new LambdaQueryWrapper<SubjectExamRel>().eq(SubjectExamRel::getExamPaperId,subjectExamDto.getExamPaperId())
           .eq(SubjectExamRel::getSubjectId,subjectExamDto.getSubjectId()));
    }

    @Override
    public void updateSubjectToPaper(List<SubjectExamDto> subjectExamDtos) {
        //先删除试卷所有题目，一次保存的题目都是都一套试卷，所以这里可以拿一个paerId即可
        subjectExamRelMapper.delete(new LambdaQueryWrapper<SubjectExamRel>().eq(SubjectExamRel::getExamPaperId,subjectExamDtos.get(0).getExamPaperId()));
        subjectExamDtos.stream().forEach(e->{
            SubjectExamRel subjectExamRel = new SubjectExamRel();
            BeanUtils.copyProperties(e,subjectExamRel);
            subjectExamRelMapper.insert(subjectExamRel);

        });
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
//        List<SubjectExamRel> examRels = subjectExamRelMapper.selectList(new LambdaQueryWrapper<SubjectExamRel>().
////                eq(SubjectExamRel::getExamPaperId,paperId));
////        List<Integer> subjectIds = new ArrayList<>(examRels.size());
////        examRels.stream().forEach(e->{
////            subjectIds.add(e.getSubjectId());
////        });
////        List<SubjectDto> subjectDtos = subjectService.querySubjectByIds(subjectIds);
////        for(SubjectDto subjectDto : subjectDtos){
////            for(SubjectExamRel subjectExamRel : examRels){
////                if(subjectDto.getId().equals(subjectExamRel.getSubjectId())) {
////                    subjectDto.setOrderNo(subjectExamRel.getOrderNo());
////                    subjectDto.setScore(subjectExamRel.getScore());
////                    break;
////                }
////            }
////        }
////        Collections.sort(subjectDtos,new SubjectComparator());
////        return subjectDtos;
        return null;
    }
}

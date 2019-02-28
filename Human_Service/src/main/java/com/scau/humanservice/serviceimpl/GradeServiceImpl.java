package com.scau.humanservice.serviceimpl;

import com.scau.common.dto.human.GradeDto;
import com.scau.common.service.human.IGradeService;
import com.scau.humanservice.mapper.GradeMapper;
import com.scau.humanservice.model.Grade;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-28 19:43
 */
@Service("gradeServiceImpl")
public class GradeServiceImpl implements IGradeService {
    @Autowired
    private GradeMapper gradeMapper;
    @Override
    public List<GradeDto> getAllGrade() {
       List<Grade> gradeList = gradeMapper.selectList(null);
       List<GradeDto> gradeDtos = new ArrayList<>(gradeList.size());
       gradeList.stream().forEach(e->{
           GradeDto gradeDto = new GradeDto();
           BeanUtils.copyProperties(e,gradeDto);
           gradeDtos.add(gradeDto);
       });
       return gradeDtos;
    }
}

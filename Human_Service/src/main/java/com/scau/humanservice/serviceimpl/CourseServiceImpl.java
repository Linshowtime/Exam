package com.scau.humanservice.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.scau.common.dto.human.CourseDto;
import com.scau.common.service.human.ICourseService;
import com.scau.humanservice.mapper.CourseMapper;
import com.scau.humanservice.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-22 09:09
 */
@Service("courseServiceImpl")
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List<CourseDto> getAllCourse() {
        List<Course> courses = courseMapper.selectList(null);
        List<CourseDto> courseDtos =new ArrayList<CourseDto>(courses.size()) ;
        courses.stream().forEach(e->{
            CourseDto courseDto = new CourseDto();
            courseDto.setId(e.getId());
            courseDto.setName(e.getCoursename());
            courseDtos.add(courseDto);
        });
        return courseDtos;
    }
}

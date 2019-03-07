package com.scau.humanservice.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.scau.common.dto.human.TClass.ClassDto;
import com.scau.common.dto.human.TClass.ClassStudentDto;
import com.scau.common.dto.human.student.reponse.StudentRepDto;
import com.scau.common.service.human.IClassService;
import com.scau.humanservice.mapper.ClassModelMapper;
import com.scau.humanservice.mapper.StudentMapper;
import com.scau.humanservice.model.ClassModel;
import com.scau.humanservice.model.Student;
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
 * @date 2019-03-03 23:44
 */
@Service("classServiceImpl")
public class ClassServiceImpl implements IClassService {
    @Autowired
    private ClassModelMapper classModelMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public void addClass(ClassDto classDto) {
        ClassModel classModel = new ClassModel();
        BeanUtils.copyProperties(classDto,classModel);
        classModel.setTRegisterNo(classDto.getRegisterNo());
        classModelMapper.insert(classModel);
    }

    @Override
    public void modifyClass(ClassDto classDto) {
        ClassModel classModel = new ClassModel();
        BeanUtils.copyProperties(classDto,classModel);
        classModelMapper.updateById(classModel);
    }

    @Override
    public List<ClassDto> searchByRegisterNo(String registerNo) {
       List<ClassModel> classModels = classModelMapper.selectList(new LambdaQueryWrapper<ClassModel>
               ().eq(ClassModel::getTRegisterNo,registerNo));
       List<ClassDto> classDtos = new ArrayList<>(classModels.size());
       classModels.stream().forEach(e->{
           ClassDto classDto = new ClassDto();
           classDto.setClassName(e.getClassName());
           classDto.setId(e.getId());
           classDto.setRegisterNo(e.getTRegisterNo());
           classDtos.add(classDto);
       });
       return classDtos;
    }

    @Override
    public void addStudentToClass(ClassStudentDto classStudentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(classStudentDto,student);
        studentMapper.update(student,new LambdaQueryWrapper<Student>().eq(Student::getStudentNo,classStudentDto.getStudentNo()));
    }

    @Override
    public void removeStudentFromClass(ClassStudentDto classStudentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(classStudentDto,student);
        student.setClassId(0);
        studentMapper.update(student,new LambdaQueryWrapper<Student>().eq(Student::getClassId,
                classStudentDto.getClassId()).eq(Student::getStudentNo,classStudentDto.getStudentNo()));
    }
}

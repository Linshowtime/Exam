package com.scau.common.service.human;

import com.scau.common.dto.human.TClass.ClassDto;
import com.scau.common.dto.human.TClass.ClassStudentDto;
import com.scau.common.dto.human.student.reponse.StudentRepDto;

import java.util.List;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-03 23:42
 */
public interface IClassService {
   void  addClass(ClassDto classDto);
   void  modifyClass(ClassDto classDto);
   List<ClassDto> searchByRegisterNo(String registerNo);
   void addStudentToClass(ClassStudentDto classStudentDto);
   void removeStudentFromClass(ClassStudentDto classStudentDto);
}

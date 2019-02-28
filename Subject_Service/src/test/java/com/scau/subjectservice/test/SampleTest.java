package com.scau.subjectservice.test;

import com.scau.common.dto.subject.AddSubjectDto;
import com.scau.common.service.subject.ISubjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-28 14:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    ISubjectService iSubjectService;
    @Test
    public void testInsert() {
        System.out.println(("----- selectAll method test ------"));
        AddSubjectDto addSubjectDto =new AddSubjectDto();
        addSubjectDto.setAnalysis("加法基础");
        addSubjectDto.setAnswer("B");
        addSubjectDto.setChoice1("A.1");
        addSubjectDto.setChoice2("B.2");
        addSubjectDto.setChoice3("C.3");
        addSubjectDto.setChoice4("D.4");
        addSubjectDto.setContent("1+1=()");
        addSubjectDto.setDifficulty(2);
        addSubjectDto.setKnowledgeId("eb80110e-37e8-11e9-974b-00163e12155f");
        addSubjectDto.setCourseId(14);
        addSubjectDto.setSubjectTypeId(2);
        iSubjectService.addSubject(addSubjectDto);


    }

}

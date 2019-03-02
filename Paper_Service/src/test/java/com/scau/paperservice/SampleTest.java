package com.scau.paperservice;

import com.scau.common.dto.paper.AddPaperDto;
import com.scau.common.dto.paper.SubjectExamDto;
import com.scau.common.service.paper.IPaperService;
import com.scau.paperservice.model.SubjectExamRel;
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
 * @date 2019-03-02 11:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    IPaperService paperService;
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        SubjectExamDto examDto =new SubjectExamDto();
        examDto.setExamPaperId(2);
        examDto.setSubjectId(2);
        paperService.addSubjectToPaper(examDto);
        System.out.print(true);
    }
}

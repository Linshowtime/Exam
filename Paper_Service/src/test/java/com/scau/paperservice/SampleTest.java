package com.scau.paperservice;

import com.scau.common.dto.paper.AddPaperDto;
import com.scau.common.dto.paper.SubjectExamDto;
import com.scau.common.service.human.IClassService;
import com.scau.common.service.human.IUserService;
import com.scau.common.service.paper.IPaperService;
import com.scau.common.service.subject.ISubjectService;
import com.scau.paperservice.mapper.ExamPaperMapper;
import com.scau.paperservice.model.ExamPaper;
import com.scau.paperservice.model.SubjectExamRel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-02 11:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class SampleTest {
    @Autowired
    ExamPaperMapper examPaperMapper;
    @MockBean
    protected ISubjectService subjectService;
    @MockBean
    protected IUserService userService;
    @MockBean
    protected IClassService classService;

    @Test
    public void testSelect() {
       ExamPaper examPaper = new ExamPaper();
       examPaper.setName("wwee");
      Assert.assertEquals( examPaperMapper.insert(examPaper),1);
    }
}

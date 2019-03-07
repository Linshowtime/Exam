package com.scau.noteservice.test;

import com.scau.common.service.note.INoteService;
import com.scau.noteservice.dao.NoteDao;
import com.scau.noteservice.model.NoteEntity;
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
 * @date 2019-03-07 18:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    NoteDao noteDao;
    @Autowired
    INoteService noteService;
    @Test
    public void testNote(){
        System.out.println(noteService.findNoteRecord("LinXiuTai").getTitle());
    }
}

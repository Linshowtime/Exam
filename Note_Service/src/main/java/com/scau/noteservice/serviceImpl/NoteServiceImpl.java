package com.scau.noteservice.serviceImpl;

import com.scau.common.dto.note.NoteDto;
import com.scau.common.service.note.INoteService;
import com.scau.noteservice.dao.NoteDao;
import com.scau.noteservice.model.NoteEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-07 16:56
 */
@Service("noteServiceImpl")
public class NoteServiceImpl implements INoteService {
    @Autowired
    private NoteDao noteDao;
    @Override
    public void addNoteRecod(NoteDto noteDto) {
        NoteEntity noteEntity = new NoteEntity();
        BeanUtils.copyProperties(noteDto,noteEntity);
        noteDao.saveNote(noteEntity);
    }

    @Override
    public NoteDto findNoteRecord(String registerNo) {
        NoteDto noteDto = new NoteDto();
       NoteEntity entity = noteDao.findNoteByRegisterNo(registerNo);
       BeanUtils.copyProperties(entity,noteDto);
       return noteDto;
    }
}

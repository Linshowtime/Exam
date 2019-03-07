package com.scau.noteservice.dao;

import com.scau.noteservice.model.NoteEntity;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-07 17:14
 */
public interface NoteDao {
    void saveNote(NoteEntity noteEntity);
    NoteEntity findNoteByRegisterNo(String registerNo);
}

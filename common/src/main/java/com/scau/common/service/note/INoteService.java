package com.scau.common.service.note;

import com.scau.common.dto.note.NoteDto;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-07 16:41
 */
public interface INoteService {
    void addNoteRecod(NoteDto noteDto);
    NoteDto findNoteRecord(String registerNo);
}

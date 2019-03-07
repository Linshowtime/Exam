package com.scau.noteservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-07 16:24
 */
@Setter
@Getter
public class NoteEntity {
    private String registerNo;
    private String title;
    private String content;
}

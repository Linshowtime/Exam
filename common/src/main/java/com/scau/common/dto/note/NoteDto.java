package com.scau.common.dto.note;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-07 16:43
 */
@Getter
@Setter
public class NoteDto implements Serializable {
    private static final long serialVersionUID = -2839734989295384165L;
    @NotNull(message = "registerNo不能为空")
    private String registerNo;
    @NotNull(message = "title不能为空")
    private String title;
    @NotNull(message = "content不能为空")
    private String content;
}

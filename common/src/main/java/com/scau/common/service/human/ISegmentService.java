package com.scau.common.service.human;

import com.scau.common.dto.human.SegmentDto;

import java.util.List;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-27 09:22
 */
public interface ISegmentService {
    List<SegmentDto> getAllSegment();
    SegmentDto getSegmentById(Integer id);

}

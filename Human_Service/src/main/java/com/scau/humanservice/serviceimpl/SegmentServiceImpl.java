package com.scau.humanservice.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.scau.common.dto.human.SegmentDto;
import com.scau.common.service.human.ISegmentService;
import com.scau.humanservice.mapper.SegmentMapper;
import com.scau.humanservice.model.Segment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-27 09:23
 */
@Service("segmentServiceImpl")
public class SegmentServiceImpl implements ISegmentService {
    @Autowired
    private SegmentMapper segmentMapper;
    @Override
    public List<SegmentDto> getAllSegment() {
        List<Segment> segments = segmentMapper.selectList(null);
        List<SegmentDto> segmentDtos = new ArrayList<>(segments.size());
        segments.stream().forEach(e->{
            SegmentDto segmentDto = new SegmentDto();
            segmentDto.setId(e.getId());
            segmentDto.setName(e.getSegmentname());
            segmentDtos.add(segmentDto);
        });
        return segmentDtos;
    }

    @Override
    public SegmentDto getSegmentById(Integer id) {
        Segment segment = segmentMapper.selectById(id);
        SegmentDto segmentDto = new SegmentDto();
        segmentDto.setId(segment.getId());
        segmentDto.setName(segment.getSegmentname());
        return segmentDto;
    }
}

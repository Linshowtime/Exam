package com.scau.knowledgeservice.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.scau.common.dto.knowledge.AddKnowledgeDto;
import com.scau.common.dto.knowledge.KnowledgeReqDto;
import com.scau.common.dto.knowledge.Response.KnowledgeDto;
import com.scau.common.dto.knowledge.UpdateKnowledgeDto;
import com.scau.common.exception.ExceptionCode;
import com.scau.common.exception.bussiness.InvalidKnowledgeException;
import com.scau.common.protocol.PageResult;
import com.scau.common.service.knowledge.IKnowledgeService;
import com.scau.knowledgeservice.mapper.KnowledgeMapper;
import com.scau.knowledgeservice.model.Knowledge;
import com.scau.knowledgeservice.util.PageResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 知识点服务实现类
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-20 10:35
 */
@Service("knowledgeImpl")
public class KnowledgeImpl implements IKnowledgeService {
    @Autowired
    private KnowledgeMapper knowledgeMapper;

    @Override
    public void insert(AddKnowledgeDto addKnowledgeDto) {
        Knowledge knowledge = new Knowledge();
        BeanUtils.copyProperties(addKnowledgeDto, knowledge);
        List<Knowledge> knowledgeList = knowledgeMapper.queryKnowledge(knowledge);
        if (knowledgeList != null && !knowledgeList.isEmpty()) {
            throw new InvalidKnowledgeException(ExceptionCode.EXIST_KNOWLEDGE);
        }
        knowledgeMapper.insert(knowledge);
    }

    @Override
    public void update(UpdateKnowledgeDto updateKnowledgeDto) {
        Knowledge knowledge = new Knowledge();
        BeanUtils.copyProperties(updateKnowledgeDto, knowledge);
        knowledgeMapper.update(knowledge);
    }

    @Override
    public void delete(String id) {
        knowledgeMapper.delete(id);
    }

    @Override
    public KnowledgeDto getById(String id) {
        Knowledge knowledge = knowledgeMapper.getById(id);
        KnowledgeDto knowledgeDto = new KnowledgeDto();
        BeanUtils.copyProperties(knowledge, knowledgeDto);
        return knowledgeDto;
    }

    @Override
    public PageResult<KnowledgeDto> queryKnowledge(KnowledgeReqDto updateKnowledgeDto, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Knowledge knowledge = new Knowledge();
        BeanUtils.copyProperties(updateKnowledgeDto, knowledge);
        List<Knowledge> knowledgeList = knowledgeMapper.queryKnowledge(knowledge);
        List<KnowledgeDto> knowledgeDtoList = new ArrayList<>(knowledgeList.size());
        knowledgeList.stream().forEach(k -> {
            KnowledgeDto knowledgeDto = new KnowledgeDto();
            BeanUtils.copyProperties(k, knowledgeDto);
            knowledgeDtoList.add(knowledgeDto);
        });
        return PageResultUtil.convertPageBean(knowledgeList, knowledgeDtoList);
    }
}

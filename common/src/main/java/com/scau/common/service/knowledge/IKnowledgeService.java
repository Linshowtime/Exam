/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.common.service.knowledge;


import com.scau.common.dto.knowledge.AddKnowledgeDto;
import com.scau.common.dto.knowledge.KnowledgeReqDto;
import com.scau.common.dto.knowledge.Response.KnowledgeDto;
import com.scau.common.dto.knowledge.UpdateKnowledgeDto;
import com.scau.common.protocol.PageResult;

public interface IKnowledgeService {

    /**
     * 插入知识点
     *
     * @param addKnowledgeDto
     * @return
     */
    void insert(AddKnowledgeDto addKnowledgeDto);

    /**
     * 更新知识点
     *
     * @param updateKnowledgeDto
     * @return
     */
    void update(UpdateKnowledgeDto updateKnowledgeDto);

    /**
     * 删除知识点
     *
     * @param id
     * @return
     */
    void delete(String id);

    /**
     * 根据主键id获取知识点
     *
     * @param id
     * @return
     */
    KnowledgeDto getById(String id);

    /**
     * 分页条件查询知识点
     *
     * @param knowledge
     * @return
     */
    PageResult<KnowledgeDto> queryKnowledge(KnowledgeReqDto knowledge, Integer pageNo, Integer pageSize);
}

/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.knowledgeservice.test;

import com.scau.common.dto.knowledge.KnowledgeReqDto;
import com.scau.common.service.knowledge.IKnowledgeService;
import com.scau.knowledgeservice.mapper.KnowledgeMapper;
import com.scau.knowledgeservice.model.Knowledge;
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
 * @date 2019/1/17 21:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private IKnowledgeService knowledgeMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        KnowledgeReqDto knowledgeReqDto =new KnowledgeReqDto();
        knowledgeReqDto.setName("qqq");
        knowledgeMapper.queryKnowledge(knowledgeReqDto,1,5);
        System.out.print(true);
    }

}
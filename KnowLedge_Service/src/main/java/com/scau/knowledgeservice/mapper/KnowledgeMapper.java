package com.scau.knowledgeservice.mapper;

import java.util.List;

import com.scau.knowledgeservice.model.Knowledge;
import org.apache.ibatis.annotations.Param;
public interface KnowledgeMapper {

    int insert(Knowledge knowledge);

    int update(Knowledge knowledge);

    int delete(@Param("id") String id);

    Knowledge getById(@Param("id") String id);

    List<Knowledge> queryKnowledge(Knowledge knowledge);

}

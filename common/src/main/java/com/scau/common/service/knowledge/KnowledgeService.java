/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.common.service.knowledge;


public interface KnowledgeService {
	
	/**
	 * 插入知识点
	 * @param knowledge
	 * @return
	 */
	int insert(Knowledge knowledge);
	
	/**
	 * 更新知识点
	 * @param knowledge
	 * @return
	 */
	int update(Knowledge knowledge);

	/**
	 * 删除知识点
	 * @param id
	 * @return
	 */
	int delete (String id);

	/**
	 * 根据主键id获取知识点
	 * @param id
	 * @return
	 */
	Knowledge getById( String id);

	/**
	 * 分页条件查询知识点
	 * @param knowledge
	 * @return
	 */
	PageInfo<Knowledge> queryKnowledge(Knowledge knowledge, Integer pageNo, Integer pageSize);
}

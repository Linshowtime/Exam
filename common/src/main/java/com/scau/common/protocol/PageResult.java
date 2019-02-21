/*
 * Copyright (c) 2018, Guangzhou Yingzi Technologies Co.Ltd. All Rights Reserved.
 */

package com.scau.common.protocol;

import java.io.Serializable;
import java.util.List;

/**
 * @author showtime
 * @version V1.0
 * @date 2010/02/20 10:20
 */

public class PageResult<T> implements Serializable {

    /**
     * 总数
     */
    private long record_total;

    /**
     * 当前页码
     */
    private int page;

    /**
     * 每页数量
     */
    private int page_size;

    /**
     * 总页数
     */
    private int page_total;

    /**
     * 列表数据
     */
    private List<T> list;

    public long getRecord_total() {
        return record_total;
    }

    public void setRecord_total(long record_total) {
        this.record_total = record_total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public int getPage_total() {
        return page_total;
    }

    public void setPage_total(int page_total) {
        this.page_total = page_total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

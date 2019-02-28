package com.scau.paperservice.util;

import com.github.pagehelper.Page;
import com.scau.common.protocol.PageResult;
import org.springframework.beans.BeanUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author showtime
 * @version V1.0
 * @date 2019/02/20 11:21
 */
public class PageResultUtil {

    /**
     * 【分页】EO数据转换成DTO
     *
     * @param sourceList 源数据列表
     * @param targetList 目标数据列表
     * @return com.yingzi.center.taskorchestration.protocol.PageResult<Target>
     * @throws
     */
    public static <Source, Target> PageResult<Target> convertPageBean(List<Source> sourceList,
                                                                      List<Target> targetList) {
        PageResult<Source> sourcePageResult = page2PageResult(sourceList);
        PageResult<Target> targetPageResult = new PageResult<>();
        BeanUtils.copyProperties(sourcePageResult, targetPageResult);
        targetPageResult.setList(targetList);
        return targetPageResult;
    }

    /**
     * PageHelper插件Page转换成PageResult
     *
     * @param list
     * @return com.yingzi.center.taskorchestration.protocol.PageResult<T>
     * @throws
     */
    public static <T> PageResult<T> page2PageResult(List<T> list) {
        PageResult<T> pageResult = new PageResult<>();
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            pageResult.setRecord_total(page.getTotal());
            pageResult.setPage(page.getPageNum());
            pageResult.setPage_size(page.getPageSize());
            pageResult.setPage_total(page.getPages());
            pageResult.setList(page.getResult());
        }
        return pageResult;
    }

    /**
     * 返回数据为空的分页bean
     *
     * @param page
     * @param page_size
     * @return com.yingzi.center.taskorchestration.protocol.PageResult<T>
     * @throws
     */
    public static <T> PageResult<T> getEmptyPageResult(int page, int page_size) {
        PageResult<T> pageResult = new PageResult();
        pageResult.setPage(page);
        pageResult.setPage_size(page_size);
        pageResult.setList(Collections.emptyList());
        return pageResult;
    }

}

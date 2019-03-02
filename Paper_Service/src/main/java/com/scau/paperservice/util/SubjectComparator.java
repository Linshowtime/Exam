package com.scau.paperservice.util;

import com.scau.common.dto.subject.response.SubjectDto;

import java.util.Comparator;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-02 09:23
 */
public class SubjectComparator implements Comparator<SubjectDto> {
    @Override
    public int compare(SubjectDto o1, SubjectDto o2) {
        // TODO Auto-generated method stub
        if(o1.getOrderNo()== null){
            o1.setOrderNo(999);
        }
        if(o2.getOrderNo()== null){
            o2.setOrderNo(999);
        }
        if(o1.getOrderNo()>o2.getOrderNo()){
            return 1;
        }else if(o1.getOrderNo() == o2.getOrderNo()){
            return 0;
        }
        return -1;
    }
    }

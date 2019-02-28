package com.scau.humanservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scau.humanservice.model.Org;

import java.util.List;

public interface OrgMapper extends BaseMapper<Org> {
List<Org> queryOrg(Org org);
}
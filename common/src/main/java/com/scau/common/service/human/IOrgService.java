package com.scau.common.service.human;

import com.scau.common.dto.human.org.OrgReqDto;
import com.scau.common.dto.human.org.Response.OrgDto;
import com.scau.common.protocol.PageResult;

import java.util.List;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-21 15:08
 */
public interface IOrgService {
  /**
   * 入驻新学校
   * @param reqDto
   * @return void
   * @throws
   * @author showtime
   * @date 2019-02-24
   */

 void insert(OrgReqDto reqDto);

 /**
  * 更新学校属性
  * @param reqDto
  * @return void
  * @throws
  * @author showtime
  * @date 2019-02-24
  */

 void update(OrgReqDto reqDto);

 /**
  * 删除学校
  * @param id
  * @return void
  * @throws
  * @author showtime
  * @date 2019-02-24
  */

 void delete(String id);

 /**
  * 分页查询学校
  * @param reqDto
 * @param pageNo
 * @param pageSize
  * @return com.scau.common.protocol.PageResult<com.scau.common.dto.human.org.Response.OrgDto>
  * @throws
  * @author showtime
  * @date 2019-02-24
  */

 PageResult<OrgDto> queryOrg(OrgReqDto reqDto, Integer pageNo, Integer pageSize);
 /**
  *
  * @param reqDto
  * @return java.util.List<com.scau.common.dto.human.org.Response.OrgDto>
  * @throws
  * @author showtime
  * @date 2019-02-24
  */

 List<OrgDto> queryOrgList(OrgReqDto reqDto);
}

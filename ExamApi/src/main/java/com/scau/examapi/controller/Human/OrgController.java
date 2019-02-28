package com.scau.examapi.controller.Human;

import com.scau.common.dto.human.org.OrgReqDto;
import com.scau.common.dto.human.org.Response.OrgDto;
import com.scau.common.protocol.PageResult;
import com.scau.common.service.human.IOrgService;
import com.scau.examapi.net.Result;
import com.scau.examapi.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-24 21:44
 */
@Api(value = "Human", description = "人力资源相关接口")
@RestController
@RequestMapping("/human/org/api")
public class OrgController {
    @Autowired
    private IOrgService orgService;
    @ApiOperation(value = "添加新学校")
    @PostMapping("add")
    public Result add(@RequestBody OrgReqDto orgReqDto) {
        orgService.insert(orgReqDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "更新学校名字")
    @PostMapping("modify")
    public Result modify(@RequestBody OrgReqDto orgReqDto) {
        orgService.update(orgReqDto);
        return ResultUtil.success(null);
    }
    @ApiOperation(value = "删除学校")
    @GetMapping("delete/{orgId}")
    public Result delete(@PathVariable("orgId") String orgId) {
        if (StringUtils.isEmpty(orgId)) {
            return ResultUtil.error(400, "知识点id不能为空");
        }
        orgService.delete(orgId);
        return ResultUtil.success(null);
    }

    @ApiOperation(value = "分页查询学校")
    @PostMapping("/query/{pageNo}/{pageSize}")
    public Result queryOrg(@RequestBody OrgReqDto orgReqDto, @PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        PageResult<OrgDto> orgDtoPageResult = orgService.queryOrg(orgReqDto, pageNo, pageSize);
        return ResultUtil.success(orgDtoPageResult);
    }
    @ApiOperation(value = "查询学校列表")
    @GetMapping("/query/list")
    public Result queryOrgList() {
        return ResultUtil.success(orgService.queryOrgList());
    }
    @ApiOperation(value = "查询学校列表")
    @GetMapping("/query/{id}")
    public Result queryOrgById(@PathVariable Integer id ) {
        return ResultUtil.success(orgService.queryOrgById(id));
    }

}




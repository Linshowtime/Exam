package com.scau.humanservice.serviceimpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.scau.common.dto.human.org.OrgReqDto;
import com.scau.common.dto.human.org.Response.OrgDto;
import com.scau.common.exception.ExceptionCode;
import com.scau.common.exception.bussiness.InvalidUserException;
import com.scau.common.protocol.PageResult;
import com.scau.common.service.human.IOrgService;
import com.scau.humanservice.mapper.OrgMapper;
import com.scau.humanservice.mapper.StudentMapper;
import com.scau.humanservice.mapper.TeacherMapper;
import com.scau.humanservice.model.Org;
import com.scau.humanservice.model.Student;
import com.scau.humanservice.model.Teacher;
import com.scau.humanservice.util.PageResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-24 12:57
 */
@Service("orgServiceImpl")
public class OrgServiceImpl implements IOrgService {
    @Autowired
    private OrgMapper orgMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public void insert(OrgReqDto reqDto) {
        Org org = orgMapper.selectOne(new QueryWrapper<Org>().eq("name", reqDto.getName()));
        if (org != null) {
            throw new InvalidUserException(ExceptionCode.EXIST_ORG);
        }
        Org org1 = new Org();
        BeanUtils.copyProperties(reqDto, org1);
        org1.setStatus(0);
        orgMapper.insert(org1);
    }

    @Override
    @Transactional
    public void update(OrgReqDto reqDto) {
        Org org = new Org();
        BeanUtils.copyProperties(reqDto, org);
        orgMapper.update(org, new QueryWrapper<Org>().eq("id", reqDto.getId()));
        Student student =new Student();
        student.setOrgId(reqDto.getId());
        student.setState(reqDto.getStatus());
        studentMapper.update(student,new QueryWrapper<Student>().eq("org_id",student.getOrgId()));
        Teacher teacher =new Teacher();
        teacher.setOrgId(reqDto.getId());
        teacher.setState(reqDto.getStatus());
        teacherMapper.update(teacher,new QueryWrapper<Teacher>().eq("org_id",teacher.getOrgId()));
    }

    @Override
    public void delete(String id) {
        orgMapper.delete(new QueryWrapper<Org>().eq("id", id));
    }

    @Override
    public PageResult<OrgDto> queryOrg(OrgReqDto reqDto, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Org org = new Org();
        BeanUtils.copyProperties(reqDto, org);
        List<Org> orgs = orgMapper.queryOrg(org);
        List<OrgDto> orgDtos = new ArrayList<>(orgs.size());
        orgs.stream().forEach(e -> {
            OrgDto orgDto = new OrgDto();
            BeanUtils.copyProperties(e, orgDto);
            orgDtos.add(orgDto);
        });
        return PageResultUtil.convertPageBean(orgs, orgDtos);
    }

    @Override
    public List<OrgDto> queryOrgList() {
        List<Org> orgs = orgMapper.selectList(new QueryWrapper<Org>().eq("status",0));
        List<OrgDto> orgDtos = new ArrayList<>(orgs.size());
        orgs.stream().forEach(e -> {
            OrgDto orgDto = new OrgDto();
            BeanUtils.copyProperties(e, orgDto);
            orgDtos.add(orgDto);
        });
        return orgDtos;
    }

    @Override
    public OrgDto queryOrgById(Integer id) {
      Org org = orgMapper.selectById(id);
      OrgDto orgDto = new OrgDto();
      BeanUtils.copyProperties(org,orgDto);
      return orgDto;
    }
}

package com.lin.cangkusp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.constant.ConResult;
import com.lin.cangkusp.common.exception.AppException;
import com.lin.cangkusp.common.utils.QueryStaffVo;
import com.lin.cangkusp.dao.StaffMapper;
import com.lin.cangkusp.pojo.Staff;
import com.lin.cangkusp.pojo.StaffExample;
import com.lin.cangkusp.pojo.Staff;
import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.TRANSACTION_REQUIRED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(timeout = 3000,readOnly = true,rollbackFor = Exception.class)
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public PageInfo<Staff> queryStaffList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Staff> staffList = staffMapper.selectByExample(null);
        return new PageInfo<>(staffList);
    }

    public PageInfo<Staff> queryStaffByExample(QueryStaffVo queryStaffVo, int pageNum, int pageSize) {
        StaffExample staffExample = new StaffExample();
        StaffExample.Criteria staffExampleCriteria = staffExample.createCriteria();
        if (StringUtils.isNotBlank(queryStaffVo.getSno())) {
            staffExampleCriteria.andSnoEqualTo(queryStaffVo.getSno());
            PageHelper.startPage(pageNum, pageSize, true, true, true);
            List<Staff> staffList = staffMapper.selectByExample(staffExample);
            return new PageInfo<>(staffList);
        }
        if (StringUtils.isNotBlank(queryStaffVo.getSname())) {
            staffExampleCriteria.andSnameLike(queryStaffVo.getSname());
        }
        if (StringUtils.isNotBlank(queryStaffVo.getSsex())){
            staffExampleCriteria.andSsexEqualTo(queryStaffVo.getSsex());
        }
        if (StringUtils.isNotBlank(queryStaffVo.getSaddress())) {
            staffExampleCriteria.andSaddressLike(queryStaffVo.getSaddress());
        }
        if (StringUtils.isNotBlank(queryStaffVo.getPtel())) {
            staffExampleCriteria.andStelLike(queryStaffVo.getPtel());
        }
        PageHelper.startPage(pageNum, pageSize, true, true, true);
        List<Staff> staffList = staffMapper.selectByExample(staffExample);
        return new PageInfo<>(staffList);
    }
    
    @Override
    public List<String> querySnoList(){
        List<Staff> staffList=null;
        try {
            staffList=staffMapper.selectByExample(null);
        }catch (Exception e){
            throw new AppException("查询失败",400);
        }
        List<String> stringList=new ArrayList<>();
        for (Staff staff:staffList){
            stringList.add(staff.getSno());
        }
        return stringList;
    }

    @Override
    @Transactional(readOnly = false)
    public int insertStaff(Staff staff) {
        try {
            int i = staffMapper.insertSelective(staff);
            return i;
        } catch (Exception e) {
            throw new AppException("增加失败！",400);
        }

    }

    @Override
    @Transactional(readOnly = false)
    public int updateStaff(Staff staff) {
        try {
            int i=staffMapper.updateByPrimaryKeySelective(staff);
            return i;
        } catch (Exception e) {
            throw new AppException("修改失败！",400);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteStaff(Staff staff) {
        try {
            int i=staffMapper.deleteByPrimaryKey(staff.getSno());
            return i;
        }catch (Exception e){
            throw new AppException("删除失败！",400);
        }

    }

    @Override
    public Staff queryStaffById(String id) {
        try {
            Staff staff=staffMapper.selectByPrimaryKey(id);
            return staff;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AppException("查询失败！",400);
        }
    }
}

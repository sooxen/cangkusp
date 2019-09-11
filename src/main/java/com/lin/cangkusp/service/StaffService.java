package com.lin.cangkusp.service;

import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.utils.QueryStaffVo;
import com.lin.cangkusp.pojo.Staff;

import java.util.List;

public interface StaffService {

    PageInfo<Staff> queryStaffList(Integer pageNum, Integer pageSize);

    PageInfo<Staff> queryStaffByExample(QueryStaffVo queryStaffVo, int pageNum, int pageSize);

    List<String> querySnoList();

    int insertStaff(Staff staff);

    int updateStaff(Staff staff);

    int deleteStaff(Staff staff);

    Staff queryStaffById(String id);
}

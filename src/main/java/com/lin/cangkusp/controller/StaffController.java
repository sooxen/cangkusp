package com.lin.cangkusp.controller;

import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.constant.ConResult;
import com.lin.cangkusp.common.utils.QueryStaffVo;
import com.lin.cangkusp.pojo.Staff;
import com.lin.cangkusp.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StaffController {
    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "/staff/search")
    @ResponseBody
    public PageInfo<Staff> queryStaffByExample(QueryStaffVo queryStaffVo,int pageNum,int pageSize){
        PageInfo<Staff> pageInfo= staffService.queryStaffByExample(queryStaffVo,pageNum,pageSize);
        return pageInfo;
    }

    @RequestMapping("staff/sno")
    @ResponseBody
    public List<String> querySnoList(){
        return staffService.querySnoList();
    }

    @RequestMapping("staff/insert")
    @ResponseBody
    public ConResult insertStaff(Staff staff){
        staffService.insertStaff(staff);
        return ConResult.ok();
    }

    @RequestMapping("staff/update")
    @ResponseBody
    public ConResult updateStaff(Staff staff){
        staffService.updateStaff(staff);
        return ConResult.ok();
    }

    @DeleteMapping("staff/delete")
    @ResponseBody
    public ConResult deleteStaff(Staff staff){
        staffService.deleteStaff(staff);
        return ConResult.ok();
    }

    @RequestMapping("staff/{id}")
    @ResponseBody
    public Staff queryStaffById(@PathVariable String id){
        return staffService.queryStaffById(id);
    }
}

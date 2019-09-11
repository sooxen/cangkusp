package com.lin.cangkusp.controller;

import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.constant.ConResult;
import com.lin.cangkusp.common.utils.QueryWarehouseVo;
import com.lin.cangkusp.pojo.Warehouse;
import com.lin.cangkusp.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @RequestMapping("/warehouse/search")
    @ResponseBody
    public PageInfo<Warehouse> queryWarehouseByExample(QueryWarehouseVo queryWarehouseVo,int pageNum, int pageSize){
        return warehouseService.queryWarehouseByExample(queryWarehouseVo,pageNum,pageSize);
    }

    @RequestMapping("warehouse/insert")
    @ResponseBody
    public ConResult insertWarehouse(Warehouse warehouse){
        warehouseService.insertWarehouse(warehouse);
        return ConResult.ok();
    }

    @RequestMapping("warehouse/update")
    @ResponseBody
    public ConResult updateWarehouse(Warehouse warehouse){
        warehouseService.updateWarehouse(warehouse);
        return ConResult.ok();
    }

    @DeleteMapping("warehouse/delete")
    @ResponseBody
    public ConResult deleteWarehouse(Warehouse warehouse){
        warehouseService.deleteWarehouse(warehouse);
        return ConResult.ok();
    }

    @RequestMapping("warehouse/{id}")
    @ResponseBody
    public Warehouse queryWarehouseById(@PathVariable String id){
        return warehouseService.queryWarehouseById(id);
    }
}

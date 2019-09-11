package com.lin.cangkusp.controller;

import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.constant.ConResult;
import com.lin.cangkusp.common.utils.QueryPerchanceVo;
import com.lin.cangkusp.pojo.Cargo;
import com.lin.cangkusp.pojo.Perchance;
import com.lin.cangkusp.pojo.Store;
import com.lin.cangkusp.service.PerchanceService;
import com.lin.cangkusp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class PerchanceController {
    @Autowired
    private PerchanceService perchanceService;
    @Autowired
    private StoreService storeService;

    @RequestMapping("/perchance/search")
    @ResponseBody
    public PageInfo<Perchance> queryPerchanceByExample(QueryPerchanceVo vo,int pageNum, int pageSize){
        return perchanceService.queryPerchanceByExample(vo,pageNum,pageSize);
    }

    @RequestMapping("perchance/insert")
    @ResponseBody
    public ConResult insertPerchance(Perchance perchance){
        perchanceService.insertPerchance(perchance);
        Store store = storeService.queryStoreByCnoAndWno(perchance.getCno(), perchance.getWno());
        store.setStnum(store.getStnum()+perchance.getPnum());
        store.setStdate(new Date());
        storeService.updateStore(store);
        return ConResult.ok();
    }

    @RequestMapping("perchance/update")
    @ResponseBody
    public ConResult updatePerchance(Perchance perchance){
        perchanceService.updatePerchance(perchance);
        return ConResult.ok();
    }

    @DeleteMapping("perchance/delete")
    @ResponseBody
    public ConResult deletePerchance(Perchance perchance){
        perchanceService.deletePerchance(perchance);
        return ConResult.ok();
    }

    @RequestMapping("/perchance/{id}")
    @ResponseBody
    public Perchance queryPerchanceById(@PathVariable String id) {
        return perchanceService.queryPerchanceById(id);
    }
}

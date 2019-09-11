package com.lin.cangkusp.controller;

import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.constant.ConResult;
import com.lin.cangkusp.common.utils.QuerySellVo;
import com.lin.cangkusp.pojo.Sell;
import com.lin.cangkusp.pojo.Store;
import com.lin.cangkusp.service.SellService;
import com.lin.cangkusp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class SellController {
    @Autowired
    private SellService sellService;
    @Autowired
    private StoreService storeService;

    @RequestMapping("/sell/search")
    @ResponseBody
    public PageInfo<Sell> querySellByExample(QuerySellVo vo, int pageNum, int pageSize){
        return sellService.querySellByExample(vo,pageNum,pageSize);
    }

    @RequestMapping("sell/insert")
    @ResponseBody
    public ConResult insertSell(Sell sell){
        sellService.insertSell(sell);
        Store store = storeService.queryStoreByCnoAndWno(sell.getCno(), sell.getWno());
        store.setStnum(store.getStnum()-sell.getSnum());
        store.setStdate(new Date());
        storeService.updateStore(store);
        return ConResult.ok();
    }

    @RequestMapping("sell/update")
    @ResponseBody
    public ConResult updateSell(Sell sell){
        sellService.updateSell(sell);
        return ConResult.ok();
    }

    @DeleteMapping("sell/delete")
    @ResponseBody
    public ConResult deleteSell(Sell sell){
        sellService.deleteSell(sell);
        return ConResult.ok();
    }

    @RequestMapping("/sell/{id}")
    @ResponseBody
    public Sell querySellById(@PathVariable String id) {
        return sellService.querySellById(id);
    }
}

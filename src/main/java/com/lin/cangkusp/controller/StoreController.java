package com.lin.cangkusp.controller;

import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.constant.ConResult;
import com.lin.cangkusp.common.utils.QueryStoreVo;
import com.lin.cangkusp.pojo.Store;
import com.lin.cangkusp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StoreController {
    @Autowired
    private StoreService storeService;

    @RequestMapping("/store/search")
    @ResponseBody
    public PageInfo<Store> queryStoreByExample(QueryStoreVo vo, int pageNum, int pageSize){
        return storeService.queryStoreByExample(vo,pageNum,pageSize);
    }

    @DeleteMapping("store/delete")
    @ResponseBody
    public ConResult deleteStore(Store store){
        storeService.deleteStore(store);
        return ConResult.ok();
    }

//    @RequestMapping("/store/{id}")
//    @ResponseBody
//    public Store queryStoreById(@PathVariable String id) {
//        return storeService.queryStoreById(id);
//    }

}

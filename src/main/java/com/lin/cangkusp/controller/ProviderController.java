package com.lin.cangkusp.controller;

import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.constant.ConResult;
import com.lin.cangkusp.common.utils.QueryProviderVo;
import com.lin.cangkusp.pojo.Provider;
import com.lin.cangkusp.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @RequestMapping("/provider/search")
    @ResponseBody
    public PageInfo<Provider> queryProviderByExample(QueryProviderVo queryProviderVo,int pageNum, int pageSize){
        return providerService.queryProviderByExample(queryProviderVo,pageNum,pageSize);
    }

    //查询pno列的所有值
    @RequestMapping("provider/pno")
    @ResponseBody
    public List<String> queryPnoList(){
        return providerService.queryPnoList();
    }

    @RequestMapping("provider/insert")
    @ResponseBody
    public ConResult insertProvider(Provider provider){
        providerService.insertProvider(provider);
        return ConResult.ok();
    }

    @RequestMapping("provider/update")
    @ResponseBody
    public ConResult updateProvider(Provider provider){
        providerService.updateProvider(provider);
        return ConResult.ok();
    }

    @DeleteMapping("provider/delete")
    @ResponseBody
    public ConResult deleteProvider(Provider provider){
        providerService.deleteProvider(provider);
        return ConResult.ok();
    }

    @RequestMapping("provider/{id}")
    @ResponseBody
    public Provider queryProviderById(@PathVariable String id){
        return providerService.queryProviderById(id);
    }
}

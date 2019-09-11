package com.lin.cangkusp.service;

import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.utils.QuerySellVo;
import com.lin.cangkusp.pojo.Sell;

public interface SellService {
    PageInfo<Sell> querySellByExample(QuerySellVo querySellVo, int pageNum, int pageSize);

    PageInfo<Sell> querySellList(int pageNum, int pageSize);

    int insertSell(Sell sell);

    int updateSell(Sell sell);

    int deleteSell(Sell sell);

    Sell querySellById(String id);
}

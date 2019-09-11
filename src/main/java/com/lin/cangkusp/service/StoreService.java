package com.lin.cangkusp.service;

import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.utils.QueryStoreVo;
import com.lin.cangkusp.pojo.Store;

import java.util.List;

public interface StoreService {
    PageInfo<Store> queryStoreByExample(QueryStoreVo queryStoreVo, int pageNum, int pageSize);

    PageInfo<Store> queryStoreList(int pageNum, int pageSize);

    int updateStore(Store store);

    int deleteStore(Store store);

    Store queryStoreByCnoAndWno(String cno,String wno);
}

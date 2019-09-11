package com.lin.cangkusp.service;

import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.utils.QueryProviderVo;
import com.lin.cangkusp.pojo.Provider;

import java.util.List;

public interface ProviderService {

    PageInfo<Provider> queryProviderList(int pageNum, int pageSize);

    PageInfo<Provider> queryProviderByExample(QueryProviderVo queryProviderVo, int pageNum, int pageSize);

    List<String> queryPnoList();

    int insertProvider(Provider provider);

    int updateProvider(Provider provider);

    int deleteProvider(Provider provider);

    Provider queryProviderById(String id);
}

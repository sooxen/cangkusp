package com.lin.cangkusp.service;

import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.utils.QueryWarehouseVo;
import com.lin.cangkusp.pojo.Warehouse;

public interface WarehouseService {
    PageInfo<Warehouse> queryWarehouseList(int pageNum, int pageSize);

    PageInfo<Warehouse> queryWarehouseByExample(QueryWarehouseVo queryWarehouseVo, int pageNum, int pageSize);

    int insertWarehouse(Warehouse warehouse);

    int updateWarehouse(Warehouse warehouse);

    int deleteWarehouse(Warehouse warehouse);

    Warehouse queryWarehouseById(String id);
}

package com.lin.cangkusp.service;

import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.utils.QueryCargoVo;
import com.lin.cangkusp.pojo.Cargo;

public interface CargoService {
    PageInfo<Cargo> queryCargoList(int pageNum, int pageSize);

    PageInfo<Cargo> queryCargoByExample(QueryCargoVo queryCargoVo, int pageNum, int pageSize);

    int insertCargo(Cargo cargo);

    int updateCargo(Cargo cargo);

    int deleteCargo(Cargo cargo);

    Cargo queryCargoById(String id);
}

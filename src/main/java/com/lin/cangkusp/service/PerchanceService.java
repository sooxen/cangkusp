package com.lin.cangkusp.service;

import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.utils.QueryPerchanceVo;
import com.lin.cangkusp.pojo.Cargo;
import com.lin.cangkusp.pojo.Perchance;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PerchanceService {
    PageInfo<Perchance> queryPerchanceList(int pageNum, int pageSize);

    @Transactional(readOnly = false)
    int insertPerchance(Perchance perchance);

    @Transactional(readOnly = false)
    int updatePerchance(Perchance perchance);

    @Transactional(readOnly = false)
    int deletePerchance(Perchance perchance);

    PageInfo<Perchance> queryPerchanceByExample(QueryPerchanceVo queryPerchanceVo,int pageNum,int pageSize);

    Perchance queryPerchanceById(String id);
}

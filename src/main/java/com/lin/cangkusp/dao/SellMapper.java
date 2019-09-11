package com.lin.cangkusp.dao;

import com.lin.cangkusp.pojo.Sell;
import com.lin.cangkusp.pojo.SellExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SellMapper {
    int countByExample(SellExample example);

    int deleteByExample(SellExample example);

    int deleteByPrimaryKey(String sid);

    int insert(Sell record);

    int insertSelective(Sell record);

    List<Sell> selectByExample(SellExample example);

    Sell selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") Sell record, @Param("example") SellExample example);

    int updateByExample(@Param("record") Sell record, @Param("example") SellExample example);

    int updateByPrimaryKeySelective(Sell record);

    int updateByPrimaryKey(Sell record);
}
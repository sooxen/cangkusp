package com.lin.cangkusp.dao;

import com.lin.cangkusp.pojo.Cargo;
import com.lin.cangkusp.pojo.CargoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CargoMapper {
    int countByExample(CargoExample example);

    int deleteByExample(CargoExample example);

    int deleteByPrimaryKey(String cno);

    int insert(Cargo record);

    int insertSelective(Cargo record);

    List<Cargo> selectByExample(CargoExample example);

    Cargo selectByPrimaryKey(String cno);

    int updateByExampleSelective(@Param("record") Cargo record, @Param("example") CargoExample example);

    int updateByExample(@Param("record") Cargo record, @Param("example") CargoExample example);

    int updateByPrimaryKeySelective(Cargo record);

    int updateByPrimaryKey(Cargo record);
}
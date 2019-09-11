package com.lin.cangkusp.dao;

import com.lin.cangkusp.pojo.Perchance;
import com.lin.cangkusp.pojo.PerchanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PerchanceMapper {
    int countByExample(PerchanceExample example);

    int deleteByExample(PerchanceExample example);

    int deleteByPrimaryKey(String pid);

    int insert(Perchance record);

    int insertSelective(Perchance record);

    List<Perchance> selectByExample(PerchanceExample example);

    Perchance selectByPrimaryKey(String pid);

    int updateByExampleSelective(@Param("record") Perchance record, @Param("example") PerchanceExample example);

    int updateByExample(@Param("record") Perchance record, @Param("example") PerchanceExample example);

    int updateByPrimaryKeySelective(Perchance record);

    int updateByPrimaryKey(Perchance record);
}
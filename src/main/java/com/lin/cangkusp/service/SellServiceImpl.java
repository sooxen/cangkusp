package com.lin.cangkusp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.exception.AppException;
import com.lin.cangkusp.common.utils.QuerySellVo;
import com.lin.cangkusp.dao.SellMapper;
import com.lin.cangkusp.pojo.Sell;
import com.lin.cangkusp.pojo.SellExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional(timeout = 3000, readOnly = true, rollbackFor = Exception.class)
public class SellServiceImpl implements SellService {
    @Autowired
    private SellMapper sellMapper;

    @Override
    //根据条件进行查询
    public PageInfo<Sell> querySellByExample(QuerySellVo querySellVo, int pageNum, int pageSize) {
        SellExample sellExample = new SellExample();
        SellExample.Criteria sellExampleCriteria = sellExample.createCriteria();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //判断是否填写货物编码
        if (StringUtils.isNotBlank(querySellVo.getCno())) {
            sellExampleCriteria.andCnoEqualTo(querySellVo.getCno());
        }
        //判断是否填写仓库编号
        if (StringUtils.isNotBlank(querySellVo.getWno())) {
            sellExampleCriteria.andWnoEqualTo(querySellVo.getWno());
        }
        //判断是否填写管理员编号
        if (StringUtils.isNotBlank(querySellVo.getSno())) {
            sellExampleCriteria.andSnoEqualTo(querySellVo.getSno());
        }
        //判断是否填写最低最高价格
        if (querySellVo.getLowestprice() != null) {
            sellExampleCriteria.andSpriceGreaterThanOrEqualTo(querySellVo.getLowestprice());
        }
        if (querySellVo.getHightestprice() != null) {
            sellExampleCriteria.andSpriceLessThanOrEqualTo(querySellVo.getHightestprice());
        }
        //判断是否填写起始和最终日期
        try {
            if (StringUtils.isNotBlank(querySellVo.getStartdate())) {
                sellExampleCriteria.andSdateGreaterThanOrEqualTo(dateFormat.parse(querySellVo.getStartdate()));
            }
            if (StringUtils.isNotBlank(querySellVo.getEnddate())) {
                sellExampleCriteria.andSdateLessThanOrEqualTo(dateFormat.parse(querySellVo.getEnddate()));
            }
        } catch (ParseException e) {
            throw new AppException("日期转换出错！",400);
        }
        //判断是否填写数量
        if (querySellVo.getSnum() != null) {
            sellExampleCriteria.andSnumEqualTo(querySellVo.getSnum());
        }
        PageHelper.startPage(pageNum, pageSize,true,true,true);
        List<Sell> sellList = sellMapper.selectByExample(sellExample);
//        for (Sell p:sellList){
//            System.out.println(p.getPdate());
//        }
        return new PageInfo<>(sellList);
    }

    @Override
    public PageInfo<Sell> querySellList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Sell> sellList = sellMapper.selectByExample(null);
        return new PageInfo<>(sellList);
    }

    @Override
    @Transactional(readOnly = false)
    public int insertSell(Sell sell) {
        try {
            sell.setSdate(new Date());
            int i = sellMapper.insertSelective(sell);
            return i;
        } catch (Exception e) {
            throw new AppException("增加失败！", 400);
        }

    }

    @Override
    @Transactional(readOnly = false)
    public int updateSell(Sell sell) {
        try {
            int i = sellMapper.updateByPrimaryKeySelective(sell);
            return i;
        } catch (Exception e) {
            throw new AppException("修改失败！", 400);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteSell(Sell sell) {
        try {
            int i = sellMapper.deleteByExample(null);
            return i;
        } catch (Exception e) {
            throw new AppException("删除失败！", 400);
        }
    }

    @Override
    public Sell querySellById(String id){
        try {
            Sell Sell=sellMapper.selectByPrimaryKey(id);
            return Sell;
        }catch (Exception e){
            throw new AppException("查询失败",400);
        }
    }
}

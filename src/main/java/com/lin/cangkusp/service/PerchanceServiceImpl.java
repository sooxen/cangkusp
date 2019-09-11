package com.lin.cangkusp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.exception.AppException;
import com.lin.cangkusp.common.utils.QueryPerchanceVo;
import com.lin.cangkusp.dao.PerchanceMapper;
import com.lin.cangkusp.pojo.Cargo;
import com.lin.cangkusp.pojo.Perchance;
import com.lin.cangkusp.pojo.PerchanceExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional(timeout = 3000, readOnly = true, rollbackFor = Exception.class)
public class PerchanceServiceImpl implements PerchanceService {
    @Autowired
    private PerchanceMapper perchanceMapper;

    @Override
    //根据条件进行查询
    public PageInfo<Perchance> queryPerchanceByExample(QueryPerchanceVo queryPerchanceVo,int pageNum,int pageSize) {
        PerchanceExample perchanceExample = new PerchanceExample();
        PerchanceExample.Criteria perchanceExampleCriteria = perchanceExample.createCriteria();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //判断是否填写货物编码
        if (StringUtils.isNotBlank(queryPerchanceVo.getCno())) {
            perchanceExampleCriteria.andCnoEqualTo(queryPerchanceVo.getCno());
        }
        //判断是否填写仓库编号
        if (StringUtils.isNotBlank(queryPerchanceVo.getWno())) {
            perchanceExampleCriteria.andWnoEqualTo(queryPerchanceVo.getWno());
        }
        //判断是否填写管理员编号
        if (StringUtils.isNotBlank(queryPerchanceVo.getSno())) {
            perchanceExampleCriteria.andSnoEqualTo(queryPerchanceVo.getSno());
        }
        //判断是否填写最低最高价格
        if (queryPerchanceVo.getLowestprice() != null) {
            perchanceExampleCriteria.andPpriceGreaterThanOrEqualTo(queryPerchanceVo.getLowestprice());
        }
        if (queryPerchanceVo.getHightestprice() != null) {
            perchanceExampleCriteria.andPpriceLessThanOrEqualTo(queryPerchanceVo.getHightestprice());
        }
        //判断是否填写起始和最终日期
        try {
            if (StringUtils.isNotBlank(queryPerchanceVo.getStartdate())) {
                perchanceExampleCriteria.andPdateGreaterThanOrEqualTo(dateFormat.parse(queryPerchanceVo.getStartdate()));
            }
            if (StringUtils.isNotBlank(queryPerchanceVo.getEnddate())) {
                perchanceExampleCriteria.andPdateLessThanOrEqualTo(dateFormat.parse(queryPerchanceVo.getEnddate()));
            }
        } catch (ParseException e) {
            throw new AppException("日期转换出错！",400);
        }
        //判断是否填写数量
        if (queryPerchanceVo.getPnum() != null) {
            perchanceExampleCriteria.andPnumEqualTo(queryPerchanceVo.getPnum());
        }
        PageHelper.startPage(pageNum, pageSize,true,true,true);
        List<Perchance> perchanceList = perchanceMapper.selectByExample(perchanceExample);
//        for (Perchance p:perchanceList){
//            System.out.println(p.getPdate());
//        }
        return new PageInfo<>(perchanceList);
    }

    @Override
    public PageInfo<Perchance> queryPerchanceList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Perchance> perchanceList = perchanceMapper.selectByExample(null);
        return new PageInfo<>(perchanceList);
    }

    @Override
    @Transactional(readOnly = false)
    public int insertPerchance(Perchance perchance) {
        try {
            perchance.setPdate(new Date());
            int i = perchanceMapper.insertSelective(perchance);
            return i;
        } catch (Exception e) {
            throw new AppException("增加失败！", 400);
        }

    }

    @Override
    @Transactional(readOnly = false)
    public int updatePerchance(Perchance perchance) {
        try {
            int i = perchanceMapper.updateByPrimaryKeySelective(perchance);
            return i;
        } catch (Exception e) {
            throw new AppException("修改失败！", 400);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public int deletePerchance(Perchance perchance) {
        try {
            int i = perchanceMapper.deleteByExample(null);
            return i;
        } catch (Exception e) {
            throw new AppException("删除失败！", 400);
        }
    }

    @Override
    public Perchance queryPerchanceById(String id){
        try {
            Perchance Perchance=perchanceMapper.selectByPrimaryKey(id);
            return Perchance;
        }catch (Exception e){
            throw new AppException("查询失败",400);
        }
    }
}

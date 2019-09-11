package com.lin.cangkusp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.exception.AppException;
import com.lin.cangkusp.common.utils.QueryStoreVo;
import com.lin.cangkusp.dao.StoreMapper;
import com.lin.cangkusp.dao.StoreMapper;
import com.lin.cangkusp.pojo.Perchance;
import com.lin.cangkusp.pojo.Store;
import com.lin.cangkusp.pojo.StoreExample;
import com.lin.cangkusp.pojo.Store;
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
public class StoreServiceImpl implements StoreService{
    @Autowired
    private StoreMapper storeMapper;

    @Override
    //根据条件进行查询
    public PageInfo<Store> queryStoreByExample(QueryStoreVo queryStoreVo, int pageNum, int pageSize) {
        StoreExample storeExample = new StoreExample();
        StoreExample.Criteria storeExampleCriteria = storeExample.createCriteria();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //判断是否填写货物编码
        if (StringUtils.isNotBlank(queryStoreVo.getCno())) {
            storeExampleCriteria.andCnoEqualTo(queryStoreVo.getCno());
        }
        //判断是否填写仓库编号
        if (StringUtils.isNotBlank(queryStoreVo.getWno())) {
            storeExampleCriteria.andWnoEqualTo(queryStoreVo.getWno());
        }
        //判断是否填写最低最高价格
        if (queryStoreVo.getLowestnum() != null) {
            storeExampleCriteria.andStnumGreaterThanOrEqualTo(queryStoreVo.getLowestnum());
        }
        if (queryStoreVo.getHightestnum() != null) {
            storeExampleCriteria.andStnumLessThanOrEqualTo(queryStoreVo.getHightestnum());
        }
        //判断是否填写起始和最终日期
        try {
            if (StringUtils.isNotBlank(queryStoreVo.getStartdate())) {
                storeExampleCriteria.andStdateGreaterThanOrEqualTo(dateFormat.parse(queryStoreVo.getStartdate()));
            }
            if (StringUtils.isNotBlank(queryStoreVo.getEnddate())) {
                storeExampleCriteria.andStdateLessThanOrEqualTo(dateFormat.parse(queryStoreVo.getEnddate()));
            }
        } catch (ParseException e) {
            throw new AppException("日期转换出错！",400);
        }
        PageHelper.startPage(pageNum, pageSize,true,true,true);
        List<Store> storeList = storeMapper.selectByExample(storeExample);
//        for (Store p:storeList){
//            System.out.println(p.getPdate());
//        }
        return new PageInfo<>(storeList);
    }

    @Override
    public PageInfo<Store> queryStoreList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Store> storeList = storeMapper.selectByExample(null);
        return new PageInfo<>(storeList);
    }

    @Override
    @Transactional(readOnly = false)
    public int updateStore(Store store) {
        try {
            int i = storeMapper.updateByPrimaryKeySelective(store);
            return i;
        } catch (Exception e) {
            throw new AppException("修改失败！", 400);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteStore(Store store) {
        try {
            int i = storeMapper.deleteByExample(null);
            return i;
        } catch (Exception e) {
            throw new AppException("删除失败！", 400);
        }
    }

    @Override
    public Store queryStoreByCnoAndWno(String cno,String wno){
        StoreExample storeExample = new StoreExample();
        StoreExample.Criteria storeExampleCriteria = storeExample.createCriteria();
        storeExampleCriteria.andCnoEqualTo(cno).andWnoEqualTo(wno);
        try {
            return storeMapper.selectByExample(storeExample).get(0);
        }catch (Exception e){
            throw new AppException("查询失败",400);
        }
    }
}

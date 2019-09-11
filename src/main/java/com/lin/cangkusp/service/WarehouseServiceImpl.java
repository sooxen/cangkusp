package com.lin.cangkusp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.constant.ConResult;
import com.lin.cangkusp.common.exception.AppException;
import com.lin.cangkusp.common.utils.QueryWarehouseVo;
import com.lin.cangkusp.dao.WarehouseMapper;
import com.lin.cangkusp.pojo.Warehouse;
import com.lin.cangkusp.pojo.WarehouseExample;
import com.lin.cangkusp.pojo.Warehouse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(timeout = 3000,readOnly = true,rollbackFor = Exception.class)
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public PageInfo<Warehouse> queryWarehouseList(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Warehouse> warehouseList = warehouseMapper.selectByExample(null);
        return new PageInfo<>(warehouseList);
    }

    public PageInfo<Warehouse> queryWarehouseByExample(QueryWarehouseVo queryWarehouseVo, int pageNum, int pageSize) {
        WarehouseExample warehouseExample = new WarehouseExample();
        WarehouseExample.Criteria warehouseExampleCriteria = warehouseExample.createCriteria();
        if (StringUtils.isNotBlank(queryWarehouseVo.getWno())) {
            warehouseExampleCriteria.andWnoEqualTo(queryWarehouseVo.getWno());
            PageHelper.startPage(pageNum, pageSize, true, true, true);
            List<Warehouse> warehouseList = warehouseMapper.selectByExample(warehouseExample);
            return new PageInfo<>(warehouseList);
        }
        if (StringUtils.isNotBlank(queryWarehouseVo.getWname())) {
            warehouseExampleCriteria.andWnameLike(queryWarehouseVo.getWname());
        }
        if (StringUtils.isNotBlank(queryWarehouseVo.getWaddress())) {
            warehouseExampleCriteria.andWaddressLike(queryWarehouseVo.getWaddress());
        }
        if (StringUtils.isNotBlank(queryWarehouseVo.getSno())) {
            warehouseExampleCriteria.andSnoEqualTo(queryWarehouseVo.getSno());
        }
        PageHelper.startPage(pageNum, pageSize, true, true, true);
        List<Warehouse> warehouseList = warehouseMapper.selectByExample(warehouseExample);
        return new PageInfo<>(warehouseList);
    }

    @Override
    @Transactional(readOnly = false)
    public int insertWarehouse(Warehouse warehouse) {
        try {
            int i = warehouseMapper.insertSelective(warehouse);
            return i;
        } catch (Exception e) {
            throw new AppException("增加失败！",400);
        }

    }

    @Override
    @Transactional(readOnly = false)
    public int updateWarehouse(Warehouse warehouse) {
        try {
            int i=warehouseMapper.updateByPrimaryKeySelective(warehouse);
            return i;
        } catch (Exception e) {
            throw new AppException("修改失败！",400);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteWarehouse(Warehouse warehouse) {
        try {
            int i=warehouseMapper.deleteByPrimaryKey(warehouse.getWno());
            return i;
        }catch (Exception e){
            throw new AppException("删除失败！",400);
        }

    }

    @Override
    public Warehouse queryWarehouseById(String id) {
        try {
            Warehouse warehouse=warehouseMapper.selectByPrimaryKey(id);
            return warehouse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AppException("查询失败！",400);
        }
    }
}

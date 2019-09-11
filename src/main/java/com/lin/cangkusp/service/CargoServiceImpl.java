package com.lin.cangkusp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.exception.AppException;
import com.lin.cangkusp.common.utils.QueryCargoVo;
import com.lin.cangkusp.dao.CargoMapper;
import com.lin.cangkusp.pojo.Cargo;
import com.lin.cangkusp.pojo.CargoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(timeout = 3000,readOnly = true, rollbackFor = Exception.class)
public class CargoServiceImpl implements CargoService {
    @Autowired
    private CargoMapper cargoMapper;

    @Override
    public PageInfo<Cargo> queryCargoList(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Cargo> cargoList=cargoMapper.selectByExample(null);
        return new PageInfo<>(cargoList);
    }

    @Override
    public PageInfo<Cargo> queryCargoByExample(QueryCargoVo queryCargoVo,int pageNum, int pageSize){
        CargoExample cargoExample=new CargoExample();
        CargoExample.Criteria cargoExampleCriteria = cargoExample.createCriteria();
        if (queryCargoVo.getCno()!=""){
            cargoExampleCriteria.andCnoEqualTo(queryCargoVo.getCno());
            PageHelper.startPage(pageNum, pageSize,true,true,true);
            List<Cargo> cargoList=cargoMapper.selectByExample(cargoExample);
            return new PageInfo<>(cargoList);
        }
        if (queryCargoVo.getCname()!=""){
            cargoExampleCriteria.andCnameLike(queryCargoVo.getCname());
        }
        if (queryCargoVo.getLowestprice()!=null){
            cargoExampleCriteria.andCpriceGreaterThanOrEqualTo(queryCargoVo.getLowestprice());
        }
        if (queryCargoVo.getHightestprice()!=null){
            cargoExampleCriteria.andCpriceLessThanOrEqualTo(queryCargoVo.getHightestprice());
        }
        if (queryCargoVo.getPno()!=""){
            cargoExampleCriteria.andPnoEqualTo(queryCargoVo.getPno());
        }
        PageHelper.startPage(pageNum, pageSize,true,true,true);
        List<Cargo> cargoList=cargoMapper.selectByExample(cargoExample);
        return new PageInfo<>(cargoList);
    }

    @Override
    @Transactional(readOnly = false)
    public int insertCargo(Cargo cargo) {
        try {
            int i = cargoMapper.insertSelective(cargo);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AppException("增加失败！",400);
        }

    }

    @Override
    @Transactional(readOnly = false)
    public int updateCargo(Cargo cargo) {
        try {
            int i=cargoMapper.updateByPrimaryKeySelective(cargo);
            return i;
        } catch (Exception e) {
            throw new AppException("修改失败！",400);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteCargo(Cargo cargo) {
        try {
            int i=cargoMapper.deleteByPrimaryKey(cargo.getCno());
            return i;
        }catch (Exception e){
            throw new AppException("删除失败！",400);
        }

    }

    @Override
    public Cargo queryCargoById(String id) {
        try {
            Cargo cargo=cargoMapper.selectByPrimaryKey(id);
            return cargo;
        }catch (Exception e){
            throw new AppException("查询失败",400);
        }
    }
}

package com.lin.cangkusp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lin.cangkusp.common.exception.AppException;
import com.lin.cangkusp.common.utils.QueryProviderVo;
import com.lin.cangkusp.dao.ProviderMapper;
import com.lin.cangkusp.pojo.Provider;
import com.lin.cangkusp.pojo.ProviderExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.standard.expression.Each;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(timeout = 3000, readOnly = true, rollbackFor = Exception.class)
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderMapper providerMapper;

    @Override
    public PageInfo<Provider> queryProviderList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Provider> providerList = providerMapper.selectByExample(null);
        return new PageInfo<>(providerList);
    }

    public PageInfo<Provider> queryProviderByExample(QueryProviderVo queryProviderVo, int pageNum, int pageSize) {
        ProviderExample providerExample = new ProviderExample();
        ProviderExample.Criteria providerExampleCriteria = providerExample.createCriteria();
        if (StringUtils.isNotBlank(queryProviderVo.getPno())) {
            providerExampleCriteria.andPnoEqualTo(queryProviderVo.getPno());
            PageHelper.startPage(pageNum, pageSize, true, true, true);
            List<Provider> providerList = providerMapper.selectByExample(providerExample);
            return new PageInfo<>(providerList);
        }
        if (StringUtils.isNotBlank(queryProviderVo.getPname())) {
            providerExampleCriteria.andPnameLike(queryProviderVo.getPname());
        }
        if (StringUtils.isNotBlank(queryProviderVo.getPaddress())) {
            providerExampleCriteria.andPaddressLike(queryProviderVo.getPaddress());
        }
        if (StringUtils.isNotBlank(queryProviderVo.getPtel())) {
            providerExampleCriteria.andPtelLike(queryProviderVo.getPtel());
        }
        PageHelper.startPage(pageNum, pageSize, true, true, true);
        List<Provider> providerList = providerMapper.selectByExample(providerExample);
        return new PageInfo<>(providerList);
    }

    @Override
    public List<String> queryPnoList() {
        try {
            List<Provider> providerList = providerMapper.selectByExample(null);
            List<String> stringList = new ArrayList<>();
            for (Provider p : providerList) {
                stringList.add(p.getPno());
            }
            return stringList;
        } catch (Exception e) {
            throw new AppException("查询失败", 400);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public int insertProvider(Provider provider) {
        try {
            int i = providerMapper.insertSelective(provider);
            return i;
        } catch (Exception e) {
            throw new AppException("增加失败！", 400);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public int updateProvider(Provider provider) {
        try {
            int i = providerMapper.updateByPrimaryKeySelective(provider);
            return i;
        } catch (Exception e) {
            throw new AppException("修改失败！", 400);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteProvider(Provider provider) {
        try {
            int i = providerMapper.deleteByPrimaryKey(provider.getPno());
            return i;
        } catch (Exception e) {
            throw new AppException("删除失败！", 400);
        }

    }

    @Override
    public Provider queryProviderById(String id) {
        try {
            Provider provider = providerMapper.selectByPrimaryKey(id);
            return provider;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AppException("查询失败！", 400);
        }
    }
}

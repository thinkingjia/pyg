package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Resource
    private TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public PageResult<TbBrand> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<TbBrand> pageReturn = (Page<TbBrand>) tbBrandMapper.selectByExample(null);

        return new PageResult<>(pageReturn.getTotal(), pageReturn.getResult());
    }

    @Override
    public void save(TbBrand tbBrand) {
        if (null != tbBrand.getId()){
            tbBrandMapper.updateByPrimaryKey(tbBrand);
        }else {
            tbBrandMapper.insert(tbBrand);
        }
    }

    @Override
    public TbBrand findById(long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids){
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }
}

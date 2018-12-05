package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;

public interface BrandService {

    public List<TbBrand> findAll();

    public PageResult<TbBrand> findPage(int page, int size);

    public void save(TbBrand tbBrand);

    public TbBrand findById(long id);

    public void delete(long[] ids);
}

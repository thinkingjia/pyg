package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.vo.Specification;
import entity.PageResult;

import java.util.List;

public interface SpecificationService {
    public PageResult<TbSpecification> findPage(int page, int size);

    public void save(Specification specification);

    public Specification findById(long id);

    public void delete(long[] ids);

    public List<TbSpecification> findAll();
}

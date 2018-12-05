package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.sellergoods.service.SpecificationService;
import com.pinyougou.vo.Specification;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/specification")
public class SpecificationController {

    @Reference
    private SpecificationService specificationService;


    @RequestMapping("/findPage/{page}/{size}")
    public PageResult<TbSpecification> findPage(@PathVariable("page") int page, @PathVariable("size") int size){
        return specificationService.findPage(page, size);

    }

    @RequestMapping("/save")
    public Result save(@RequestBody Specification specification){
        try {
            specificationService.save(specification);
            return new Result(true,"保存成功!");
        }catch (Exception e){
            return new Result(false,"保存失败!");
        }

    }

    @RequestMapping("/edit/{id}")
    public Specification edit(@PathVariable("id") long id){
        return specificationService.findById(id);
    }
    @RequestMapping("/delete/{ids}")
    public Result delete(@PathVariable("ids") long[] ids){
        try {
            specificationService.delete(ids);
            return new Result(true,"删除成功!");
        }catch (Exception e){
            return new Result(false,"删除失败!");
        }
    }
    @RequestMapping("/findAll")
    public List<TbSpecification> findAll(){
        return specificationService.findAll();

    }



}

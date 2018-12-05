package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbSpecificationOptionExample;
import com.pinyougou.sellergoods.service.SpecificationService;
import com.pinyougou.vo.Specification;
import entity.PageResult;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SpecificationServiceImpl implements SpecificationService {

    @Resource
    private TbSpecificationMapper tbSpecificationMapper;
    @Resource
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;
    

    @Override
    public PageResult<TbSpecification> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<TbSpecification> pageReturn = (Page<TbSpecification>) tbSpecificationMapper.selectByExample(null);

        return new PageResult<>(pageReturn.getTotal(), pageReturn.getResult());
    }

    @Override
    public void save(Specification specification) {
        //判断规格是否存在id
        if (null != specification.getSpec().getId()){
            //id存在，执行更新
            tbSpecificationMapper.updateByPrimaryKey(specification.getSpec());
            for(TbSpecificationOption option:specification.getOptionList()){
                if (null != option.getId()){
                    tbSpecificationOptionMapper.updateByPrimaryKey(option);
                }else {
                    option.setSpecId(specification.getSpec().getId());
                    tbSpecificationOptionMapper.insert(option);
                }
            }
        }else {
            //id为空，执行保存
            //保存规格主表数据，返回主键
            tbSpecificationMapper.insert(specification.getSpec());
            //循环规格数据，把主键id绑定到每个数据上
            for(TbSpecificationOption option:specification.getOptionList()){
                option.setSpecId(specification.getSpec().getId());
                tbSpecificationOptionMapper.insert(option);
            }
        }
    }

    @Override
    public Specification findById(long id) {
        TbSpecification spec = tbSpecificationMapper.selectByPrimaryKey(id);

        TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();
        criteria.andSpecIdEqualTo(id);
        List<TbSpecificationOption> optionList = tbSpecificationOptionMapper.selectByExample(tbSpecificationOptionExample);

        Specification specification = new Specification();
        specification.setSpec(spec);
        specification.setOptionList(optionList);

        return specification;
    }

    @Override
    public void delete(long[] ids) {
        for (long id:ids){
            TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();
            criteria.andSpecIdEqualTo(id);
            tbSpecificationOptionMapper.deleteByExample(tbSpecificationOptionExample);
            tbSpecificationMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<TbSpecification> findAll() {
        return tbSpecificationMapper.selectByExample(null);
    }


}

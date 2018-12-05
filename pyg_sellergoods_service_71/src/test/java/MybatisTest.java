import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-dao.xml")
public class MybatisTest {
    @Resource
    private TbSpecificationMapper specificationMapper;

    /**
     * 需求：添加
     */
    @Test
    public void add() {
//创建规格对象
        TbSpecification specification = new TbSpecification();
        specification.setSpecName("机身");
        specificationMapper.insertSelective(specification);
    }
    /**
     * 需求：查询所有
     */
    @Test
    public void selectByCondition1() {
        List<TbSpecification> list = specificationMapper.selectByExample(null);
        System.out.println(list);
    }

    /**
     * 需求：条件查询
     */
    @Test
    public void selectByCondition2() {
        //创建查询对象相对应example对象
        TbSpecificationExample example = new TbSpecificationExample();
        //设置查询
        //创建criteria对象
        TbSpecificationExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(33L);
        //条件 and
        criteria.andSpecNameLike("%电视%");
        example.setOrderByClause("id");
        List<TbSpecification> list = specificationMapper.selectByExample(example);
        System.out.println(list);
    }
    /**
     * 需求：条件查询
     */
    @Test
    public void selectByCondition3() {
        //创建查询对象相对应example对象
        TbSpecificationExample example = new TbSpecificationExample();
        example.or().andIdEqualTo(33L).andSpecNameLike("%电视%");
        example.or().andIdEqualTo(39L);
        List<TbSpecification> list = specificationMapper.selectByExample(example);
        System.out.println(list);
    }


}

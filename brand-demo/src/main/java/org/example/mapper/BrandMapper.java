package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Brand;

import java.util.List;

/**
 * 品牌Mapper接口 用于操作数据库 通过动态代理实现 无需编写实现类 只需要编写接口 通过动态代理生成实现类
 * 由SqlSession来执行 由SqlSession来管理事务 由SqlSession来释放资源 由SqlSession来关闭连接
 */
public interface BrandMapper {
    /**
     * 查询所有品牌
     *
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 添加品牌
     */
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    /**
     * 根据id查询品牌
     *
     * @param id
     * @return
     */
    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    /**
     * 修改品牌
     *
     * @param brand
     */
    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
    @ResultMap("brandResultMap")
    void update(Brand brand);


    /**
     * 根据id删除品牌
     *
     * @param id
     */
    @Delete("delete from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    void deleteById(int id);
}

package org.example.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mapper.BrandMapper;
import org.example.pojo.Brand;
import org.example.util.SqlSessionFactoryUtils;

import java.util.List;

/**
 * 品牌Service 用于业务逻辑处理
 * 事务管理 释放资源 关闭连接
 */
public class BrandService {
    // 获取SqlSessionFactory
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有品牌
     *
     * @return
     */
    public List<Brand> selectAll() {
        // 获取SqlSession 从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 通过动态代理获取BrandMapper的实现类
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 调用BrandMapper的方法
        List<Brand> brands = mapper.selectAll();
        // 关闭SqlSession
        sqlSession.close();

        return brands;
    }

    /**
     * 添加品牌
     */
    public void add(Brand brand) {
        // 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 通过动态代理获取BrandMapper的实现类
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 调用BrandMapper的方法
        mapper.add(brand);
        // 提交事务
        sqlSession.commit();
        // 关闭SqlSession
        sqlSession.close();
    }

    /**
     * 根据id查询品牌
     *
     * @param id
     * @return
     */
    public Brand selectById(int id) {
        // 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 通过动态代理获取BrandMapper的实现类
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 调用BrandMapper的方法
        Brand brand = mapper.selectById(id);
        // 关闭SqlSession
        sqlSession.close();

        return brand;
    }

    /**
     * 修改品牌
     *
     * @param brand
     */
    public void update(Brand brand) {
        // 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 通过动态代理获取BrandMapper的实现类
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 调用BrandMapper的方法
        mapper.update(brand);
        // 提交事务
        sqlSession.commit();
        // 关闭SqlSession
        sqlSession.close();
    }

    // 删除品牌
    public void deleteById(int id) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }
}
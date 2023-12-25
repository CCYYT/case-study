package com.example.springDemo.dao;

import com.example.springDemo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * (Product)表数据库访问层
 *
 * @author makejava
 * @since 2023-12-25 19:14:19
 */
@Mapper
public interface ProductDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Product queryById(Integer id);

    /**
     * 查询所有商品
     *
     * @return 实例对象 列表
     */
    List<Product> queryAll();

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 影响行数
     */
    int insert(Product product);

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 影响行数
     */
    int update(Product product);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}


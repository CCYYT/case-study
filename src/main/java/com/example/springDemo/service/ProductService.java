package com.example.springDemo.service;

import com.example.springDemo.entity.Product;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (Product)表服务接口
 *
 * @author CYT
 * @since 2023-12-25 19:14:19
 */
public interface ProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Product queryById(Integer id);


    /**
     * 查询所有商品数据
     *
     * @return 实例对象 列表
     */
    List<Product> queryAll();

    /**
     * 分页查询
     *
     * @param num 页码
     * @param size  页大小
     * @return 查询结果
     */
    PageInfo<Product> queryByPage(int num,int size);

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 是否成功
     */
    boolean insert(Product product);

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 是否成功
     */
    boolean update(Product product);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}

package com.example.springDemo.service.impl;

import com.example.springDemo.entity.Product;
import com.example.springDemo.dao.ProductDao;
import com.example.springDemo.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Product)表服务实现类
 *
 * @author makejava
 * @since 2023-12-25 19:14:19
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Product queryById(Integer id) {
        return this.productDao.queryById(id);
    }

    /**
     * 查询所有商品数据
     *
     * @return 实例对象 列表
     */
    @Override
    public List<Product> queryAll(){
        return this.productDao.queryAll();
    }

    /**
     * 分页查询
     *
     * @param num 页码
     * @param size  页大小
     * @return 查询结果
     */
    @Override
    public PageInfo<Product> queryByPage(int num,int size) {
        try {
            PageHelper.startPage(num,size);
            List<Product> products = this.productDao.queryAll();
            return new PageInfo<>(products);
        }finally {
            //清除分页信息
            PageHelper.clearPage();
        }
    }

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Product product) {
        return this.productDao.insert(product) > 0;
    }

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Product product) {
        return this.productDao.update(product) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.productDao.deleteById(id) > 0;
    }
}

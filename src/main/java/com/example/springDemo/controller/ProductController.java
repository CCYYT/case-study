package com.example.springDemo.controller;

import com.example.springDemo.common.Code;
import com.example.springDemo.common.Result;
import com.example.springDemo.entity.Product;
import com.example.springDemo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * (Product)表控制层
 *
 * @author CYT
 * @since 2023-12-25 19:14:19
 */
@RestController
@RequestMapping("product")
public class ProductController {
    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;

    /**
     * 分页查询
     *
     * @param num       第几页 （默认第一页
     * @param pageSize  页大小 (默认一页10条数据
     * @return 查询结果
     */
    @GetMapping("page")
    public Result queryByPage(
            @RequestParam(value = "num",defaultValue = "1") int num,
            @RequestParam(value = "pageSize",defaultValue = "10" ) int pageSize) {
        return Result.ok(Code.GET_OK,this.productService.queryByPage(num, pageSize));
    }

    /**
     * 查询所有数据
     *
     * @return 查询结果
     */
    @GetMapping("all")
    public Result queryAll() {
        List<Product> product = this.productService.queryAll();
        return product == null ?
                Result.fail(Code.GET_ERR) :
                Result.ok(Code.GET_OK,product);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result queryById(@PathVariable("id") Integer id) {
        Product product = this.productService.queryById(id);
        return product == null ?
                Result.fail(Code.GET_ERR) :
                Result.ok(Code.GET_OK,product);
    }

    /**
     * 新增数据
     *
     * @param product 实体
     * @return 新增结果
     */
    @PostMapping
    public Result add(@RequestBody @Valid Product product) {
        return this.productService.insert(product) ?
                Result.ok(Code.SAVE_OK) :
                Result.fail(Code.SAVE_ERR);
    }

    /**
     * 编辑数据
     *
     * @param product 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result edit(@RequestBody @Valid Product product) {
        return this.productService.update(product) ?
                Result.ok(Code.UPDATE_OK) :
                Result.fail(Code.UPDATE_ERR);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result deleteById(@RequestParam Integer id) {
        return this.productService.deleteById(id) ?
                Result.ok(Code.DELETE_OK):
                Result.fail(Code.DELETE_ERR);
    }

}


package com.example.springDemo.entity;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.io.Serializable;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2023-12-25 19:14:19
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 609183109140251531L;
    /**
     * 商品id
     */
    private Integer id;
    /**
     * 商品名称
     */

    @NotBlank(message = "商品名称不能为空")
    private String productName;
    /**
     * 库存数量
     */
    @NotNull
    @Min(value = 1,message = "库存数量不能小于1")
    private Integer stockQuantity;
    /**
     * 商品价格
     */
    @NotNull
    @DecimalMin(value = "0",inclusive = false,message = "价格不能小于0元")
    private Double productPrice;
    /**
     * 商品创建时间
     */
    private Date createTime;
    /**
     * 商品描述
     */
    private String productInfo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

}


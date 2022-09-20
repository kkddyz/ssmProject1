package com.itheima.ssm.domain;

import com.itheima.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author kkddyz
 * @date 2022/9/10
 * @description 产品信息
 */

public class Product {
    /**
     * 主键
     */
    private String id;
    /**
     * 编号 唯一
     */
    private String productNum;

    /**
     * 名称
     */
    private String productName;

    /**
     * 发货城市
     */
    private String cityName;

    /**
     * 发货时间 数据库存储
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;

    /**
     * 发货时间的字符串表示 用于前端数据展示
     */
    private String departureTimeStr;

    /**
     * 产品价格
     */
    private double productPrice;

    /**
     * 产品描述
     */
    private String productDesc;

    /**
     * 状态(数字表示)  0关闭 1开启  记录在数据库中
     */
    private Integer productStatus;

    /**
     * 状态(数字表示)  "关闭" "开启"  用于前端页面展示 (数据库是没有这个字段的)
     */
    private String productStatusStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * 在JSP中通过get获取该字段时需要将Date变成对应的字符串
     */
    public String getDepartureTimeStr() {
        if (departureTime != null) {
            departureTimeStr = DateUtils.dateToString(departureTime, "yyyy-MM-dd HH:mm:ss");
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * 在JSP中通过get获取该字段时需要将0,1变成对应的字符串
     */
    public String getProductStatusStr() {
        if (productStatus != null) {
            if (productStatus == 0) {
                productStatusStr = "关闭";
            }
            if (productStatus == 1) {
                productStatusStr = "开启";
            }
        }else{
            // 这个应该是不会遇到的，在保存商品时，将状态设为非空字段，就能保证productStatus != null
            productDesc = "未知";
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }
}
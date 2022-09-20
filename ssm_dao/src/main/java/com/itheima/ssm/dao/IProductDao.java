package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author kkddyz
 * @date 2022/9/11
 * @description
 */

public interface IProductDao {

    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("insert into product" +
            "(productNum, productName, cityName, departureTime, productPrice,productDesc, productStatus) " +
            "value " +
            "(#{productNum}, #{productName}, #{cityName}, #{departureTime}, " +
            "#{productPrice},#{productDesc}, #{productStatus})")
    void save(Product product) throws Exception;
}

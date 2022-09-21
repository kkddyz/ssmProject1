package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Order;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author kkddyz
 * @date 2022/9/20
 */

public interface IOrderDao {

    /**
     * 从orders表中查询出订单信息，以及对应的商品信息
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product",
                    column = "productId",
                    javaType = Process.class,
                    one = @One(select = "com.itheima.ssm.dao.IProductDao.findById"))
    })
    List<Order> findAll() throws Exception;
}
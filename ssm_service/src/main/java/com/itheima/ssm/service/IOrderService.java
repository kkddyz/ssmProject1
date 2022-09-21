package com.itheima.ssm.service;

import com.itheima.ssm.domain.Order;

import java.util.List;

/**
 * @author kkddyz
 * @date 2022/9/20
 */

public interface IOrderService {

    List<Order> findAll() throws Exception;

}
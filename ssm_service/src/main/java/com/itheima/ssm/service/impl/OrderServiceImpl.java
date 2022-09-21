package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IOrderDao;
import com.itheima.ssm.domain.Order;
import com.itheima.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kkddyz
 * @date 2022/9/20
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Order> findAll() throws Exception {
        return orderDao.findAll();
    }
}

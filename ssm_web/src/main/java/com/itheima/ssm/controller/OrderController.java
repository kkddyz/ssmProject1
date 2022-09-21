package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Order;
import com.itheima.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author kkddyz
 * @date 2022/9/20
 * @description 未分页, 查询所有order
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService ordersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {


        // 查询全部订单
        List<Order> ordersList = ordersService.findAll();
        System.out.println("findAll order form db");
        for (Order order : ordersList) {
            System.out.println(order);
        }

        ModelAndView mv = new ModelAndView();
        // 设置域对象
        mv.addObject("orderList", ordersList);
        // 设置返回页面
        mv.setViewName("order-list");

        return mv;
    }
}
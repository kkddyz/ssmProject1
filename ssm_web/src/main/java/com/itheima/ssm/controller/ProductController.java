package com.itheima.ssm.controller;


import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @author kkddyz
 * @date 2022/9/15
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * 添加Product
     */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {// 前端页面的属性符合springMVC的规范，不需要注解
        productService.save(product);
        return "redirect:findAll.do";
    }

    /**
     * 查询全部产品
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        // 查询全部商品
        List<Product> ps = productService.findAll();
        // 设置域对象
        mv.addObject("productList", ps);


        // 调试 print productList
        System.out.println(ps);

        // 设置返回页面
        mv.setViewName("product-list");
        return mv;
    }
}
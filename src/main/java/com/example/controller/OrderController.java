package com.example.controller;

import com.example.entity.Order;
import com.example.service.OrderService;
import com.example.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@CrossOrigin(value = {"http://localhost:8081"}, allowCredentials = "true")
@RequestMapping("/order")
@ResponseBody
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/getOrders")
    public Result getOrders(int state){
        List<Order> list;
        if(state == -1){
            list = orderService.getAllOrders();
        }else{

        }
        return new Result();
    }
}

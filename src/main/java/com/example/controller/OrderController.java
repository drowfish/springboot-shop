package com.example.controller;

import com.example.entity.Cart;
import com.example.entity.Order;
import com.example.entity.OrderInfo;
import com.example.service.OrderService;
import com.example.util.Result;
import com.example.util.stateAndMessage.StateAndMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin(value = {"http://localhost:8081"}, allowCredentials = "true")
@RequestMapping("/order")
@ResponseBody
public class OrderController {

    @Resource
    private OrderService orderService;

    //用户获取个人订单以及购物车内的东西
    @RequestMapping("/getOrdersByUser")
    public Result getOrdersByUser(Integer state,HttpSession session){
        Long userid = (Long)session.getAttribute("id");
        List<OrderInfo> list = orderService.getOrderByState(userid,state);
        return new Result(StateAndMessage.SUCCESS,"",list);
    }
    //管理员获取订单
    @RequestMapping("/getOrdersByAdmin")
    public Result getOrdersByAdmin(Integer state){
        List<OrderInfo> list = orderService.getOrdersByAdmin(state);
        return new Result(StateAndMessage.SUCCESS,"",list);
    }

    @RequestMapping("/addOrder")
    public Result addOrder(@RequestBody Order order, HttpSession session){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String string = simpleDateFormat.format(date);
        Long userid = (Long)session.getAttribute("id");

        order.setUserid(userid);
        order.setCreatetime(string);
        order.setUpdatetime(string);

        orderService.addOrder(order);
        return new Result(StateAndMessage.SUCCESS,"",null);
    }

    @RequestMapping("/deleteOrder")
    public Result deleteOrder(Long id){
        orderService.deletOrder(id);
        return new Result(StateAndMessage.SUCCESS,"",null);
    }

    //订单相关信息成批修改
    @RequestMapping("/settleAccounts")
    public Result settleAccounts(@RequestBody Cart cart){
        orderService.settleAccounts(cart.getCartList());
        return new Result(StateAndMessage.SUCCESS,"",null);
    }
}

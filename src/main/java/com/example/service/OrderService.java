package com.example.service;

import com.example.dao.OrderMapper;
import com.example.entity.Order;
import com.example.entity.OrderExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    public List<Order> getAllOrders(){
        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause("id ASC");
        return orderMapper.selectByExample(orderExample);
    }

    public List<Order> getOrderByState(int state){
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andStateEqualTo(state);
        return orderMapper.selectByExample(orderExample);
    }
}

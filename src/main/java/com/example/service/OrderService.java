package com.example.service;

import com.example.dao.OrderMapper;
import com.example.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.SimpleBeanInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private GoodsDetailService goodsDetailService;
    @Resource
    private GoodsService goodsService;
    @Resource
    private CommentService commentService;
    @Resource
    private UserService userService;
    //用户获取订单
    public List<OrderInfo> getOrderByState(Long userid,Integer state){
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        if(state != -1){
            criteria.andStateEqualTo(state);
        }
        List<Order> list = orderMapper.selectByExample(orderExample);
        List<OrderInfo> list1 = new ArrayList<>();

        if(list.isEmpty())
            return list1;

        for(Order order : list){
            GoodsDetail goodsDetail = goodsDetailService.getGoodsDetailById(order.getGoodsdetailid());

            if(goodsDetail == null){
                continue;
            }

            GoodsInfo goodsInfo = goodsService.getGoodsInfo(goodsDetail.getGoodsid());

            if(goodsInfo == null){
                continue;
            }

            List<Comment> list2 = commentService.hasComment(order.getId());
            boolean hasComment;
            if(list2.isEmpty()){
                hasComment = false;
            }else{
                hasComment = true;
            }
            OrderInfo orderInfo = new OrderInfo(order.getId(),null,goodsInfo,goodsDetail,order.getGoodsnum(),order.getAmount(),order.getState(),hasComment,order.getUpdatetime(),order.getCreatetime());
            list1.add(orderInfo);
        }
        return list1;
    }

    //管理员获取订单
    public List<OrderInfo> getOrdersByAdmin(Integer state){
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        orderExample.setOrderByClause("id ASC");
        if(state != -1){
            criteria.andStateEqualTo(state);
        }
        List<Order> list = orderMapper.selectByExample(orderExample);
        List<OrderInfo> list1 = new ArrayList<>();

        if(list.isEmpty())
            return list1;

        for(Order order : list){
            GoodsDetail goodsDetail = goodsDetailService.getGoodsDetailById(order.getGoodsdetailid());

            if(goodsDetail == null){
                continue;
            }

            GoodsInfo goodsInfo = goodsService.getGoodsInfo(goodsDetail.getGoodsid());

            if(goodsInfo == null){
                continue;
            }

            List<Comment> list2 = commentService.hasComment(order.getId());
            boolean hasComment;
            if(list2.isEmpty()){
                hasComment = false;
            }else{
                hasComment = true;
            }

            User user = userService.getUserById(order.getUserid());
            if(user == null){
                continue;
            }
            OrderInfo orderInfo = new OrderInfo(order.getId(),user,goodsInfo,goodsDetail,order.getGoodsnum(),order.getAmount(),order.getState(),hasComment,order.getUpdatetime(),order.getCreatetime());
            list1.add(orderInfo);
        }
        return list1;
    }

//    public OrderInfo getOrderById(Long id){
//        Order order = orderMapper.selectByPrimaryKey(id);
//
//        GoodsDetail goodsDetail = goodsDetailService.getGoodsDetailById(order.getGoodsdetailid());
//
//        GoodsInfo goodsInfo = goodsService.getGoodsInfo(goodsDetail.getGoodsid());
//
//        List<Comment> list2 = commentService.hasComment(order.getId());
//        boolean hasComment;
//        if(list2.isEmpty()){
//            hasComment = false;
//        }else{
//            hasComment = true;
//        }
//        User user = userService.getUserById(order.getUserid());
//        OrderInfo orderInfo = new OrderInfo(order.getId(),user,goodsInfo,goodsDetail,order.getGoodsnum(),order.getAmount(),order.getState(),hasComment,order.getUpdatetime(),order.getCreatetime());
//
//        return orderInfo;
//    }

    public void addOrder(Order order){
        orderMapper.insert(order);
    }

    public void deletOrder(Long id){
        orderMapper.deleteByPrimaryKey(id);
    }

    public void settleAccounts(List<Order> cartList){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String string = simpleDateFormat.format(date);

        for(Order item : cartList){
            item.setUpdatetime(string);
            orderMapper.updateByPrimaryKeySelective(item);
        }
    }
}

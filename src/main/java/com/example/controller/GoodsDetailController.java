package com.example.controller;

import com.example.entity.GoodsDetail;
import com.example.service.GoodsDetailService;
import com.example.util.Result;
import com.example.util.stateAndMessage.StateAndMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@CrossOrigin(value = {"http://localhost:8081"}, allowCredentials = "true")
@RequestMapping("/goodsDetail")
@ResponseBody
public class GoodsDetailController {

    @Resource
    private GoodsDetailService goodsDetailService;

    public Result addSpec(@RequestBody GoodsDetail goodsDetail){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String string = simpleDateFormat.format(date);
        goodsDetail.setCreatetime(string);
        goodsDetail.setUpdatetime(string);
        int flag = goodsDetailService.addSpec(goodsDetail);
        System.out.println("goodsDetail id:"+goodsDetail.getId());
        if(flag > 0){
            return new Result(StateAndMessage.SUCCESS,StateAndMessage.ADDSCUESS,goodsDetail);
        }
        return new Result(StateAndMessage.FAIL,StateAndMessage.ADDFAIL,null);
    }

    public Result deleteSpec(Long id){
        int flag = goodsDetailService.deleteSpec(id);
        if(flag > 0){
            return new Result(StateAndMessage.SUCCESS,StateAndMessage.DELETEUSERSUCCESS,null);
        }
        return new Result(StateAndMessage.FAIL,StateAndMessage.DELETEUSERFAIL,null);
    }
}

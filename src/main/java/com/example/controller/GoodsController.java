package com.example.controller;

import com.example.entity.Goods;
import com.example.entity.GoodsDetail;
import com.example.entity.GoodsInfo;
import com.example.service.GoodsDetailService;
import com.example.service.GoodsService;
import com.example.util.Result;
import com.example.util.stateAndMessage.StateAndMessage;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(value = {"http://localhost:8081"}, allowCredentials = "true")
@RequestMapping("/goods")
@ResponseBody
public class GoodsController {

    @Resource
    private GoodsService goodsService;
    @Resource
    private GoodsDetailService goodsDetailService;

    @RequestMapping("/getGoodsByType")
    public Result getGoodsByType(Long typeId){
        List<Goods> list = goodsService.getGoodsByType(typeId);
        return new Result(StateAndMessage.SUCCESS,StateAndMessage.GETGOODSBYTYPESUCCESS,list);
    }

    @RequestMapping("/deleteGoods")
    public Result deleteGoods(Long id){
        int flag = goodsService.deleteGoods(id);
        if(flag > 0){
            return new Result(StateAndMessage.SUCCESS,StateAndMessage.DELETEUSERSUCCESS,null);
        }
        return new Result(StateAndMessage.FAIL,StateAndMessage.DELETEUSERFAIL,null);
    }

    //获取商品详细信息
    @RequestMapping("/getGoodsInfo")
    public Result getGoodsInfo(Long id){
        GoodsInfo goodsInfo = goodsService.getGoodsInfo(id);
        return new Result(StateAndMessage.SUCCESS,"",goodsInfo);
    }

    @RequestMapping("/addGoods")
    public Result addGoods(@RequestBody GoodsInfo goodsInfo){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String string = simpleDateFormat.format(date);
        Goods goods = new Goods(goodsInfo.getId(),goodsInfo.getName(),goodsInfo.getTypeid(),goodsInfo.getImg(),string,string,goodsInfo.getDescription());
        int flag = goodsService.addGoods(goods);
        List<GoodsDetail> list = goodsInfo.getList();
        for(GoodsDetail item : list){
            item.setGoodsid(goods.getId());
            item.setCreatetime(string);
            item.setUpdatetime(string);
            goodsDetailService.addSpec(item);
        }

        if(flag > 0){
            return new Result(StateAndMessage.SUCCESS,StateAndMessage.ADDSCUESS,null);
        }
        return new Result(StateAndMessage.FAIL,StateAndMessage.ADDFAIL,null);
    }

    @RequestMapping("/addImg")
    public Result addImg(@RequestParam("file") MultipartFile file) throws IOException{
        String img = DigestUtils.md5DigestAsHex(file.getBytes());
        String path = "D:\\nginx\\nginx-1.15.10\\html\\"+img;
        File file1 = new File(path);
        file.transferTo(file1);
        return new Result(StateAndMessage.SUCCESS,StateAndMessage.ADDSCUESS,img);
    }

    @RequestMapping("/updateGoods")
    public Result updateGoods(@RequestBody GoodsInfo goodsInfo){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String string = simpleDateFormat.format(date);

        Goods goods = new Goods();
        goods.setUpdatetime(string);
        goods.setId(goodsInfo.getId());
        goods.setName(goodsInfo.getName());
        goods.setTypeid(goodsInfo.getTypeid());
        goods.setImg(goodsInfo.getImg());
        goods.setDescription(goodsInfo.getDescription());

        int flag = goodsService.updateGoods(goods);
        List<GoodsDetail> list = goodsInfo.getList();
        for(GoodsDetail item : list){
            item.setUpdatetime(string);
            goodsDetailService.updateGoodsDetail(item);
        }

        if(flag > 0){
            return new Result(StateAndMessage.SUCCESS,StateAndMessage.ADDSCUESS,null);
        }
        return new Result();
    }
}

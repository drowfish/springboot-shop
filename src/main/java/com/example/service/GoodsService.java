package com.example.service;

import com.example.dao.GoodsMapper;
import com.example.entity.*;
import com.example.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {

    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private GoodsDetailService goodsDetailService;

    public List<Goods> getGoodsByType(Long typeId){
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andTypeidEqualTo(typeId);
        return goodsMapper.selectByExampleWithBLOBs(goodsExample);
    }

    public int deleteGoods(Long id){
        return goodsMapper.deleteByPrimaryKey(id);
    }

    public GoodsInfo getGoodsInfo(Long id){
        GoodsInfo goodsInfo = goodsMapper.selectByPrimaryKey(id);
        return goodsInfo;
    }

    public int addGoods(Goods goods){
        return goodsMapper.insert(goods);
    }

    public int updateGoods(Goods goods){
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    public List<Goods> getAllGoods(){
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause("id ASC");
        return goodsMapper.selectByExampleWithBLOBs(goodsExample);
    }

    public List<GoodsInfo> searchGoods(String keyword){
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andNameLike("%"+keyword+"%");
        List<Goods> list = goodsMapper.selectByExampleWithBLOBs(goodsExample);
        List<GoodsInfo> list1 = new ArrayList<>();

        if(list.isEmpty()){
            return list1;
        }

        for(Goods goods : list){
            List<GoodsDetail> goodsDetail = goodsDetailService.getGoodsDetailByGoodsId(goods.getId());
            GoodsInfo goodsInfo = new GoodsInfo(goods.getId(),goods.getName(),goods.getTypeid(),goods.getImg(),goods.getUpdatetime(),goods.getCreatetime(),goods.getDescription(),goodsDetail);
            list1.add(goodsInfo);
        }

        return list1;
    }
}

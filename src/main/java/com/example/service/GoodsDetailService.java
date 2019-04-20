package com.example.service;

import com.example.dao.GoodsDetailMapper;
import com.example.entity.GoodsDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsDetailService {

    @Resource
    private GoodsDetailMapper goodsDetailMapper;

    public int addSpec(GoodsDetail goodsDetail){
        return goodsDetailMapper.insert(goodsDetail);
    }

    public int deleteSpec(Long id){
        return goodsDetailMapper.deleteByPrimaryKey(id);
    }

    public int updateGoodsDetail(GoodsDetail goodsDetail){
        return goodsDetailMapper.updateByPrimaryKeySelective(goodsDetail);
    }

}

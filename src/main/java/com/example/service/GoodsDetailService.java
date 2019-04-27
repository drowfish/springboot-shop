package com.example.service;

import com.example.dao.GoodsDetailMapper;
import com.example.entity.GoodsDetail;
import com.example.entity.GoodsDetailExample;
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

    public GoodsDetail getGoodsDetailById(Long id){
        return goodsDetailMapper.selectByPrimaryKey(id);
    }

    public List<GoodsDetail> getGoodsDetailByGoodsId(Long goodsid){
        GoodsDetailExample goodsDetailExample = new GoodsDetailExample();
        GoodsDetailExample.Criteria criteria = goodsDetailExample.createCriteria();
        criteria.andGoodsidEqualTo(goodsid);
        List<GoodsDetail> list = goodsDetailMapper.selectByExample(goodsDetailExample);
        return list;
    }
}

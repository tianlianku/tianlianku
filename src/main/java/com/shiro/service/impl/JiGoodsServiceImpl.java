package com.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shiro.entity.JiGoods;
import com.shiro.mapper.JiGoodsMapper;
import com.shiro.service.JiGoodsService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JiGoodsServiceImpl extends ServiceImpl<JiGoodsMapper, JiGoods> implements JiGoodsService {

    @Autowired
    private JiGoodsMapper jiGoodsMapper;

    @Override
    public List<JiGoods> getJiGoodsList(JiGoods jiGoods) {
        List<JiGoods> list=jiGoodsMapper.selectList(new LambdaQueryWrapper<>());
        return list;
    }

    @Override
    public Boolean updateJiGoods(Integer id, JiGoods jiGoods) {
        LambdaQueryWrapper<JiGoods> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(JiGoods::getId,id);
        Integer integer=jiGoodsMapper.update(jiGoods,lambdaQueryWrapper);
        if(integer==1){
            return true;
        }return false;
    }

    @Override
    public boolean saveJiGoods(JiGoods jiGoods) {
        jiGoods.setOrderid(DigestUtils.md5Hex(String.valueOf((System.currentTimeMillis() / 1000L))));
        jiGoods.setOrderdate(new Date());
        if(jiGoodsMapper.insert(jiGoods)==1){
            return true;
        }return false;
    }

    //根据电话号码查询
    @Override
    public List<JiGoods> phoneGet(Integer phone) {
        LambdaQueryWrapper<JiGoods> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(JiGoods::getUserphone,phone);
        return jiGoodsMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public List<JiGoods> nameGet(String name) {
        LambdaQueryWrapper<JiGoods> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(JiGoods::getUsername,name);
        List<JiGoods> list=jiGoodsMapper.selectList(lambdaQueryWrapper);
        return list;
    }

    @Override
    public List<JiGoods> orderId(String orderId) {
        LambdaQueryWrapper<JiGoods> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(JiGoods::getOrderid,orderId);
        return jiGoodsMapper.selectList(lambdaQueryWrapper);
    }
}

package com.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.shiro.entity.Goods;
import com.shiro.entity.JiGoods;
import com.shiro.mapper.GoodsMapper;
import com.shiro.service.GoodsService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoodsList(Goods goods) {
        QueryWrapper<Goods> queryWrapper=new QueryWrapper<>();
        List<Goods> goodsList=goodsMapper.selectList(queryWrapper);
        return goodsList;
    }

    @Override
    public Boolean updateGoods(Integer id, Goods goods) {
        LambdaQueryWrapper<Goods> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Goods::getId,id);
        Integer integer=goodsMapper.update(goods,lambdaQueryWrapper);
        if(integer==1){
            return true;
        }return false;
    }

    @Override
    public List<Goods> phoneGet(Integer phone) {
        PageHelper.startPage(1, 10);
        LambdaQueryWrapper<Goods> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Goods::getUserphone,phone);
        return goodsMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public List<Goods> nameGet(String username) {
        LambdaQueryWrapper<Goods> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Goods::getUsername,username);
        List<Goods> list=goodsMapper.selectList(lambdaQueryWrapper);
        return list;
    }

    @Override
    public List<Goods> orderId(String orderId) {
        LambdaQueryWrapper<Goods> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Goods::getOrderid,orderId);
        return goodsMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public boolean saveGoods(Goods goods) {
        goods.setOrderid(DigestUtils.md5Hex(String.valueOf((System.currentTimeMillis() / 1000L))));
        if(goodsMapper.insert(goods)==1){
            return true;
        }return false;
    }

}

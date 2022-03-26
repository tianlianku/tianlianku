package com.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shiro.entity.Goods;
import com.shiro.entity.JiGoods;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GoodsService extends IService<Goods> {
    //增删改查
    List<Goods>  getGoodsList(Goods goods);

    Boolean updateGoods(Integer id,Goods goods);

    List<Goods> phoneGet(Integer phone);

    List<Goods> nameGet(String username);

    List<Goods> orderId(String orderId);

    boolean saveGoods(Goods goods);
}

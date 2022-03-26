package com.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shiro.entity.Goods;
import com.shiro.entity.JiGoods;
import com.shiro.entity.common.CommonResult;

import java.util.List;

public interface JiGoodsService extends IService<JiGoods> {

    List<JiGoods> getJiGoodsList(JiGoods jiGoods);

    Boolean updateJiGoods(Integer id,JiGoods jiGoods);

    boolean saveJiGoods(JiGoods jiGoods);

    List<JiGoods> phoneGet(Integer phone);

    List<JiGoods> nameGet(String name);

    List<JiGoods> orderId(String orderId);
}

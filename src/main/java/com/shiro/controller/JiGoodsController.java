package com.shiro.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.shiro.entity.Goods;
import com.shiro.entity.JiGoods;
import com.shiro.entity.common.CommonResult;
import com.shiro.entity.common.ExceptionCodeEnum;
import com.shiro.service.JiGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jiGoods")
public class JiGoodsController {

    @Autowired
    private JiGoodsService jiGoodsService;

    //查全部
    @GetMapping("/selectJiGoods")
    public CommonResult<List<JiGoods>> selectGoods(JiGoods jiGoods) {
        if(jiGoods==null){
            return CommonResult.failed(ExceptionCodeEnum.PRAM_IS_NULL);
        }
        List<JiGoods> goodsList = jiGoodsService.getJiGoodsList(jiGoods);
        return CommonResult.success(goodsList);
    }

    //不同条件查询根据手机号，用户名，订单号，时间（不同的天，小时）
    //根据电话号码查找
    @GetMapping("/phoneGet")
    public CommonResult<List<JiGoods>> phoneGet(Integer phone){
        if(phone==null){
            return CommonResult.failed(ExceptionCodeEnum.PRAM_IS_NULL,"电话号码不能为空");
        }
        return CommonResult.success(jiGoodsService.phoneGet(phone));
    }

    //根据姓名查询 查询like
    @PostMapping("/nameGet")
    public CommonResult<List<JiGoods>> nameGet(String username){
        if(StringUtils.isBlank(username)){
            return CommonResult.failed("查询关键字不能为空");
        }
        return CommonResult.success(jiGoodsService.nameGet(username));
    }

    //根据orderid查询
    @PostMapping("/orderIdGet")
    public CommonResult<List<JiGoods>> orderIdGet(String orderId){
        if(StringUtils.isBlank(orderId)){
            return CommonResult.failed("订单号不能为空");
        }
        List<JiGoods> list=jiGoodsService.orderId(orderId);
        if(list==null&&list.size()==0){
            return CommonResult.failed("没有订单或输入的订单号错误");
        }
        return CommonResult.success(list);
    }

    @PostMapping("/insertJiGoods")
    public CommonResult insertGoods(@RequestBody JiGoods jiGoods){
        if(jiGoodsService.saveJiGoods(jiGoods)){
            return CommonResult.success();
        }else{
            return CommonResult.failed("JiGoods添加失败");
        }
    }

    //删除根据id
    @GetMapping("/delectJiGoods")
    public CommonResult delectGoods(JiGoods jiGoods){
        if(jiGoodsService.removeById(jiGoods.getId())){
            return CommonResult.success();
        }
        return CommonResult.failed("删除失败");
    }

    @GetMapping("updateJiGoods")
    public CommonResult updateGoods(@RequestBody JiGoods jiGoods,@RequestParam Integer id){
        if(jiGoodsService.updateJiGoods(id,jiGoods)){
            return CommonResult.success();
        }
        return CommonResult.failed("更新失败");
    }
}

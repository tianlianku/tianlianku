package com.shiro.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.shiro.entity.Goods;
import com.shiro.entity.JiGoods;
import com.shiro.entity.common.CommonResult;
import com.shiro.entity.common.ExceptionCodeEnum;
import com.shiro.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @GetMapping("/selectGoods")
    public CommonResult<List<Goods>> selectGoods(Goods goods) {
        if(goods==null){
            return CommonResult.failed("参数不能为空");
        }
        List<Goods> goodsList = goodsService.getGoodsList(goods);
        return CommonResult.success(goodsList);
    }

    //不同条件查询根据手机号，用户名，订单号，时间（不同的天，小时）
    //根据电话号码查找
    @GetMapping("/phoneGet")
    public CommonResult<List<Goods>> phoneGet(Integer phone){
        if(phone==null){
            return CommonResult.failed(ExceptionCodeEnum.PRAM_IS_NULL,"电话号码不能为空");
        }
        return CommonResult.success(goodsService.phoneGet(phone));
    }

    //根据姓名查询 查询like
    @PostMapping("/nameGet")
    public CommonResult<List<Goods>> nameGet(String username){
        if(StringUtils.isBlank(username)){
            return CommonResult.failed("查询关键字不能为空");
        }
        return CommonResult.success(goodsService.nameGet(username));
    }

    //根据orderid查询
    @PostMapping("/orderIdGet")
    public CommonResult<List<Goods>> orderIdGet(String orderId){
        if(StringUtils.isBlank(orderId)){
            return CommonResult.failed("订单号不能为空");
        }
        List<Goods> list=goodsService.orderId(orderId);
        if(list==null&&list.size()==0){
            return CommonResult.failed("没有订单或输入的订单号错误");
        }
        return CommonResult.success(list);
    }
    //查在一个时间段中取货的记录
    @PostMapping("/timeGet")
    public CommonResult<List<Goods>> timeGet(Date startTime,Date endTime){

        return CommonResult.success();
    }

    @PostMapping("/insertGoods")
    public CommonResult insertGoods(@RequestBody Goods goods){
        if(goods==null){
            return CommonResult.failed("参数不能为空");
        }
        if(goodsService.saveGoods(goods)){
            return CommonResult.success("添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    //删除根据id
    @GetMapping("/delectGoods")
    public CommonResult delectGoods(Goods goods){
        if(goods==null) {
            return CommonResult.failed("参数不能为空");
        }
            if(goodsService.removeById(goods.getId())){
            return CommonResult.success("删除失败");
        }
        return CommonResult.failed("删除失败");
    }

    @GetMapping("updateGoods")
    public CommonResult updateGoods(@RequestBody Goods goods,@RequestParam Integer id){
        if(goods==null&&id==null) {
            return CommonResult.failed("参数不能为空");
        }
        if(goodsService.updateGoods(id,goods)){
            return CommonResult.success("更新成功");
        }
        return CommonResult.failed("更新失败");
    }
}

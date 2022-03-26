package com;

import cn.binarywang.tools.generator.*;
import cn.binarywang.tools.generator.util.ChineseCharUtils;
import com.shiro.controller.UserController;
import com.shiro.entity.Goods;
import org.apache.commons.lang3.RandomUtils;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class test {
    @Test
    public void test1(){
        System.out.println(new Date());
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.format(new Date());
    }

    @Test
    public void test0(){
//        Goods userInfo = new Goods();
//            for(int j=0 ;j<(new Random().nextInt(200)+100);j++){
        for(int i=0;i<10;i++){
//            ChineseIDCardNumberGenerator cidcng = (ChineseIDCardNumberGenerator) ChineseIDCardNumberGenerator.getInstance();
//            System.out.println(cidcng.generate());
//            //中文姓名
//            ChineseNameGenerator cng = ChineseNameGenerator.getInstance();
//            System.out.println(cng.generate());
//            //英文姓名
//            EnglishNameGenerator eng = EnglishNameGenerator.getInstance();
//            System.out.println(eng.generate());
//            //手机号
//            ChineseMobileNumberGenerator cmng = ChineseMobileNumberGenerator.getInstance();
//            System.out.println(cmng.generate());
//            //电子邮箱
//            EmailAddressGenerator eag = (EmailAddressGenerator) EmailAddressGenerator.getInstance();
//            System.out.println(eag.generate());
            //居住地址
            ChineseAddressGenerator cag = (ChineseAddressGenerator) ChineseAddressGenerator.getInstance();
            System.out.println(getadd());
            }
    }
    public static String getadd(){
        StringBuilder result = new StringBuilder("山东省蓬莱市");
        result.append(ChineseCharUtils.genRandomLengthChineseChars(2, 3) + "路");
        result.append(RandomUtils.nextInt(1, 8000) + "号");
        result
                .append(ChineseCharUtils.genRandomLengthChineseChars(2, 3) + "小区");
        result.append(RandomUtils.nextInt(1, 20) + "单元");
        result.append(RandomUtils.nextInt(101, 2500) + "室");
        return result.toString();
    }

    @Test
    public void test2(){
        if(1==null){

        }

    }
}

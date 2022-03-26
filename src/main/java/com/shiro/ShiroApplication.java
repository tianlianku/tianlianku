package com.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@MapperScan(value ="com.shiro.mapper")
@EnableTransactionManagement
public class ShiroApplication {
    public static void main(String []args){
        SpringApplication.run(ShiroApplication.class,args);
    }
}

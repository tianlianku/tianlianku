package com.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Christy
 * @DESC
 * @Date 2020/11/16 15:49
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}


package com.like.parts.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.like.parts.entity.User;

/**
 * @author like
 * @create 2022-06-06-14:06
 */

/**
 * 用户表的service接口
 */
public interface IUserService  extends IService<User> {
/**
 * 根据用户名查询用户对象
 */
    public User queryUserByUsername(User user);
}

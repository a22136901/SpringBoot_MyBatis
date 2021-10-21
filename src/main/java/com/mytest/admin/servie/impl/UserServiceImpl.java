package com.mytest.admin.servie.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mytest.admin.bean.User;
import com.mytest.admin.mapper.UserMapper;
import com.mytest.admin.servie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }
}

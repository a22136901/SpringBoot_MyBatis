package com.mytest.admin.servie;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mytest.admin.bean.User;
import com.mytest.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;


public interface UserService extends IService<User> {

    public User getUserById(Integer id);
}

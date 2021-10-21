package com.mytest.admin;

import com.mytest.admin.bean.User;
import com.mytest.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SpringBootMyBatisApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testUserMapper(){
        User user = userMapper.selectById(2);
        /**
         * 直接使用baseMapper中的方法，bean需要对应，否则报错。所以一些其他属性可以使用
         *          @TableField(exist = false)，来表示这个属性在表中不存在。
         */
        log.info("用户信息:{}",user);
    }

}

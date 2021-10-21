package com.mytest.admin;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;


@MapperScan("com.mytest.admin.mapper")
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
public class SpringBootMyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMyBatisApplication.class, args);
    }

}

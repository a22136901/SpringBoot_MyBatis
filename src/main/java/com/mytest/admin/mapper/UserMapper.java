package com.mytest.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mytest.admin.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * MybatisPlus中有个基类Mapper，
 *      它声明了一些方法，直接就有CRUD功能，<>中传入表名，或者在bean标注@TableName("")，否则不能操作表。
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM USER WHERE id = #{id}")
    public User getUserById(Integer id);
}

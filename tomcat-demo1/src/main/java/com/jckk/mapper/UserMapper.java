package com.jckk.mapper;

import com.jckk.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(String username); // 用于注册时检查用户名是否已存在

    @Select("insert into tb_user(username, password) values(#{username}, #{password})")
    void add(User user);
}

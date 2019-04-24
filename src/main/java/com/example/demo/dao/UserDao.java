package com.example.demo.dao;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 用户数据新增
     */
    @Insert("insert into user(id,name,age) values (#{id},#{name},#{age})")
    void addUser(User user);

    /**
     * 用户数据修改
     */
    @Update("update user set name=#{name},sex=#{sex} where id=#{id}")
    void updateUser(User user);

    /**
     * 用户数据删除
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(int id);

    /**
     * 根据用户名称查询用户信息
     *
     */
    @Select("SELECT id,name,sex FROM user where name=#{name}")
    User findByName(@Param("name") String name);

    /**
     * 查询所有
     */
    @Select("SELECT id,name,sex FROM user")
    List<User> findAll();
}

package com.example.service;

import com.example.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: F7687967
 * @date: 2017/10/18
 * @time: 下午 04:43
 * @description:
 */

@Mapper
public interface UserMapper {

    /**
     * 新增一个用户
     */
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    void create(User user);

    /**
     * 根据name删除一个用户
     */
    @Delete("DELETE FROM user WHERE name =#{name}")
    void deleteByName(@Param("name") String name);

    /**
     * 获取用户总量
     */
    @Select("select count(1) from USER")
    Integer getAllUsersNum();

    /**
     * 删除所有用户
     */
    @Delete("DELETE FROM user")
    void deleteAllUsers();

    /**
     * 根据id获取一个用户
     */
    @Select("SELECT * FROM USER WHERE id = #{id}")
    User getUserById(@Param("id") Integer id);

    /**
     * 根据id更新一个用户的信息
     */
    @Update("UPDATE user SET name=#{name}, age=#{age} where id=#{id}")
    void updateUserById(User user);

    /**
     * 获取所有用户的信息
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT id, name, age FROM user")
    List<User> findAllUsers();

}
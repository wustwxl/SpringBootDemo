package com.example.entity;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : F7687967
 * Date: 2017/10/16
 * Time: 上午 08:09
 * Description:
 */

public class User implements Serializable {

    /**
     * @Description: 将对象进行序列化, 可实现在Redis中存储该对象
     */
    private static final long serialVersionUID = -1L;

    private Long id;

    private String name;

    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Integer getAge() {

        return age;
    }

    public void setAge(Integer age) {

        this.age = age;
    }
}
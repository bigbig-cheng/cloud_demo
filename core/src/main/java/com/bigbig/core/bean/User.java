package com.bigbig.core.bean;

import java.io.Serializable;

/**
 * Created by doufu on 2018/3/11.
 */
public class User implements Serializable{

    private static final long serialVersionUID = -2633486851310957655L;

    public User(){}

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "name=" + this.name + ", age=" + this.age;
    }

    private String name;
    private Integer age;

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

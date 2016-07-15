package com.example.xc.mnproject;

import java.io.Serializable;

/**
 * Created by XC on 2016/6/26.
 */
public class User implements Serializable{
    String name;
    int age;
    public User(String name,int age)
    {
        this.name=name;
        this.age=age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package com.exc.wuh.bean;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
//数据库表
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)//主键是否自动增长，默认为false
    private int uid;
    private String name;
    private int age;

    public int getUid(){
        return uid;
    }
    public void setUid(int uid){
        this.uid = uid;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}

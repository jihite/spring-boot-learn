package com.jihite.entity;

import com.jihite.enums.SexEnum;

public class UserEntity {
    private Long id;
    private String name;
    private String passwd;
    private SexEnum sex;

    public UserEntity() {

    }

    public UserEntity(String name, String passwd, SexEnum sex) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.sex = sex;
    }

    public long getId() {
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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return String.format("+++++ id:%s, name:%s, passwd:%s, sex:%s\n", id, name, passwd, sex);
    }
}

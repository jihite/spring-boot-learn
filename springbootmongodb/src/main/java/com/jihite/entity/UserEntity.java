package com.jihite.entity;

public class UserEntity {
    private int id;
    private String name;
    private String passwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @Override
    public String toString() {
        return String.format("id:%s, name:%s, passwd:%s", id, name, passwd);
    }
}

package com.jihite.dao;

import com.jihite.entity.UserEntity;

public interface UserDao {
    void saveUser(UserEntity userDao);
    UserEntity getUserByName(String name);
    long updateUserEntity(UserEntity userEntity);
    void deleteUserById(int id);
}

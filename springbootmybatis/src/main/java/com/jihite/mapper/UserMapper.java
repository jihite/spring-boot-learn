package com.jihite.mapper;

import com.jihite.entity.UserEntity;
import com.jihite.enums.SexEnum;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    @Select("select * from users")
    @Results({
            @Result(property = "name", column = "userName"),
            @Result(property = "passwd", column = "passWord"),
            @Result(property = "sex", column = "user_sex", javaType = SexEnum.class),
    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM users WHERE id=#{id}")
    @Results({
            @Result(property = "name", column = "userName"),
            @Result(property = "passwd", column = "passWord"),
            @Result(property = "sex", column = "user_sex", javaType = SexEnum.class),
    })
    UserEntity getOne(Long id);

    @Insert("INSERT INTO users(userName, passWord, user_sex) VALUES(#{name}, #{passwd}, #{sex})")
    void insert(UserEntity user);

    @Update("UPDATE users SET userName=#{name}, passWord=#{passwd} where id=#{id}")
    void update(UserEntity user);

    @Delete("DELETE from users where id=#{id}")
    void delete(Long id);
}

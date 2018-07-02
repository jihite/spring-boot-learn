package com.jihite;

import com.jihite.entity.UserEntity;
import com.jihite.enums.SexEnum;
import com.jihite.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testGetAll() {
        List<UserEntity> userEntityList = userMapper.getAll();
        System.out.println(userEntityList);
    }

    @Test
    public void testGetOne() {
        UserEntity userEntity =  userMapper.getOne(34L);
        System.out.println(userEntity);
    }

    @Test
    public void testInsert() {
        userMapper.insert(new UserEntity("a", "paswd-a", SexEnum.MAN));
        userMapper.insert(new UserEntity("b", "paswd-b", SexEnum.WOMAN));
        userMapper.insert(new UserEntity("c", "paswd-c", SexEnum.MAN));
    }

    @Test
    public void update() {
        UserEntity user = userMapper.getOne(35L);
        if (user != null) {
            user.setPasswd("jihite-update");
            userMapper.update(user);
            System.out.println(userMapper.getOne(35L));
        }
    }

    @Test
    public void delete() {
        userMapper.delete(35L);
    }
}

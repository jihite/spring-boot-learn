package com.jihite.dao.impl;

import com.jihite.dao.UserDao;
import com.jihite.entity.UserEntity;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(UserEntity userDao) {
        mongoTemplate.save(userDao);
    }

    @Override
    public UserEntity getUserByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, UserEntity.class);
    }

    @Override
    public long updateUserEntity(UserEntity userEntity) {
        Query query = new Query(Criteria.where("id").is(userEntity.getId()));
        Update update = new Update().set("name", userEntity.getName()).set("passwd", userEntity.getPasswd());
        UpdateResult writeResult = mongoTemplate.updateFirst(query, update, UserEntity.class);
        return writeResult.getMatchedCount();
    }

    @Override
    public void deleteUserById(int id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, UserEntity.class);
    }

}

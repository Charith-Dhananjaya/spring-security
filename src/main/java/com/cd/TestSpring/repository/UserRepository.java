package com.cd.TestSpring.repository;

import com.cd.TestSpring.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, ObjectId> {

    Users findByUserName(String username);

}

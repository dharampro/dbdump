package com.techendear.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.techendear.api.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

}

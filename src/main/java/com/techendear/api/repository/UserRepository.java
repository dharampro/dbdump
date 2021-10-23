package com.techendear.api.repository;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.techendear.api.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

    User findByContactNumber(String contactNumber);
    
    @DeleteQuery
    void deleteByContactNumber(String contactNumber);
}

package com.techendear.api.service;

import com.techendear.api.entity.User;

public interface UserService {

    public User createUser(User user);

    public User getUserByContactNumber(String contactNumber);
    
    public User updateUserByContactNumber(User user, String contactNumber);
   
    public void deleteUserByContactNumber(String contactNumber);
}

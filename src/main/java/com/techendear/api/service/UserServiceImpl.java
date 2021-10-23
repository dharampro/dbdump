package com.techendear.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techendear.api.entity.User;
import com.techendear.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
	return this.userRepository.save(user);
    }

    @Override
    public User getUserByContactNumber(String contactNumber) {
	return this.userRepository.findByContactNumber(contactNumber);
    }

    @Override
    public User updateUserByContactNumber(User user, String contactNumber) {
	User userDb = this.userRepository.findByContactNumber(contactNumber);
	if (userDb == null) {
	    return this.userRepository.save(user);
	} else {
	    userDb.setId(user.getId());
	    userDb.setFirstName(user.getFirstName());
	    userDb.setLasteName(user.getLasteName());
	    userDb.setEmail(user.getEmail());
	    userDb.setContactNumber(user.getContactNumber());
	    return this.userRepository.save(userDb);
	}
    }

    @Override
    public void deleteUserByContactNumber(String contactNumber) {
	this.userRepository.deleteByContactNumber(contactNumber);
    }
}

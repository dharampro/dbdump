package com.techendear.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techendear.api.constant.ErrorMessage;
import com.techendear.api.entity.User;
import com.techendear.api.exception.ConflictException;
import com.techendear.api.repository.UserRepository;
import com.techendear.api.util.UserDtoMapUtil;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDtoMapUtil userDtoMapUtil;

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
	    user.setContactNumber(contactNumber);
	    return this.userRepository.save(user);
	} else {
	    user.setId(userDb.getId());
	    user.setContactNumber(userDb.getContactNumber());
	    if (userDb.equals(user)) {
		throw new ConflictException(ErrorMessage.ACCOUNT_EXISTS.value());
	    } else {
		return this.userRepository.save(this.userDtoMapUtil.updateUserMap(user, userDb));
	    }
	}
    }

    @Override
    public void deleteUserByContactNumber(String contactNumber) {
	this.userRepository.deleteByContactNumber(contactNumber);
    }
}

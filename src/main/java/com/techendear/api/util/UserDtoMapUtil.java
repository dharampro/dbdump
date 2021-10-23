package com.techendear.api.util;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.techendear.api.entity.User;

@Component
public class UserDtoMapUtil {
    public User updateUserMap(User user, User updatedUser) {
	return Optional.of(updatedUser).map(usr -> {
	    usr.setFirstName(user.getFirstName());
	    usr.setLastName(user.getLastName());
	    usr.setEmail(user.getEmail());
	    usr.setContactNumber(user.getContactNumber());
	    return usr;
	}).get();
    }
}

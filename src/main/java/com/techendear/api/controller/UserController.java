package com.techendear.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techendear.api.constant.ErrorMessage;
import com.techendear.api.entity.User;
import com.techendear.api.exception.InvaliedRequestException;
import com.techendear.api.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
	return ResponseEntity.ok(Optional.ofNullable(this.userService.createUser(user))
		.orElseThrow(() -> new InvaliedRequestException(ErrorMessage.INVALID_REQUEST.value())));
    }

    @GetMapping("/{contactNumber}")
    public ResponseEntity<User> getUserByContactNumber(@PathVariable("contactNumber") String contactNumber) {
	return ResponseEntity
		.ok(Optional.ofNullable(this.userService.getUserByContactNumber(contactNumber)).orElseThrow());
    }

    @PutMapping("/{contactNumber}")
    public ResponseEntity<User> updateUser(@RequestBody User user,
	    @PathVariable("contactNumber") String contactNumber) {
	return ResponseEntity
		.ok(Optional.ofNullable(this.userService.updateUserByContactNumber(user, contactNumber)).orElseThrow());
    }

    @DeleteMapping("/{contactNumber}")
    public void deleteByContactNumber(@PathVariable("contactNumber") String contactNumber) {
	this.userService.deleteUserByContactNumber(contactNumber);
    }
}

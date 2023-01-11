package com.springboot.blog.services;

import java.util.List;

import com.springboot.blog.entities.User;
import com.springboot.blog.payloads.UserDto;

public interface UserService {

	UserDto registerUser(UserDto user);
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer id);
	UserDto getUserById(Integer id);
	List<UserDto> getAllUsers();
	void deleteUser(Integer id);
}

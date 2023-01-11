package com.springboot.blog.controllers;

import java.net.http.HttpResponse;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.payloads.ApiResponse;
import com.springboot.blog.payloads.UserDto;
import com.springboot.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//POST - create User
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto createdUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
	}
	
	//PUT - update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid)
	{
		UserDto updatedUser = this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);
	}
	
	
	//ADMIN
	//DELETE - delete user
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid){
		this.userService.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
		
	}
	
	//GET - get users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	
	@GetMapping("/{uid}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer uid)
	{
		return ResponseEntity.ok(this.userService.getUserById(uid));
	}

}

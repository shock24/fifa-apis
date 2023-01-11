package com.springboot.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.springboot.blog.entities.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min=4, message="username length must be > 3")
	private String name;
	
	@Email(message =  "Email address is not valid")
	private String email;
	
	@NotEmpty
	@JsonProperty(access = Access.WRITE_ONLY)  //prevents password display when returning userDto as a response
	@Size(min = 3, max = 10, message = "Password must be >2 and <11")
	private String password;
	
	@NotEmpty
	private String about;
	
	private Set<RoleDto> roles = new HashSet<>();

}

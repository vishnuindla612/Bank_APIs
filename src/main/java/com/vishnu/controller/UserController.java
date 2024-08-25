package com.vishnu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishnu.dto.UserDto;
import com.vishnu.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	
	
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

//	rest Api for get user
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
		
		return  ResponseEntity.ok(userService.getUser(userId));
	}
//  withdwar api 
	@PutMapping("/withdraw/{userId}")
	public ResponseEntity<UserDto> withdraw(@PathVariable Long userId,@RequestBody Map<String,Double> request) {
		UserDto userDto = userService.withdraw(userId, request.get("amount"));
		return ResponseEntity.ok(userDto);
	}
//	Rest Api  for Deposite
    @PutMapping("/deposite/{userId}")
	public ResponseEntity<UserDto> deposite(@PathVariable Long userId,@RequestBody Map<String,Double> request) {
    	UserDto userDto = userService.deposite(userId,request.get("amount"));
    	
		return ResponseEntity.ok(userDto);
	}
// 	Rest Api for add user
	@PostMapping
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto)
	{
		return new ResponseEntity<>(userService.createAccount(userDto),HttpStatus.CREATED);
	}

//	delete Api
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id)
	{
		return ResponseEntity.ok("user deleted...");
	}
//	getAllUsers Api
	@GetMapping("/getAll")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		List<UserDto> allUsers = userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
		
	}
	
}

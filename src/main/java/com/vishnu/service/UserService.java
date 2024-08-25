package com.vishnu.service;

import java.util.List;

import com.vishnu.dto.UserDto;

public interface UserService {
	UserDto getBalance(Long userId);
	UserDto withdraw(Long userId,Double amount);
	UserDto getUser(Long userId);
	UserDto deposite(Long userId,Double amount);
	UserDto createAccount(UserDto userDto);
	UserDto deleteAccount(Long userId);
	List<UserDto> getAllUsers();
}

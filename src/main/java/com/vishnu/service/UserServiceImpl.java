package com.vishnu.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishnu.dto.UserDto;
import com.vishnu.entity.User;
import com.vishnu.mapper.UserMapper;
import com.vishnu.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	
	@Override
	public UserDto getUser(Long userId) {
		User user  = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("invalid id "+userId));
		UserDto dto=UserMapper.mapToUserDto(user);
		return dto;
		
	}

	

	@Override
	public UserDto createAccount(UserDto userDto) {
		
		User user=UserMapper.mapToUser(userDto);
		 user = userRepository.save(user);
		return UserMapper.mapToUserDto(user);
	}


	@Override
	public UserDto getBalance(Long userId) {
		
		return null;
	}


	@Override
	public UserDto withdraw(Long userId,Double Amount) {
		User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("user Doesnot exist"));
		Double total =user.getBalance()-Amount;
		user.setBalance(total);
		userRepository.save(user);
		UserDto userDto = UserMapper.mapToUserDto(user);
		return userDto;
	}


	@Override
	public UserDto deposite(Long userId,Double amount)  {
		User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("no user found"));
		Double toatal= user.getBalance()+amount;
		user.setBalance(toatal);
		userRepository.save(user);
		UserDto userDto = UserMapper.mapToUserDto(user);
		return userDto;
	}


	@Override
	public UserDto deleteAccount(Long userId) {
		 User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("No user exist..."));
		 UserDto userDto = UserMapper.mapToUserDto(user);
		 userRepository.deleteById(userId);
		 
				return userDto;
	}


	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> list = userRepository.findAll();
	 List<UserDto> list1 = list.stream().map((user)->UserMapper.mapToUserDto(user)).collect(Collectors.toList());
				return list1;
	}
	
}

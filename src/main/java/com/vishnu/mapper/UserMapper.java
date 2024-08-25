package com.vishnu.mapper;

import com.vishnu.dto.UserDto;
import com.vishnu.entity.User;

public class UserMapper {
	public static User mapToUser(UserDto userDto)
	{
		
		User user=new User(userDto.getUserId(),userDto.getFirstName(),userDto.getLastName(),userDto.getBalance());
		return user;
		
	}
	public static UserDto mapToUserDto(User user){
		UserDto userDto=new UserDto(user.getUserId(),user.getFirstName(),user.getLastName(),user.getBalance());
		return userDto;
		
	}
}

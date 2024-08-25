package com.vishnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishnu.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

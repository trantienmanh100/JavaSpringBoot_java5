package com.lab34.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab34.entities.User;

public interface IUserrepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}

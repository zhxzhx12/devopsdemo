package com.vt.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vt.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByName(String name);
}

package com.vt.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.vt.demo.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

}

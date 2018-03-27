package com.vt.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vt.demo.entity.SysRole;

public interface RoleRepository extends JpaRepository<SysRole, Integer>{
	SysRole findByName(String name);
	
	List<SysRole> findByNameContaining(String name);
	
	
}

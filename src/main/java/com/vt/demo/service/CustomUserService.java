package com.vt.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vt.demo.entity.Permission;
import com.vt.demo.entity.SysRole;
import com.vt.demo.entity.User;
import com.vt.demo.repository.RoleRepository;
import com.vt.demo.repository.UserRepository;

@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {

//    	User user = userRepository.findById(1).get();
		User user = userRepository.findByName(username);

		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();

		for (SysRole role : user.getRoles()) {
			for (Permission permission : role.getPermissions()) {
				if (permission != null && permission.getName() != null) {

//					GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
					GrantedAuthority grantedAuthority = new MethodAwareGrantedAuthority(permission.getUrl(),permission.getMethod());
					authorities.add(grantedAuthority);
				}
			}

			System.out.println(role.getName());
		}
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
	}
}

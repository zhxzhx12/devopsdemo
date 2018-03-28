package com.vt.demo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vt.demo.entity.User;
import com.vt.demo.repository.UserRepository;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */

@RestController
public class DemoController {

	@Autowired
	private UserRepository userRepository;

	private static final String template = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();

	public boolean someLibraryMethod() {
		return true;
	}

	public boolean oneMethodReturnFalse() {
		return false;
	}

	@RequestMapping(path = "/")
	public String greeting(Model model) {

		return "Greeting ";
	}

	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public Iterable<User> greeting(@RequestParam(value = "name", defaultValue = "zhangsan") String name) {
		List<User> users = userRepository.findAll();
		users.stream().forEach(user -> user.setRoles(null));
		return users;

	}

	@GetMapping(path = "/user/add")
	public String addNewUser(@RequestParam String name, @RequestParam(value ="email", required=false) String email) {

		long count = userRepository.count();
		
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		n.setPassword(name);
		
		n.setId(Long.valueOf(count + 1).intValue());
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

}

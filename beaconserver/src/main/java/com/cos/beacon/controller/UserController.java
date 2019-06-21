package com.cos.beacon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.beacon.Dto.ResponseDto;
import com.cos.beacon.model.User;
import com.cos.beacon.repository.UserRepository;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	
	//회원 가입 시
	@PostMapping("/join")  
	public void join(User user) {
		String rawPassword = user.getPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		System.out.println(user);
		userRepository.save(user);
		
		          //회원 가입 시

	}
	
	@GetMapping("/login")
	public @ResponseBody User login(String username,String password) {
		System.out.println(username);
		System.out.println(password);
		User user = userRepository.findByUsername(username); 
		
	
		ResponseDto Login = new ResponseDto(); 
		if(user !=null) {
			System.out.println("유저이름"+user.getName());
			System.out.println("유저비번"+user.getUsername());
			System.out.println("로그인완료");
			Boolean psCheck = passwordEncoder.matches(password,user.getPassword());
			return user;
		}else {
			return null;
		}
	}
	
	
}

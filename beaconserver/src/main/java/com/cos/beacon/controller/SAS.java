package com.cos.beacon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.beacon.model.AttendanceCheck;
import com.cos.beacon.model.User;
import com.cos.beacon.repository.AttendanceCheckRepository;
import com.cos.beacon.repository.UserRepository;

@Controller
public class SAS{
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AttendanceCheckRepository attendanceCheckRepository;
	
	
	
	@PostMapping("/update")
	public String update(int id ,String userName , String password) {
		
		User user = userRepository.findById(id).get();
		user.setUsername(userName);
		user.setPassword(password);
		
		userRepository.save(user);
		
		return "ok";             //회원정보  수정
	}
	
	@GetMapping("/myattendce")
	public @ResponseBody Optional<List<AttendanceCheck>> myattendce(int userId) {
		
		Optional<List<AttendanceCheck>> attendanceCheck = attendanceCheckRepository.findByUserId(userId);
		System.out.println(attendanceCheck);
		return attendanceCheck;          //내 출석리스트 
	}
	
	
	@GetMapping("/beacon")
	public @ResponseBody String beacon(int userId,String password) {
		AttendanceCheck attendanceCheck = attendanceCheckRepository.checking(userId);
		User user = userRepository. findByPassword(password);
		if(attendanceCheck.getChecking().equals("false")&&attendanceCheck.getUserId().getPassword().equals(password)) {
			System.out.println("출석체크완료");
			attendanceCheck.setChecking("true");
			attendanceCheckRepository.save(attendanceCheck);
	
		}
		else if(attendanceCheck.getChecking().equals("false")&&attendanceCheck.getUserId().getPassword().equals(password)) {
			
			attendanceCheck.setChecking("true");
			attendanceCheckRepository.save(attendanceCheck);
			
			
			             //출결하기
		}
		return "ok";
	}
	
	
	
}

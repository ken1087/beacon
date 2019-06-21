package com.cos.beacon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.beacon.model.AttendanceCheck;
import com.cos.beacon.model.User;

public interface AttendanceCheckRepository extends JpaRepository<AttendanceCheck, Integer>{
	
	//public AttendanceCheck findByUser(User user); 
	
	
	@Query(value="select * from Attendancecheck  where userid = ?1 order by id DESC limit 1 ;", nativeQuery=true)
	public AttendanceCheck checking(int userId);
	
	@Query(value="select * from Attendancecheck where userid = ?1", nativeQuery=true)
	public Optional<List<AttendanceCheck>> findByUserId(int userId);
	
	
	
}

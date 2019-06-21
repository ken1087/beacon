package com.cos.beacon;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.cos.beacon.model.AttendanceCheck;
import com.cos.beacon.model.User;
import com.cos.beacon.repository.AttendanceCheckRepository;
import com.cos.beacon.repository.UserRepository;


@Component
public class Time {
	  //RaspiSensor rs;
	  Logger logger = LoggerFactory.getLogger(this.getClass());
	  private AtomicInteger loopCounter = new AtomicInteger();

	  @Autowired
	  private StopWatch watch;
	  
	  @Autowired
	  private UserRepository userRepository; 
	  
	  @Autowired
	  private AttendanceCheckRepository attendanceCheckRepository;

	  @PostConstruct
	  public void init() {
	    watch.start();
	  }

	/*
	 * @Scheduled(fixedDelayString = "300000") public void tick() throws
	 * InterruptedException { watch.stop(); if(MainController.raspisensor!=null) {
	 * RaspiSensor ras = MainController.raspisensor; //String res =
	 * "온도 : "+ras.getTemp()+"℃ , "+"습도 : "+ras.getHumi()+"%";
	 * //System.out.println(res); if(ras.getManagement()!=null) { TempAndHumi tah =
	 * TempAndHumi.builder() .temp(ras.getTemp()) .humi(ras.getHumi())
	 * .management(ras.getManagement()) .build(); tempAndHumiRepository.save(tah); }
	 * } watch.start(); }
	 */
	  
	  @Scheduled(cron = "0 20 12 * * *")
	  public void mamageInit() throws InterruptedException {
	    watch.stop();
	    List<User> list = userRepository.findAll();
	      if(list!=null) {
	        for(int i=0; i<list.size();i++) {
	          AttendanceCheck attendanceCheck = AttendanceCheck.builder()
	            .userId(list.get(i))
	            .checking("false")
	            .build();
	          attendanceCheckRepository.save(attendanceCheck);
	     
	        }
	      }
	    watch.start();
	  }
	  

	  @Bean
	  public StopWatch watch() {
	    return new StopWatch();
	  }
	}
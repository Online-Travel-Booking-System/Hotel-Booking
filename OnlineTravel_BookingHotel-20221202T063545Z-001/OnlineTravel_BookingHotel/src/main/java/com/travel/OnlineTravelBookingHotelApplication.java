package com.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // triggers auto-configuration and component scanning
public class OnlineTravelBookingHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineTravelBookingHotelApplication.class, args);
		//informs jdk to run a program as a Spring Application
	}
}

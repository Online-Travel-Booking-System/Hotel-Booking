package com.travel.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.travel.dto.UserDefaultResponseDto;
import com.travel.entity.HotelBooking;

@Component
@Scope("singleton")
public class HotelDTOConvertor 
{
public static UserDefaultResponseDto getHotelDefaultDTO(HotelBooking hotelbooking)
{
	UserDefaultResponseDto  dto = new UserDefaultResponseDto(
			hotelbooking.getHotelName(),hotelbooking.getHotelId()
			);
			
        return dto;
	
}
}
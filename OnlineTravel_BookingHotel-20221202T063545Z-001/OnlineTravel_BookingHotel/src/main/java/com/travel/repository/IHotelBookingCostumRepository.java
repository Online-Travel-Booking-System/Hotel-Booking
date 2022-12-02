package com.travel.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.travel.entity.HotelBooking;

@Repository
public interface IHotelBookingCostumRepository {
	public HotelBooking getHotelByHotelName(String hotelName) throws Exception;// Sort By Name(GET)

	public List<HotelBooking> getHotelByCost(int cost) throws Exception;

}

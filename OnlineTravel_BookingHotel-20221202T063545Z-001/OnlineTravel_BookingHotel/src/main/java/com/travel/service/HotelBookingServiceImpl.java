package com.travel.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.entity.HotelBooking;
import com.travel.repository.HotelBookingRepository;

@Service
public class HotelBookingServiceImpl implements HotelBookingService {

	@Autowired
	HotelBookingRepository hotelbookingRepository;

	@Transactional
	@Override
	public HotelBooking insertHotelBookingUser(HotelBooking hotelbooking) throws Exception {

		HotelBooking savedUser = hotelbookingRepository.save(hotelbooking);

		if (savedUser != null) {
			return savedUser;
		} else
			return null;

	}

	@Override
	public List<HotelBooking> getAllHotelBooking() throws Exception {
		List<HotelBooking> allUsers = hotelbookingRepository.findAll();
		return allUsers;
	}

	@Override
	public HotelBooking getHotelByHotelName(String hotelName) throws Exception {
		HotelBooking hotelbooking = hotelbookingRepository.getHotelByHotelName(hotelName);
		System.out.println("Inside getHotelByName Method");

		if (hotelbooking == null) {
			throw new EntityNotFoundException(hotelName + "its Not Available ");
		} else {
			return hotelbooking;
		}

	}

	@Override
	public String delete(int hotelId) {
		hotelbookingRepository.deleteById(hotelId);
		return "Successfully Deleted ";
	}

	/*@Override
	public String delete(int hotelId) {
		HotelBooking hotelBookingId=hotelbookingRepository.getById(null);
		if(hotelBookingId==null)
			throw new EntityNotFoundException(hotelId+ "Not Avilable ");
		hotelbookingRepository.deleteById(hotelId);
		return "Successfully Deleted ";
	}*/

	@Override
	public List<HotelBooking> getHotelByCost(int cost) throws Exception {
		List<HotelBooking> byCost = hotelbookingRepository.getHotelByCost(cost);
		System.out.println("Inside getHotelByCost Method");

		if (byCost == null) {
			throw new EntityNotFoundException(cost + "Please Provide Valid NumBer Not A Characters");
		} else {
			return byCost;
		}
	}

	@Override
	public List<HotelBooking> CostByLowToHigh() throws Exception {
		// 
		List<HotelBooking> listByCost = hotelbookingRepository.findAll();
		Collections.sort(listByCost, new com.travel.sorting.CostByLowToHigh());
		return listByCost;
	}

	@Override
	public List<HotelBooking> CostByHighToLow() throws Exception {
		List<HotelBooking> listByCost = hotelbookingRepository.findAll();
		Collections.sort(listByCost, new com.travel.sorting.CostByHighToLow());
		return listByCost;
	}

	@Override
	public String getHotelById(int hotelId) throws Exception {
		hotelbookingRepository.findAll();
		return "Update Successfull";

	}

	@Override
	public List<HotelBooking> filterByBooking(String userName) throws Exception {
		List<HotelBooking> allFilterByBooking = getAllHotelBooking().stream()
				.filter((userBooking) -> userBooking.getUserName().equals(userName)).collect(Collectors.toList());
		return allFilterByBooking;
	}

}

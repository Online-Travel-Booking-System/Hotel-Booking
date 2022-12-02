package com.travel.entity.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.HotelBooking;
import com.travel.service.HotelBookingService;

@RestController            //designed to take advantage of existing protocols written straight into the response body instead of rendering a template.
@Validated
@RequestMapping("/admin/bookhotel")
public class AdminControllerHotelBooking {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	// for security and surveillance purpose

	@Autowired // inject the dependency using this
	HotelBookingService hotelBookingService;

	public AdminControllerHotelBooking() {
		System.out.println("\n---------------Inside Constructor-------------------- \n" + this);
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Admin !welcome to HotelBooking";
	}

	@PostMapping("/addhotel") // localhost:8011/admin/bookhotel/addhotel(POST)
	public ResponseEntity<String> addUser(@Valid @RequestBody HotelBooking hotelBooking) {
		try {
			log.info("Inside try of AddHotel ");
			HotelBooking savedhotel = hotelBookingService.insertHotelBookingUser(hotelBooking);
			String responseMsg = savedhotel.getHotelName() + "   Added Succesfully";
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Please Provide Valid HotelName And Cost";
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/viewHotel") // localhost:8011/admin/bookhotel/viewHotel(GET)
	public List<HotelBooking> getAllHotel() {
		try {
			log.info("Inside GetHotel ");
			List<HotelBooking> allExtractedHotel = hotelBookingService.getAllHotelBooking();
			return allExtractedHotel;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@GetMapping("/hotelByName/{hotelName}") /// localhost:8011/admin/bookhotel/hotelByName/{given_Hotel_NAme}
	public HotelBooking getByHotelName(@Valid @PathVariable String hotelName) throws Exception {
		return hotelBookingService.getHotelByHotelName(hotelName);
	}

	@GetMapping("/hotelByCost/{cost}") /// admin/bookhotel/hotelByCost/{given_Hotel_Cost}
	public List<HotelBooking> getByCostOfHotel(@Valid @PathVariable int cost) throws Exception {
		return hotelBookingService.getHotelByCost(cost);
	}

	@PutMapping("/update/{hotelId}") // localhost:8011/admin/bookhotel/update/{id}
	public HotelBooking updateHotelBooking(@PathVariable int hotelId, @RequestBody HotelBooking bookingDetails)
			throws Exception {
		hotelBookingService.getHotelById(hotelId);
		bookingDetails.setHotelId(hotelId);

		HotelBooking updateHotelBooking = hotelBookingService.insertHotelBookingUser(bookingDetails);
		return updateHotelBooking;
	}

	@DeleteMapping("/delete/{searchhotelId}") /// localhost:8011/admin/bookhotel/hotelId/ (Delete)
	public String deleteUser(@PathVariable int searchhotelId)throws Exception {
		try {
			hotelBookingService.delete(searchhotelId);
			log.info("Deleted  Successfully in DB");
		} catch (Exception e) {
			System.out.println("Not in a list.Could not be Deleted");
		}
		return "Deleted Successfully!! Hotel Id " +searchhotelId+ "In DB";
	}
	

	@GetMapping("/filterByHotelUserName/{userName}")  // /user/bookhotel/filterByHotelName/{HotelName}
	public List<HotelBooking> filterNames(@PathVariable String userName) throws Exception {
		List<HotelBooking> filteredHotel = hotelBookingService.filterByBooking(userName);
		return filteredHotel;
	}

	/* @PathVariable is used to assing the template Variables to method variables */
}

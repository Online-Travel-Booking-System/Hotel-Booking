package com.travel.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.entity.HotelBooking;
import com.travel.repository.HotelBookingRepository;

@SpringBootTest
class HotelBookingServiceImplTest {
	@Mock
	HotelBookingRepository hotelBookingRepository;

	@InjectMocks
	HotelBookingServiceImpl hotelBookingService;

	@Test
	@DisplayName("Add All HotelBooking")
	void testInsertHotelBookingUser() throws Exception {
		HotelBooking sampleInput = new HotelBooking("Riyaz Hotel", "Meenu", 2, 300, 600, "10/12/22", "12/12/22");
		HotelBooking expectedOutput = new HotelBooking("Riyaz Hotel", "Lachu", 2, 300, 600, "11/12/22", "12/12/22");
		BDDMockito.given(hotelBookingService.insertHotelBookingUser(sampleInput)).willReturn(expectedOutput);

		// when
		HotelBooking actualOutput = hotelBookingService.insertHotelBookingUser(sampleInput);

		// verify
		assertEquals(expectedOutput, actualOutput);

	}

	@Test
	@DisplayName("Get all the users")
	void testGetAllHotelBooking() throws Exception {

		HotelBooking booking1 = new HotelBooking("Riyaz Hotel", "Meenu", 2, 300, 600, "11/12/22", "12/12/22");
		HotelBooking booking2 = new HotelBooking("Riya Hotel", "Lachu", 2, 300, 600, "11/12/22", "12/12/22");
		List<HotelBooking> sampleOutput = new ArrayList<>();
		sampleOutput.add(booking1);
		sampleOutput.add(booking2);
		BDDMockito.given(hotelBookingService.getAllHotelBooking()).willReturn(sampleOutput);
		List<HotelBooking> actualOutput = hotelBookingService.getAllHotelBooking();
		assertNotNull(actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);
	}

	@Test
	@DisplayName("Test:High To Low")
	void testCostByHighToLow() throws Exception {

		HotelBooking booking1 = new HotelBooking("Hiran Hotel", "Lachu", 2, 100, 200, "11/12/22", "13/12/22");
		HotelBooking booking2 = new HotelBooking("Garam Hotel", "Meenu", 2, 200, 600, "4/12/22", "6/12/22");
		List<HotelBooking> sampleOutput = new ArrayList<>();

		sampleOutput.add(booking1);
		sampleOutput.add(booking2);

		BDDMockito.given(hotelBookingService.CostByHighToLow()).willReturn(sampleOutput);

		List<HotelBooking> actualOutput = hotelBookingService.CostByHighToLow();
		assertNotNull(actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);

	}

	@Test
	@DisplayName("Test:Low To High")
	void testCostByLowToHigh() throws Exception {
		HotelBooking booking1 = new HotelBooking("Hiran Hotel", "Meenu", 2, 100, 200, "11/12/22", "13/12/22");
		HotelBooking booking2 = new HotelBooking("Garam Hotel", "Lachu", 2, 200, 600, "4/12/22", "6/12/22");
		List<HotelBooking> sampleOutput = new ArrayList<>();

		sampleOutput.add(booking1);
		sampleOutput.add(booking2);

		BDDMockito.given(hotelBookingService.CostByLowToHigh()).willReturn(sampleOutput);

		List<HotelBooking> actualOutput = hotelBookingService.CostByLowToHigh();
		assertNotNull(actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);
	}

}

package com.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.travel.entity.HotelBooking;

@Repository
public interface HotelBookingRepository extends JpaRepository<HotelBooking, Integer>, IHotelBookingCostumRepository {

}

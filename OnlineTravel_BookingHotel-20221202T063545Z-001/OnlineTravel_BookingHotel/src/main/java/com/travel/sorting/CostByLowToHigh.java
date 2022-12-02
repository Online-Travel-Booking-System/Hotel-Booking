package com.travel.sorting;

import java.util.Comparator;

import com.travel.entity.HotelBooking;

public class CostByLowToHigh implements Comparator<HotelBooking> 
{
    @Override
	public int compare(HotelBooking o1, HotelBooking o2) 
	{
		return o1.getCost() - o2.getCost();
	}

}

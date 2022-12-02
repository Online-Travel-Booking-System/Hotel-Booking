package com.travel.sorting;

import java.util.Comparator;

import com.travel.entity.HotelBooking;

public class CostByHighToLow implements Comparator<HotelBooking> 
{
	 @Override
		public int compare(HotelBooking o1, HotelBooking o2) 
		{
			return o2.getCost() - o1.getCost();
		}


}

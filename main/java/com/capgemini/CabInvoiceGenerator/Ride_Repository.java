package com.capgemini.CabInvoiceGenerator;

import java.util.HashMap;
import java.util.Map;

public class Ride_Repository {
	private Map<Integer, Ride[]> USER_RIDES = new HashMap<Integer, Ride[]>();

	public Ride_Repository(int userId, Ride[] rides) {
		USER_RIDES.put(userId, rides);
	}

	public Ride[] getRides(int userId) {
		return USER_RIDES.get(userId);
	}
}

package com.blz.cabinvoicegenerator.controler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
	Map<Integer, ArrayList<Ride>> userRides;

	public RideRepository() {
		userRides = new HashMap<>();
	}

	public void addRides(int userId, Ride[] rides) {
		this.userRides.put(userId, new ArrayList<Ride>(Arrays.asList(rides)));
	}

	public Ride[] getRides(int userId) {
		return this.userRides.get(userId).toArray(new Ride[5]);
	}
}
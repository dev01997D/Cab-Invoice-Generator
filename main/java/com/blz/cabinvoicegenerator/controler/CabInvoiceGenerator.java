/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.blz.cabinvoicegenerator.controler;

public class CabInvoiceGenerator {
	// CONSTANTS
	private static final double MINIMUM_COST_PER_KM = 10.0;
	private static final int COST_PER_TIME = 1;
	private static final double MIN_FARE = 5.0;

	//STORE THE RIDE DATA IN REPO-HASHMAP
	public RideRepository rideRepo;

	public CabInvoiceGenerator() {
		this.rideRepo = new RideRepository();
	}

	// FUNCTION TO ADD RIDES
	public void addRides(Integer userId, Ride[] rides) {
		rideRepo.addRides(userId, rides);
	}

	// FUNCTION TO CALCULATE TOTAL FARE FOR THE JOURNEY OF SINGLE RIDE
	public double calculateFare(double distance, int time) {
		double total;
		total = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
		return Math.max(total, MIN_FARE);
	}

	// FUNCTION TO CALCULATE TOTAL FARE FOR THE JOURNEY OF MULTIPLE RIDES
	public double getTotalFareMultipleRides(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.getDistance(), ride.getTime());
		}
		totalFare = Math.max(totalFare, MIN_FARE);
		return totalFare;
	}

	// FUNCTION TO GET ENHANCED INVOICE SUMMARY FOR MULTIPLE RIDES
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		totalFare = getTotalFareMultipleRides(rides);
		return new InvoiceSummary(rides.length, totalFare);
	}

	// FUNCTION TO GET INVOICE SUMMARY FOR GIVEN USER ID
	public InvoiceSummary getInvoiceSummary(int userId) {
		Ride[] rideArray = rideRepo.getRides(userId);
		double totalFare = getTotalFareMultipleRides(rideArray);
		return new InvoiceSummary(rideArray.length, totalFare);
	}
}

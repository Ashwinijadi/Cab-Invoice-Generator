package com.capgemini.CabInvoiceGenerator;

public class InvoiceGenerator {
	private static final double MINIMUM_COST_PER_KM = 10.0;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5.0;
	private final Ride_Repository USER_RIDES;

	public InvoiceGenerator() {
		this.USER_RIDES = null;
	}

	public InvoiceGenerator(int userId, Ride[] rides) {
		USER_RIDES = new Ride_Repository(userId, rides);
	}

	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
		return Math.max(totalFare, MINIMUM_FARE);
	}

	public InvoiceSummary calculateFare(int userId) {
		Ride[] rides = USER_RIDES.getRides(userId);
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}
}

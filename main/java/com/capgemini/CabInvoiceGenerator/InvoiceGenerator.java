package com.capgemini.CabInvoiceGenerator;

public class InvoiceGenerator {
	private static final double MINIMUM_COST_PER_KM_NORMAL = 10.0;
	private static final int COST_PER_TIME_PREMIUM = 2;
	private static final int COST_PER_TIME_NORMAL = 1;
	private static final double MINIMUM_COST_PER_KM_PREMIUM = 15.0;
	private static final double MINIMUM_FARE_NORMAL = 5.0;
	private static final double MINIMUM_FARE_PREMIUM = 20;
	private final Ride_Repository USER_RIDES;

	public InvoiceGenerator() {
		this.USER_RIDES = null;
	}

	public InvoiceGenerator(int userId, Ride[] rides) {
		USER_RIDES = new Ride_Repository(userId, rides);
	}

	public double calculateFare(double distance, int time, String typeOfRide) {
		if (typeOfRide == "Normal Ride") {
			double totalFare = distance * MINIMUM_COST_PER_KM_NORMAL + time * COST_PER_TIME_NORMAL;
			return Math.max(totalFare, MINIMUM_FARE_NORMAL);
		}
		if (typeOfRide == "Premium Ride") {
			double totalFare = distance * MINIMUM_COST_PER_KM_PREMIUM + time * COST_PER_TIME_PREMIUM;
			return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
		} else
			return 0;
	}
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time, ride.typeOfRide);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}
	public InvoiceSummary calculateFare(int userId) {
		Ride[] rides = USER_RIDES.getRides(userId);
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time, ride.typeOfRide);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

}

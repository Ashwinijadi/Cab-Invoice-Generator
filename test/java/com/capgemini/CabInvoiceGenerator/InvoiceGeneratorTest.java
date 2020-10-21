package com.capgemini.CabInvoiceGenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
	@Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 5;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(55, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRidesShouldReturnInvoiceSummary() {
		int userId = 10;
		Ride[] rides = { new Ride(3.0, 5), new Ride(0.1, 1),new Ride(2.0,5) };
		InvoiceGenerator generator = new InvoiceGenerator(userId, rides);
		InvoiceSummary actualInvoiceSummary = generator.calculateFare(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 65.0);
		Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}
}

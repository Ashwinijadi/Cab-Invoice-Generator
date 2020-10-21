package com.capgemini.CabInvoiceGenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
	@Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 5;
		int time = 5;
		String type = "Normal Ride";
		double fare = invoiceGenerator.calculateFare(distance, time, type);
		Assert.assertEquals(55, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		String type = "Normal Ride";
		double fare = invoiceGenerator.calculateFare(distance, time, type);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenUserIdShouldReturnInvoiceSummary() {
		int userId = 123;
		Ride[] rides = { new Ride(2.0, 5, "Normal Ride"), new Ride(0.1, 1, "Normal Ride") };
		InvoiceGenerator cabInvoiceGenerator = new InvoiceGenerator(userId, rides);
		InvoiceSummary actualInvoiceSummary = cabInvoiceGenerator.calculateFare(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}

	
	@Test
	public void givenMultipleRidesShouldReturnInvoiceServiceSummary() {
		int userId = 10;
		Ride[] rides = { new Ride(3.0, 5,"Normal Ride"), new Ride(0.1, 1,"Normal Ride"), new Ride(2.0, 5,"Normal Ride") };
		InvoiceGenerator generator = new InvoiceGenerator(userId, rides);
		InvoiceSummary actualInvoiceSummary = generator.calculateFare(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 65.0);
		Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}
	@Test
	public void givenMultiple_RidesShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5, "Normal Ride"), new Ride(0.1, 1, "Normal Ride") };
		InvoiceGenerator generator = new InvoiceGenerator();
		InvoiceSummary invoiceSummary = generator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
	
	@Test
	public void givenDistance_AndTimeShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 5;
		int time = 5;
		String type = "Premium Ride";
		double fare = invoiceGenerator.calculateFare(distance, time, type);
		Assert.assertEquals(85, fare, 0.0);
	}

	@Test
	public void givenLess_DistanceAndTimeShouldReturnMinimumFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 1;
		String type = "Premium Ride";
		double fare = invoiceGenerator.calculateFare(distance, time, type);
		Assert.assertEquals(32, fare, 0.0);
	}

	@Test
	public void givenUser_IdShouldReturnInvoiceSummary() {
		int userId = 123;
		Ride[] rides = { new Ride(2.0, 5, "Normal Ride"), new Ride(2.0, 1, "Premium Ride") };
		InvoiceGenerator cabInvoiceGenerator = new InvoiceGenerator(userId, rides);
		InvoiceSummary actualInvoiceSummary = cabInvoiceGenerator.calculateFare(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 57);
		Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}

	@Test
	public void givenMultipleRidesShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5, "Premium Ride"), new Ride(1.0, 1, "Normal Ride") };
		InvoiceGenerator generator = new InvoiceGenerator();
		InvoiceSummary invoiceSummary = generator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 51);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
}

package com.capgemini.CabInvoiceGenerator;

public class InvoiceSummary {
	public int noOfRides;
	public double totalFare;
	public double averageFare;

	public InvoiceSummary(int noOfRides, double totalFare) {
		this.noOfRides = noOfRides;
		this.totalFare = totalFare;
		this.averageFare = (this.totalFare) / (this.noOfRides);
	}

	@Override
	public boolean equals(Object Ob) {
		if (this == Ob)
			return true;
		if (Ob == null || getClass() != Ob.getClass())
			return false;
		InvoiceSummary rides = (InvoiceSummary) Ob;
		return noOfRides == rides.noOfRides && Double.compare(rides.totalFare, totalFare) == 0
				&& Double.compare(rides.averageFare, averageFare) == 0;
	}
}

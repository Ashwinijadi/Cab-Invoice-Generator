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
		InvoiceSummary r = (InvoiceSummary) Ob;
		return noOfRides == r.noOfRides && Double.compare(r.totalFare, totalFare) == 0
				&& Double.compare(r.averageFare, averageFare) == 0;
	}
}

package com.bz.cabInvoiceGenerator.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bz.cabInvoiceGenerator.model.CabInvoiceGeneratorPojo;
import com.bz.cabInvoiceGenerator.services.ImpCabInvoiceGenerator;

public class TestCabInvoiceGeneratot {

	/*
	 *Here im taking costPerKM = Rs 20.5 per KM,costPerMinute = Rs 2.5 per min and minimumFare = Rs 10.5
	 * */
	@Test
	public void calculateFareTest() {
		Object result = ImpCabInvoiceGenerator.calculateFare(20,2,10);
		assertEquals(11.0, result);
	}
	
	@Test
	public void aggregateTotalTest() {
		CabInvoiceGeneratorPojo obj = new CabInvoiceGeneratorPojo();
		obj.setTotalDistance(10);
		obj.setTotalTimeTaken(20);
		obj.setCostPerKM(2);
		obj.setCostPerMinute(2);
		obj.setTotalDistanceCost(20);
		obj.setTotalTimeCost(40);
		obj.setMinimumFare(10);
		obj.setBaseFare(15);
		obj.setSurgeFare(150);
		obj.setTollTax(10);
		obj.setTax(obj.getBaseFare() * 2);
		obj.setRideEarning(obj.getBaseFare() +obj.getTotalDistanceCost() +obj.getTotalTimeCost() +obj.getSurgeFare() +obj.getTax() +obj.getTollTax());
		int numberOfRides = 2;
		assertEquals(530.0, ImpCabInvoiceGenerator.aggregateTotal(obj, numberOfRides));
	}
	
	@Test
	public void invoiceGenerator() {
		CabInvoiceGeneratorPojo caPojo = new CabInvoiceGeneratorPojo();
		caPojo.setRiderId(0);
		caPojo.setTotalDistance(10);
		caPojo.setTotalTimeTaken(20);
		caPojo.setCostPerKM(2);
		caPojo.setCostPerMinute(2);
		caPojo.setTotalDistanceCost(20);
		caPojo.setTotalTimeCost(40);
		caPojo.setMinimumFare(10);
		caPojo.setBaseFare(15);
		caPojo.setSurgeFare(150);
		caPojo.setTollTax(10);
		caPojo.setTax(caPojo.getBaseFare() * 2);
		caPojo.setRideEarning(caPojo.getBaseFare() +caPojo.getTotalDistanceCost() +caPojo.getTotalTimeCost() +caPojo.getSurgeFare() +caPojo.getTax() +caPojo.getTollTax());
		int numberOfRides = 2;
		
		assertTrue(ImpCabInvoiceGenerator.invoiceGenerator(caPojo));
	}
	
	@Test
	public void cabCategories() {
		assertTrue(ImpCabInvoiceGenerator.cabCategories((byte) 1));
	}
	
	@Test
	public void searchByIDTest() {
		CabInvoiceGeneratorPojo caPojo = new CabInvoiceGeneratorPojo();
		caPojo.setRiderId(0);
		caPojo.setTotalDistance(10);
		caPojo.setTotalTimeTaken(20);
		caPojo.setCostPerKM(2);
		caPojo.setCostPerMinute(2);
		caPojo.setTotalDistanceCost(20);
		caPojo.setTotalTimeCost(40);
		caPojo.setMinimumFare(10);
		caPojo.setBaseFare(15);
		caPojo.setSurgeFare(150);
		caPojo.setTollTax(10);
		caPojo.setTax(caPojo.getBaseFare() * 2);
		caPojo.setRideEarning(caPojo.getBaseFare() +caPojo.getTotalDistanceCost() +caPojo.getTotalTimeCost() +caPojo.getSurgeFare() +caPojo.getTax() +caPojo.getTollTax());
		int numberOfRides = 2;
		assertFalse(ImpCabInvoiceGenerator.searchByID(0));
	}

}

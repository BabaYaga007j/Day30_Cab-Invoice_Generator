package com.bz.cabInvoiceGenerator.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.bz.cabInvoiceGenerator.model.CabInvoiceGeneratorPojo;

public class ImpCabInvoiceGenerator {
	
	static int index  = 1;
	static int numberOfRides = (int) (Math.random()*10);
	static String[] cabServicesVehicle = {"OLA_XL","OLA_WAV","OLA_SUV","OLA_Pool","OLA_X"};
	private static ArrayList<CabInvoiceGeneratorPojo> ridersArrayList = new ArrayList<CabInvoiceGeneratorPojo>();
	private static Scanner option = new Scanner(System.in);
	
	
	public static double calculateFare(double kmCost, double timeCost, int minimumFare) {
		double baseFare = kmCost + timeCost;
		if(baseFare < minimumFare) {
			baseFare = minimumFare;
		}
		return baseFare;
	}

	public static Object aggregateTotal(CabInvoiceGeneratorPojo rider, int numberOfRides) {		
		double reserveFare = 0;
		for(int i = 1; i <=numberOfRides ;i++) {
			reserveFare = reserveFare + ride(rider);
		}
		return reserveFare;
	}

	public static boolean searchByID(int riderId) {
		List<CabInvoiceGeneratorPojo> list = ridersArrayList.stream().filter(data->riderId == data.getRiderId()).collect(Collectors.toList());
		if(list.isEmpty()) {
			return false;
		}else {
			for(CabInvoiceGeneratorPojo pojo : list) {
				invoiceGenerator(pojo);
			}
			return true;
		}
	}
	
	private static double ride(CabInvoiceGeneratorPojo rider) {
		ridersArrayList.add(rider);
		rider.setRiderId(ridersArrayList.indexOf(rider));
		System.err.println(" Ride No. :: " + index++);
		System.out.println(" User ID  :: " + "@OLA_RIDES0"+ridersArrayList.indexOf(rider));
		invoiceGenerator(rider);
		return rider.getRideEarning();
	}
	
	private static CabInvoiceGeneratorPojo getRiderdetails() {
		CabInvoiceGeneratorPojo caPojo = new CabInvoiceGeneratorPojo();
		caPojo.setTotalDistance((int)(Math.random()*100)+1);
		caPojo.setTotalTimeTaken((int)(Math.random()*100) + 10);
		caPojo.setCostPerKM(Math.random()*10);
		caPojo.setCostPerMinute(Math.random()*10);
		caPojo.setTotalDistanceCost(caPojo.getCostPerKM()*caPojo.getTotalDistance());
		caPojo.setTotalTimeCost(caPojo.getCostPerMinute()*caPojo.getTotalTimeTaken());
		caPojo.setMinimumFare((int) ((Math.random()*10)%5));
		caPojo.setBaseFare(calculateFare(caPojo.getTotalDistanceCost(), caPojo.getTotalTimeCost(), caPojo.getMinimumFare()));
		caPojo.setSurgeFare(caPojo.getBaseFare()*(int) ((Math.random()*10)%4));
		caPojo.setTollTax(Math.random()%20);
		caPojo.setTax(caPojo.getBaseFare() * (Math.random()%2));
		caPojo.setRideEarning(caPojo.getBaseFare() +caPojo.getTotalDistanceCost() +caPojo.getTotalTimeCost() +caPojo.getSurgeFare() +caPojo.getTax() +caPojo.getTollTax());
		
		return caPojo;
	}
	
	public static boolean invoiceGenerator(CabInvoiceGeneratorPojo rider) {
		if(null != rider) {
		
		System.out.println("Duration :: "+rider.getTotalTimeTaken()+"Minujtes"+'\n'+ "Distance :: "+ rider.getTotalDistance()+" km");
		System.out.println("<<<<<<<<<<<>>>>>>>>>>");
		System.out.println("Vehicle Type :: " + cabServicesVehicle[(int)(Math.random()*10)%5]);
		System.out.println("Time Requested :: " + java.time.LocalTime.now());
		System.out.println("Date :: " + java.time.LocalDate.now());
		System.out.println("<<<<<<<<<<<>>>>>>>>>>");
		System.out.println("Minimum Fare :: " +"Rs "+rider.getMinimumFare());
		System.out.println("Distance("+rider.getTotalDistance()+"km*Rs"+rider.getCostPerKM()+"/km) "+"Rs "+rider.getTotalDistanceCost());
		System.out.println("Time("+rider.getTotalTimeTaken()+"min*Rs"+rider.getCostPerMinute()+"/min) " +"Rs "+ rider.getTotalTimeCost());
		System.out.println("Toll tax :: " +"Rs "+  rider.getTollTax());
		System.out.println("Surge Fare :: " +"Rs "+ rider.getSurgeFare());
		System.out.println("Tax :: " +"Rs "+  rider.getTax());
		System.out.println("<<<<<<<<<<<>>>>>>>>>>");
		System.out.println("Your Earnings :: " +"Rs "+ rider.getRideEarning());
		System.out.println("<<<<<<<<<<<>>>>>>>>>>");
		System.out.println("? Help " + " > ");
		System.out.println("# Fare Details " + " > ");
		
		return true;
		}else {
			return false;
		}
	}
	
	private static void riderOptions() {
		do {
			System.out.println(" Press 1 : Single User-Multiple Rides invoice" +'\n'+
					" Press 2 : Multiple User multiple ride invoices" +'\n'+
					" Press 3 : search by UserId");
			System.out.println("Enter option ::");
			switch (option.nextByte()) {
			case 1:
				System.out.println(" Ride Fare ::" + aggregateTotal( getRiderdetails(),numberOfRides));
				break;
			case 2:
				int multipleRiders = (int)(Math.random()*10)%5;
				for(int i = 0; i < multipleRiders;i++) {
				numberOfRides = 1;
				System.out.println(" Ride Fare ::" + aggregateTotal( getRiderdetails(),numberOfRides)+'\n');
				}
				break;
			case 3:
				System.out.println("Enter Id Number ::");
				int string  = option.nextInt();
				searchByID(string);
				break;
			}
			System.out.println(" Press 0 : To Re-Visit ");
			}while(option.nextByte() == 0);
	}
	
	public static boolean cabCategories(byte option) {
		CabInvoiceGeneratorPojo pojo;
		boolean temp;
		
		switch (option) {
		case 1:

			riderOptions();
			temp = true;
			break;
			
		case 2:

			riderOptions();
			temp = true;
			break;
		default:
		temp = false;
		}
		return temp;
	}
	public static void main(String[] args) {
		System.out.println(" Press 1 : Normal_Ride "+'\n'
				+" Press 2: Premium Ride"+'\n'
								+" Enter Option :: ");
		cabCategories(option.nextByte());
	}
	
}



package com.bz.cabInvoiceGenerator.model;

public class CabInvoiceGeneratorPojo {
	
	private int riderId;
	private double totalDistanceCost;
	private double totalTimeCost;
	private int minimumFare;
	private double costPerKM;
	private double costPerMinute;
	private int totalDistance;
	private int totalTimeTaken;
	private double baseFare;
	private double tollTax;
	private double tax;
	private double surgeFare;
	private double rideEarning;
	
	
	public int getRiderId() {
		return riderId;
	}
	public void setRiderId(int riderId) {
		this.riderId = riderId;
	}
	public double getTotalDistanceCost() {
		return totalDistanceCost;
	}
	public void setTotalDistanceCost(double totalDistanceCost) {
		this.totalDistanceCost = totalDistanceCost;
	}
	public double getTotalTimeCost() {
		return totalTimeCost;
	}
	public void setTotalTimeCost(double totalTimeCost) {
		this.totalTimeCost = totalTimeCost;
	}
	public int getMinimumFare() {
		return minimumFare;
	}
	public void setMinimumFare(int minimumFare) {
		this.minimumFare = minimumFare;
	}
	public double getCostPerKM() {
		return costPerKM;
	}
	public void setCostPerKM(double costPerKM) {
		this.costPerKM = costPerKM;
	}
	public double getCostPerMinute() {
		return costPerMinute;
	}
	public void setCostPerMinute(double costPerMinute) {
		this.costPerMinute = costPerMinute;
	}
	public int getTotalDistance() {
		return totalDistance;
	}
	public void setTotalDistance(int totalDistance) {
		this.totalDistance = totalDistance;
	}
	public int getTotalTimeTaken() {
		return totalTimeTaken;
	}
	public void setTotalTimeTaken(int totalTimeTaken) {
		this.totalTimeTaken = totalTimeTaken;
	}
	public double getBaseFare() {
		return baseFare;
	}
	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}
	public double getTollTax() {
		return tollTax;
	}
	public void setTollTax(double tollTax) {
		this.tollTax = tollTax;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getSurgeFare() {
		return surgeFare;
	}
	public void setSurgeFare(double surgeFare) {
		this.surgeFare = surgeFare;
	}
	public double getRideEarning() {
		return rideEarning;
	}
	public void setRideEarning(double rideEarning) {
		this.rideEarning = rideEarning;
	}
	public String toString() {
		return "CabInvoiceGeneratorPojo [riderId=" + riderId + ", totalDistanceCost=" + totalDistanceCost
				+ ", totalTimeCost=" + totalTimeCost + ", minimumFare=" + minimumFare + ", costPerKM=" + costPerKM
				+ ", costPerMinute=" + costPerMinute + ", totalDistance=" + totalDistance + ", totalTimeTaken="
				+ totalTimeTaken + ", baseFare=" + baseFare + ", tollTax=" + tollTax + ", tax=" + tax + ", surgeFare="
				+ surgeFare + ", rideEarning=" + rideEarning + "]";
	}
	
	

}

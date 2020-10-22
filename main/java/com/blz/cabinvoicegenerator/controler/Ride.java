package com.blz.cabinvoicegenerator.controler;

public class Ride {
	public enum RideType {
		NORMAL_RIDE, PREMIUM_RIDE;
	}

	private double distance;
	private int time;
	public RideType rideType;

	public Ride(double distance, int time, RideType rideType) {
		this.distance = distance;
		this.time = time;
		this.rideType=rideType;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Ride [distance=" + distance + ", time=" + time + "]";
	}
}

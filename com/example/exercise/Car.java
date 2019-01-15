package com.example.exercise;

public class Car {

	int vin;
	String model;
	String make;
	double price;
	
	public Car() {
	}
	
	public Car(String model, String make, double price) {
		this.model = model;
		this.make = make;
		this.price = price;
	}
	
	

	public Car(int vin, String model, String make, double price) {
		this.vin = vin;
		this.model = model;
		this.make = make;
		this.price = price;
	}

	public int getVin() {
		return vin;
	}

	public void setVin(int vin) {
		this.vin = vin;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

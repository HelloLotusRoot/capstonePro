package com.example.demo.model;

public class Shuttle_station {
	private String name;
	private Double x; // latitude
	private Double y; // longitude
	
	public Shuttle_station(String name, Double x, Double y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return this.name;
	}
	
	public Double getX() {
		return this.x;
	}
	
	public Double getY() {
		return this.y;
	}

}

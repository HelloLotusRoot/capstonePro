package com.example.demo.model;

public class Shuttle {

	private String busid;
	private Double lat;
	private Double lng;
	
	public Shuttle(String busid, Double lat, Double lng) {
		super();
		this.busid = busid;
		this.lat = lat;
		this.lng = lng;
	}

	public String getBusid() {
		return busid;
	}

	public void setBusid(String busid) {
		this.busid = busid;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}
	
}

package com.example.demo.model;

public class Shuttle {

	private String busid;
	private String latitude;
	private String longitude;
	
	public Shuttle(String busid, String latitude, String longitude) {
		super();
		this.busid = busid;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getBusid() {
		return busid;
	}

	public void setBusid(String busid) {
		this.busid = busid;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
		
}

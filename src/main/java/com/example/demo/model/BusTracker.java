package com.example.demo.model;

public class BusTracker {
	private String busid;
	private String carnumber;
	private String latitude;
	private String longitude;
	
	
	public BusTracker(String busid, String carnumber, String latitude, String longitude) {
		super();
		this.busid = busid;
		this.carnumber = carnumber;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public String getBusid() {
		return busid;
	}


	public void setBusid(String busid) {
		this.busid = busid;
	}


	public String getCarnumber() {
		return carnumber;	
	}


	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
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

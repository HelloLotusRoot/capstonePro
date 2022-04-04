package com.example.demo.model;

public class Shuttle {

	private int idshuttle;
	private String bussstop_name;
	private String coordinate;
	
	public Shuttle(int idshuttle, String bussstop_name, String coordinate) {
		super();
		this.idshuttle = idshuttle;
		this.bussstop_name = bussstop_name;
		this.coordinate = coordinate;
	}
	
	public int getIdshuttle() {
		return idshuttle;
	}
	public void setIdshuttle(int idshuttle) {
		this.idshuttle = idshuttle;
	}
	public String getBussstop_name() {
		return bussstop_name;
	}
	public void setBussstop_name(String bussstop_name) {
		this.bussstop_name = bussstop_name;
	}
	public String getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}
	
}

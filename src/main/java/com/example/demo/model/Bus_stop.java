package com.example.demo.model;

public class Bus_stop {

	private int shuttle_id;
	private String bussstop_id;
	
	public Bus_stop(int shuttle_id, String bussstop_id) {
		super();
		this.shuttle_id = shuttle_id;
		this.bussstop_id = bussstop_id;
	}

	public int getShuttle_id() {
		return shuttle_id;
	}

	public void setShuttle_id(int shuttle_id) {
		this.shuttle_id = shuttle_id;
	}

	public String getBussstop_id() {
		return bussstop_id;
	}

	public void setBussstop_id(String bussstop_id) {
		this.bussstop_id = bussstop_id;
	}
	
}

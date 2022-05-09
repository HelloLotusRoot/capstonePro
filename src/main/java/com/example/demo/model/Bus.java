package com.example.demo.model;

public class Bus {

	private String busstop_id;
	private String busstop_name;
	private int bus_num;
	
	public Bus(String busstop_id, String busstop_name, int bus_num) {
		super();
		this.busstop_id = busstop_id;
		this.busstop_name = busstop_name;
		this.bus_num = bus_num;
	}


	public String getBusstop_id() {
		return busstop_id;
	}


	public void setBusstop_id(String busstop_id) {
		this.busstop_id = busstop_id;
	}


	public String getBusstop_name() {
		return busstop_name;
	}


	public void setBusstop_name(String busstop_name) {
		this.busstop_name = busstop_name;
	}


	public int getBus_num() {
		return bus_num;
	}


	public void setBus_num(int bus_num) {
		this.bus_num = bus_num;
	}
	
}

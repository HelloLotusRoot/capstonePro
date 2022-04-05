package com.example.demo.model;

public class Marker_user {

	private String userid;
	private String img_url;
	private Float lat;
	private Float lng;
	private String user_id;
	
	public Marker_user(String userid, String img_url, Float lat, Float lng, String user_id) {
		super();
		this.userid = userid;
		this.img_url = img_url;
		this.lat = lat;
		this.lng = lng;
		this.user_id = user_id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLng() {
		return lng;
	}

	public void setLng(Float lng) {
		this.lng = lng;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}

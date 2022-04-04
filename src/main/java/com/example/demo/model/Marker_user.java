package com.example.demo.model;

public class Marker_user {

	private String userid;
	private String img_url;
	
	public Marker_user(String userid, String img_url) {
		super();
		this.userid = userid;
		this.img_url = img_url;
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
		
}

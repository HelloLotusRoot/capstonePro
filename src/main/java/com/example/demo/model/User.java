package com.example.demo.model;

import java.sql.Date;

public class User {

	private String id;
	private String nickname;
	private Date access_date;
	private int state;
	
	public User(String id, String nickname, Date access_date, int state) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.access_date = access_date;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getAccess_date() {
		return access_date;
	}

	public void setAccess_date(Date access_date) {
		this.access_date = access_date;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}

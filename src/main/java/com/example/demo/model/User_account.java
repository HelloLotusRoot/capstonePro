package com.example.demo.model;

import java.sql.Date;

public class User_account {
	
	private int id_num;
	private String user_id; //아이디
	private String name; //이름
	private String password; //비밀번호
	private String phone; //휴대폰
	private String nickname; //닉네임
	private String profile_img; //프로필 이미지
	private String mail; //메일
	private String bank; //은행
	private String account_num; //계좌번호
	private Date entry_date; //가입날짜
	
	public User_account() {
		
	}
	
	public User_account(int id_num, String user_id, String name, String password, String phone, String nickname, String profile_img,
			String mail, String bank, String account_num, Date entry_date) {
		super();
		this.id_num = id_num;
		this.user_id = user_id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.nickname = nickname;
		this.profile_img = profile_img;
		this.mail = mail;
		this.bank = bank;
		this.account_num = account_num;
		this.entry_date = entry_date;
	}
	
	public int getId_num() {
		return id_num;
	}
	public void setId_num(int id_num) {
		this.id_num = id_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public Date getEntry_date() {
		return entry_date;
	}
	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}
	
}

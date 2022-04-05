package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.User_account;

@Mapper
public interface User_accountMapper {

	@Select("SELECT * FROM user_account WHERE user_id=#{user_id}")
	User_account getUser_account(@Param("user_id") String user_id);
	
	@Select("SELECT * FROM user_account")
	List<User_account> getUser_accountList();
	
	@Insert("INSERT INTO user_account(id_num , user_id, name, password, phone, nickname, profile_img, mail, bank, account_num, entry_date) VALUES(#{user_account.id_num}, #{user_account.user_id}, #{user_account.name}, #{user_account.password}, #{user_account.phone}, #{user_account.nickname}, #{user_account.profile_img}, #{user_account.mail}, #{user_account.bank}, #{user_account.account_num}, #{user_account.entry_date})")
	int insertUser_account(@Param("user_account") User_account user_insert);

//	@Update("UPDATE user_account SET name=#{user_account.name}, password=#{user_account.password}, phone=#{user_account.phone}, nickname=#{user_account.nickname}, profile_img=#{user_account.profile_img}, mail=#{user_account.mail}, bank=#{user_account.bank}, account_num=#{user_account.account_num}, entry_date=#{user_account.entry_date} WHERE user_id=#{user_account.user_id}")
//	int updateUser_account(@Param("user_account") User_account user_update);

	@Delete("DELETE FROM user_account WHERE user_id=#{user_id}")
	int deleteUser_account(@Param("user_id") String user_id);
	
	@Update("UPDATE user_account SET name=#{user_account.name} WHERE user_id=#{user_account.user_id}")
	int updateUser_account(@Param("user_account") User_account user_update);
	
}

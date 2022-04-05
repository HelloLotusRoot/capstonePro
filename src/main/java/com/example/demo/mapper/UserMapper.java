package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.User;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM user WHERE id=#{id}")
	User getUser(@Param("id") String id);
	
	@Select("SELECT * FROM user")
	List<User> getUserList();
	
	@Insert("INSERT INTO user(id, name, access_date, state)")
	int insertUser(@Param("user") User user);
	
	@Update("UPDATE user SET name=#{user.name}, access_date=#{user.access_date}, state=#{user.state} WHERE id=#{user.id}")
	int updateUser(@Param("user") User userUpdate);
	
	@Delete("DELETE FROM user WHERE id=#{id}")
	int deleteUser(@Param("id") String id);
}

package com.example.demo.mapper;

import java.sql.Date;
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
	
	@Insert("INSERT INTO User VALUES(#{id}, #{name}, #{access_date}, #{state})")
	int insertUser(@Param("id") String id, @Param("name") String name, @Param("access_date") Date access_date, @Param("state") int state);
	
	@Update("UPDATE user SET name=#{name}, access_date=#{access_date}, state=#{state} WHERE id=#{id}")
	int updateUser(@Param("id") String id, @Param("name") String name, @Param("access_date") Date access_date, @Param("state") int state);
	
	@Delete("DELETE FROM user WHERE id=#{id}")
	int deleteUser(@Param("id") String id);
}

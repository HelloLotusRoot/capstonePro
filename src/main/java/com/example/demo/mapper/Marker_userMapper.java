package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.Marker_user;

@Mapper
public interface Marker_userMapper {

	@Select("SELECT * FROM marker_user")
	List<Marker_user> getMarker_userList();
	
	@Insert("INSERT INTO marker_user(userid, img_url, lat, lng, user_id)")
	int insertMarker_user(@Param("marker_user") Marker_user marker_userInsert);
	
	@Update("UPDATE marker_user SET img_url=#{marker_user.img_url}, lat=#{marker_user.lat}, lng=#{marker_user.lng} WHERE user_id==#{marker_user.user_id}")
	int updateMarker_user(@Param("marker_user") Marker_user marker_userUpdate);
	
	@Delete("DELETE FROM marker_user WHERE user_id=#{user_id}")
	int deleteMarker_user(@Param("user_id") String user_id);
	
}

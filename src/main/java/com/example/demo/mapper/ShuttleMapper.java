package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Shuttle;

@Mapper
public interface ShuttleMapper {

	@Select("SELECT * FROM shuttle WHERE idshuttle=#{idshuttle}")
	Shuttle getUser_account(@Param("idshuttle") String idshuttle);
	
	@Select("SELECT * FROM shuttle")
	List<Shuttle> getShuttleList();

}

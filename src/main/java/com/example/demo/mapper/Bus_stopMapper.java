package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Bus_stop;

@Mapper
public interface Bus_stopMapper {

	@Select("SELECT * FROM bus_stop WHERE shuttle_id=#{shuttle_id}")
	Bus_stop getBus_stop(@Param("shuttle_id") String shuttle_id);
	
	@Select("SELECT * FROM bus_stop")
	List<Bus_stop> getBus_stopList();
}

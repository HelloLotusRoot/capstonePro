package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Bus_stop;

@Mapper
public interface Bus_stopMapper {

	@Select("SELECT * FROM bus_stop")
	List<Bus_stop> getBus_stopList();
}

package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Bus;

@Mapper
public interface BusMapper {

	@Select("SELECT * FROM bus")
	List<Bus> getBusList();
}

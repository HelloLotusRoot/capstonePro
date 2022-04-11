package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.Bus_stopMapper;
import com.example.demo.model.Bus_stop;

@RestController
public class Bus_stopController {

private Bus_stopMapper mapper;
	
	public Bus_stopController(Bus_stopMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping(value = "/markers/bus_stop")
	public List<Bus_stop> getBus_stopList() {
		return mapper.getBus_stopList();
	}
}

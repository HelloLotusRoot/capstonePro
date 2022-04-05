package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.BusMapper;
import com.example.demo.model.Bus;

@RestController
public class BusController {

	private BusMapper mapper;
	
	public BusController(BusMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping(value = "/markers/bus")
	public List<Bus> getBusList() {
		return mapper.getBusList();
	}
}

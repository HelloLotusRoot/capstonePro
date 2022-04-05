package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.ShuttleMapper;
import com.example.demo.model.Shuttle;

@RestController
public class ShuttleController {

	private ShuttleMapper mapper;
	
	public ShuttleController(ShuttleMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping(value = "/markers/shuttlebus")
	public List<Shuttle> getShuttle() {
		return mapper.getShuttleList();
	}
}

package com.example.demo.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.example.demo.mapper.ShuttleMapper;
import com.example.demo.model.Shuttle;
import com.example.demo.model.Shuttle_station;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@RestController
public class ShuttleController {

	private ShuttleMapper mapper;
	
	// 5초 단위로 업데이트 될 셔틀버스의 현위치
	private String shuttleLocation = "129.07719215990883,35.26914021080837";
	
	
	public ShuttleController(ShuttleMapper mapper){
		this.mapper = mapper;
	}
	
	@GetMapping(value = "/markers/shuttlebus")
	public List<Shuttle> getShuttle() {
		return mapper.getShuttleList();
	}
	
	@GetMapping(value = "/schedule/shuttlebus")
	public JsonNode getShuttleSchedule() throws IOException {
		WebClient client = WebClient.builder()
				.baseUrl("https://apis-navi.kakaomobility.com")
				.build();
	
	Shuttle_station origin = new Shuttle_station("학교", 129.07719215990883, 35.26914021080837);
	Shuttle_station destination = new Shuttle_station("건학관", 129.080358588741, 35.26753755709011);
	Shuttle_station[] waypoints = new Shuttle_station[8];
	waypoints[0] = new Shuttle_station("건학관", 129.080358588741, 35.26753755709011);
	waypoints[1] = new Shuttle_station("외성생활관", 129.08528905299215, 35.269841186287096);
	waypoints[2] = new Shuttle_station("범어사역 이디야", 129.08512374355013, 35.27528693680311);	
	waypoints[3] = new Shuttle_station("범어사역 어귀삼거리", 129.09246745017668, 35.275624177002896);
	waypoints[4] = new Shuttle_station("범어사역", 129.09251, 35.272884);
	waypoints[5] = new Shuttle_station("남산역", 129.0922891953689, 35.26527765324612);
	waypoints[6] = new Shuttle_station("남산소방서", 129.0871546707029, 35.26107692825543);
	waypoints[7] = new Shuttle_station("건학관", 129.080358588741, 35.26753755709011);
	
	try {
			ObjectMapper objectMapper = new ObjectMapper();
			String originAsString = objectMapper.writeValueAsString(origin);
			String destinationAsString = objectMapper.writeValueAsString(destination);
			String waypointsAsString = objectMapper.writeValueAsString(waypoints);
			
			String body = "{\"origin\": " + originAsString + ", \"destination\": " + destinationAsString + ", \"waypoints\": " + waypointsAsString + "}";			
			JsonNode response = client.post()
					.uri("v1/waypoints/directions")
					.contentType(MediaType.APPLICATION_JSON)
					.header("Authorization", "KakaoAK c9762f0c354a8d98ee588edb89b18572")
					.body(BodyInserters.fromValue(body))
					.retrieve()
					.bodyToMono(JsonNode.class)
				    .block();
			
			System.out.print(response);
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			String jsonString = response.toString(); // jsonNode -> json string
			String prettyJsonString = response.toPrettyString(); // 들여쓰기 등 적용
			
			String filepath = "C:\\Users\\82103\\eclipse-workspace\\capstone\\src\\main\\java\\com\\example\\demo\\shuttle\\lecture.json";
			
			FileWriter fw = new FileWriter(filepath, false);
			
			fw.write(prettyJsonString);
			fw.close();
			return response;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null ;
	}
	
//  TEST
//	public JsonNode getShuttleSchedule() {
//		WebClient client = WebClient.builder()
//				.baseUrl("")
//				.build();
//		
//		return client.get()
//				.uri("https://jsonplaceholder.typicode.com/todos/1")
//				.retrieve()
//				.bodyToMono(JsonNode.class)
//			      .block();
//	}
}

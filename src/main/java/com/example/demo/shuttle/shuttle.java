package com.example.demo.shuttle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.yaml.snakeyaml.parser.ParserException;

import com.google.gson.Gson;
/*
public class shuttle {
	public static void main(String[] args) throws FileNotFoundException {
		Reader reader = new FileReader("C:\\Users\\82103\\eclipse-workspace\\capstone\\src\\main\\java\\com\\example\\demo\\shuttle\\lecture.json");

		try {
			JSONParser parse = new JSONParser();
			JSONObject obj = (JSONObject) parse.parse(reader);
//			System.out.println(obj);
			JSONArray arr = (JSONArray) obj.get("routes");
//			System.out.println(arr);
		
			JSONObject rotesObj = (JSONObject) arr.get(0);
//			System.out.println(sectionsObj);
			JSONArray sectionsArr = (JSONArray) rotesObj.get("sections");
			
			int[] sections = new int[sectionsArr.size()];
			int hap = 0;
			for(int i=0; i<sectionsArr.size(); i++) {
				JSONObject sectionsObj = (JSONObject) sectionsArr.get(i);
				JSONArray guidesArr = (JSONArray)sectionsObj.get("guides");
				
				int[] duration= new int[guidesArr.size()]; 
				int sum = 0;
				for(int j=0; j<guidesArr.size(); j++) {
					JSONObject guidesObj = (JSONObject) guidesArr.get(j);
					sum+=Integer.parseInt(String.valueOf(guidesObj.get("duration")));
					duration[j] = sum;
				}
				hap += sum;
				sections[i] = hap;
				System.out.println(sections[i]);
			}
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}*/

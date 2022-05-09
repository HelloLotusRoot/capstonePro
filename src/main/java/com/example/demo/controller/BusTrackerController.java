package com.example.demo.controller;

import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BusTracker;

@RestController
public class BusTrackerController {

	private Map<String, BusTracker> busMap;

	@PostConstruct
	public void init() { // 값 초기화
		busMap = new HashMap<String, BusTracker>();
		busMap.put("1", new BusTracker("1", "부산12아1212", "129.07719215990883", "35.26914021080837"));
		busMap.put("2", new BusTracker("2", "부산23바2323", "129.07719215990883", "35.26914021080837"));
		busMap.put("3", new BusTracker("3", "부산34사3434", "129.07719215990883", "35.26914021080837"));
		busMap.put("4", new BusTracker("4", "부산45자4545", "129.07719215990883", "35.26914021080837"));
		busMap.put("5", new BusTracker("5", "부산56아5656", "129.07719215990883", "35.26914021080837"));
		busMap.put("6", new BusTracker("6", "부산67자6767", "129.07719215990883", "35.26914021080837"));
	}

	@GetMapping("/bus/refresh")
	//public BusTracker getBusTracker(@PathVariable("id") String id) {
	public BusTracker getBusTracker() {
		
		String id = null;
		int portNumber = 5555;
		int Verif;
		int Value = 0;
		for(Verif =1; Verif <=3; Verif++)
		{
			int Intid = 0;
			do
			{
			try {
				ServerSocket serverSocket = new ServerSocket(portNumber); //포트번호를 매개변수로 전달하면서 서버 소켓 열기
					{
						Value =0;
						Socket socket = serverSocket.accept(); //클라이언트가 접근했을 때 accept() 메소드를 통해 클라이언트 소켓 객체 참조
						InetAddress clientHost = socket.getLocalAddress();
						int clientPort = socket.getPort();

						ObjectInputStream instream = new ObjectInputStream(socket.getInputStream()); //소켓의 입력 스트림 객체 참조
						Object obj = instream.readObject(); // 입력 스트림으로부터 Object 객체 가져오기
						String BusInfo = String.valueOf(obj);
						
						String[] Temp = BusInfo.split("/");
                
						id = Temp[0]; //호차 변수 (문자열)
						String BusID = Temp[1]; // 차량번호 변수 (문자열)
						String Latitude = Temp[2]; // 위도 변수 (문자열)
						String Longitude = Temp[3]; // 경도 변수 (문자열)
						Intid = Integer.parseInt(id);
						
						busMap.put(id, new BusTracker(id, BusID, Latitude, Longitude));
                
						/*System.out.print(id);
                		System.out.print("/"+BusID);
                		System.out.print("/"+Latitude);
                		System.out.println("/"+Longitude); // 가져온 값이 올바른지 콘솔로 테스트 출력
               
                		// System.out.println(obj); // 가져온 객체 출력
						 */
                
						socket.close(); //소켓 해제
						serverSocket.close();
						if(Intid == Verif)
							Value = 1;
					}
				}
				catch(Exception e) {
	            e.printStackTrace();
				}
			}while(Value == 1);
		}
		return getBusMap(id);
	}

	private BusTracker getBusMap(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/bus/all")
	public List<BusTracker> getBusTrackerList() {
		return new ArrayList<BusTracker>(busMap.values());
	}

	@GetMapping("/bus/{id}")
	public BusTracker getBusTracker(@PathVariable("id") String id) {
		return busMap.get(id);
	}
}

package com.example.demo.controller;

import java.sql.Date;
//import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
//import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.mapper.User_accountMapper;
import com.example.demo.model.KakaoProfile;
import com.example.demo.model.OAuthToken;
import com.example.demo.model.User_account;
import com.example.demo.model.User_account.User_accountBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class User_accountController {

	private User_accountMapper mapper;
	
	public User_accountController(User_accountMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping(value = "/users/{user_id}")
	public User_account getUser_account(@PathVariable("user_id") String user_id) {
		return mapper.getUser_account(user_id);
	}
	
	@GetMapping(value = "/users/all")
	public List<User_account> getUser_accountList() {
		return mapper.getUser_accountList();
	}
	
	@PostMapping(value = "/users/")
	public User_account postUser_account(@RequestBody User_account user_accountInsert) {
		mapper.insertUser_account(user_accountInsert);
		return user_accountInsert;
	}
		
//	@PatchMapping(value = "/users/{user_id}")
//	public void patchUser_account(@PathVariable("user_id") String user_id, @RequestBody User_account user_update) {
//		mapper.updateUser_account(user_update);
//	}
	
	@DeleteMapping(value = "/users/{user_id}")
	public User_account deleteUser_account(@PathVariable("user_id") String user_id) {
		User_account user_accountDelete = mapper.getUser_account(user_id);
		mapper.deleteUser_account(user_id);
		return user_accountDelete;
	}
	
	@PutMapping(value = "/users/{user_id}")
	public User_account putUser_account(@PathVariable("user_id") String user_id, @RequestBody User_account user_accountUpdate) {
		mapper.updateUser_account(user_accountUpdate);
		return user_accountUpdate;
	}
	
//	@PutMapping(value = "/users/{user_id}")
//	public void putUser_account(@RequestBody("id_num") int id_num, @PathVariable("user_id") String user_id, @Param("name") String name, @Param("password") String password, @Param("phone") String phone, @Param("nickname") String nickname, @Param("profile_img") String profile_img, @Param("mail") String mail, @Param("bank") String bank, @Param("account_num") String account_num, @Param("dntry_date") Date entry_Date) {
//		mapper.updateUser_account(id_num, user_id, name, password, phone, nickname, profile_img, mail, bank, account_num, entry_date);
//	}
	
	@GetMapping(value = "/auth/kakao/callback")
	public @ResponseBody String kakaoCallback(String code) { // Data를 리턴해주는 컨트롤러 함수
		
		// Post 방식으로 key=value 데이터를 요청(카카오쪽으로)
		RestTemplate rt = new RestTemplate();
		
		// HttpHeader 오브젝트 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// HttpBody 오브젝트 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "");
		params.add("redirect_uri", "http://localhost:8080/auth/kakao/callback");
		params.add("code", code);
		
		// HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);
		
		// Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음.
		ResponseEntity<String> response = rt.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST, kakaoTokenRequest, String.class);
		
		// JsonData 담기
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthToken oauthToken = null;
		try {
			oauthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println("카카오 엑세스 토큰: "+oauthToken.getAccess_token());
		
		RestTemplate rt2 = new RestTemplate();
		
		// HttpHeader 오브젝트 생성
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer " + oauthToken.getAccess_token());
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers2);
				
		// Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음.
		ResponseEntity<String> response2 = rt2.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.POST, kakaoProfileRequest, String.class);
			
		ObjectMapper objectMapper2 = new ObjectMapper();
		KakaoProfile kakaoProfile = null;
		try {
			kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		// User 오브젝트 :
		System.out.println("카카오 아이디(번호) : " + kakaoProfile.getId());
		System.out.println("카카오 이메일 : " + kakaoProfile.getKakao_account().getEmail());
		
		System.out.println("카카오로그인서버x(우리원래서버) 유저네임 : " + kakaoProfile.getKakao_account().getEmail() + "_" + kakaoProfile.getId());
		System.out.println("카카오로그인서버x(우리원래서버) 이메일 : " + kakaoProfile.getKakao_account().getEmail());
		UUID garbagePassword = UUID.randomUUID(); // 임시 비밀번호 (카카오로그인은 비밀번호가 필요없기때문에)
		System.out.println("블로그서버 패스워드:" + garbagePassword);
		
	/*	User_account kakaoUser = User_account.builder()
			//	.id_num();
				.user_id(kakaoProfile.getKakao_account().getEmail() + "_" + kakaoProfile.getId()) //아이디
				.name(kakaoProfile.getProperties().getNickname()) //이름
				.password(garbagePassword.toString()) //비밀번호
			//	.phone //휴대폰
			//	.nickname //닉네임
				.profile_img(kakaoProfile.getProperties().getProfile_image()) //프로필 이미지
				.mail(kakaoProfile.getKakao_account().getEmail()); //메일
			//	.bank //은행
			//	.account_num //계좌번호
			//	.entry_date //가입날짜*/
		
		return response2.getBody();
		
	}
}

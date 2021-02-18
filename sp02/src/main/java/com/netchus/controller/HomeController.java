package com.netchus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netchus.service.JsonDataParser;
import com.netchus.service.MockDataParser;
import com.netchus.service.PublicOpenAPI;
import com.netchus.service.SensorService;

@Controller
public class HomeController {

	@Autowired
	private SensorService service;
	@Autowired
	private MockDataParser parser;
	@Autowired
	private PublicOpenAPI openapi;
	@Autowired
	private JsonDataParser jsonparser;

	public HomeController(SensorService service) {
		super();
		this.service = service;
	}
	
	//실습 kakao map 출력
	@RequestMapping(value = "/exkakaoMap1", method = RequestMethod.GET)
	public String exkakaoMap1(Model model) {
		
		return "ex/exkakaoMap1";
	}
	
	
	//실습 kakao map 마커 출력
	@RequestMapping(value ="/exkakaoMap2", method = RequestMethod.GET)
	public String exkakaoMap2(Model model) {
		
		return "ex/exkakaoMap2";
	}

	// 실습 API Call
	@RequestMapping(value = "/exAPI1", method = RequestMethod.GET)
	public String exAPI1(Model model) throws Exception {
		
		return "ex/API1";
	}

	// 실습 JSON Parsing javascript
	@RequestMapping(value = "/exAPI2", method = RequestMethod.GET)
	public String exAPI2(Model model) throws Exception {
		
		return "ex/API2";
	}

	// 실습 JSON Parsing javascript
	@RequestMapping(value = "/ex5API", method = RequestMethod.GET)
	public String ex3API(Model model) throws Exception {
		
		return "ex3API";
	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//kakao map 호출
	@RequestMapping(value = "/kakaoMap1", method = RequestMethod.GET)
	public String kakaoMap1(Model model) {
		
		return "answer/kakaoMap1";
	}
	
	
	//kakao map 
	@RequestMapping(value ="/kakaoMap2", method = RequestMethod.GET)
	public String kakaoMap2(Model model) {
		// void 라 기본 view 경로가 kakap.jsp로 간다.
		
		return "answer/kakaoMap2";
	}
	

	// callAPI1 type JAVA
	@RequestMapping(value = "/callAPI1", method = RequestMethod.GET)
	public String callAPI1(Model model) throws Exception {
		// 공공 데이터 포털 API 호출
		String data = openapi.callAPI();

		// JSON 파싱 JAVA
		jsonparser.parseFromJSONData(data);

		return "answer/callAPI1";
	}

	// callAPI1 type javascript
	@RequestMapping(value = "/callAPI2", method = RequestMethod.GET)
	public String callAPI2(Model model) throws Exception {
		// 공공 데이터 포털 API 호출
		model.addAttribute("apiData", openapi.callAPI());
		return "answer/callAPI2";
	}

	// json ex1
	@RequestMapping(value = "/json1", method = RequestMethod.GET)
	public String json1(Model model) {
		// model.addAttribute("sensorList", service.getResponse());
		model.addAttribute("sensorList", parser.paseFromJSONData(service.getMockData()));
		return "answer/json1";
	}

	// mock JSON data를 가져오는 메서드
	// 아직 parsing이 안되어 있음 method 에서 추가로 자르는 작업 必
	@RequestMapping(value = "/sensor", method = RequestMethod.GET)
	public String getSensorData(Model model) {
		model.addAttribute("sensorList", service.getResponse());
		return "answer/sensor";
	}

}

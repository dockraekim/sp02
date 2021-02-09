package com.netchus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netchus.service.MockDataParser;
import com.netchus.service.SensorService;

@Controller
public class HomeController {
	
	@Autowired
	private SensorService service;
	@Autowired
	private MockDataParser parser;

	public HomeController(SensorService service) {
		super();
		this.service = service;
	}
	
	
	// mock JSON data를 가져오는 메서드
	// 아직 parsing이 안되어 있음 method 에서 추가로 자르는 작업 必
	@RequestMapping(value = "/sensor", method = RequestMethod.GET)
	public String getSensorData(Model model) {
		model.addAttribute("sensorList", service.getResponse());
		return "sensor";
	}
	
}

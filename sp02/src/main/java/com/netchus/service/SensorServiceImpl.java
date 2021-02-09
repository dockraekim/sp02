package com.netchus.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.netchus.domain.EnvironmentVO;


@Service
public class SensorServiceImpl implements SensorService {

	
	
	// 웹 서버 구동 안하고도 찍을수 있게 main에 찍게 만듬
	public static void main(String[] args) {
		SensorService ss = new SensorServiceImpl();
		String tmp = ss.getMockData();
		System.out.println(tmp.toString());
	}
	
	// JSON데이터 파싱하는 메서드
	@Override
	public ArrayList<HashMap<String,Object>> getResponse() {
		ArrayList<HashMap<String,Object>> map = new ArrayList<HashMap<String,Object>>();
		String tmp = getMockData();
		JSONParser jsonParser = new JSONParser(); 
		JSONArray jsonArray;
		try {
			jsonArray = (JSONArray)jsonParser.parse(tmp);
			/*
			json 형태로 나온 메서드를 파싱해서 HashMap에 담아주세요
			*/
			System.out.println(jsonArray.toJSONString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	// mock data를 만드는 메서드
	// JSON String으로 만드는 부분은 VO toString에 선언되어있다.
	@Override
	public String getMockData() {
		
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		String res = format.format(d);
		
		EnvironmentVO vo1 = new EnvironmentVO("Sensor-001",36.8,6.6,7.0,7.0,8.6,0.0,534.0,res);
		EnvironmentVO vo2 = new EnvironmentVO("Sensor-002",24.8,16.4,8.0,8.0,8.6,0.0,469.0,res);
		EnvironmentVO vo3 = new EnvironmentVO("Sensor-003",15.4,23.1,16.0,14.0,8.6,0.0,437.0,res);
		EnvironmentVO vo4 = new EnvironmentVO("Sensor-004",24.1,14.0,15.0,15.0,8.6,0.0,557.0,res);
		EnvironmentVO vo5 = new EnvironmentVO("Sensor-005",36.8,6.6,7.0,7.0,8.6,0.0,534.0,res);
		EnvironmentVO vo6 = new EnvironmentVO("Sensor-006",24.8,16.4,8.0,8.0,8.6,0.0,469.0,res);
		EnvironmentVO vo7 = new EnvironmentVO("Sensor-007",15.4,23.1,16.0,14.0,8.6,0.0,437.0,res);
		EnvironmentVO vo8 = new EnvironmentVO("Sensor-008",24.1,14.0,15.0,15.0,8.6,0.0,557.0,res);
		EnvironmentVO vo9 = new EnvironmentVO("Sensor-009",15.4,23.1,16.0,14.0,8.6,0.0,437.0,res);
		EnvironmentVO vo10 = new EnvironmentVO("Sensor-010",24.1,14.0,15.0,15.0,8.6,0.0,557.0,res);
		System.out.println(d.toString());
		
		
		return "["+vo1.toString()+","+vo2.toString()+","+vo3.toString()+","+vo4.toString()+vo5.toString()+","+vo6.toString()+","+vo7.toString()+","+vo8.toString()+vo9.toString()+","+vo10.toString()+"]";
	}
	
	

}

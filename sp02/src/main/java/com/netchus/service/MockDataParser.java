package com.netchus.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
@Service
public class MockDataParser {

	SensorServiceImpl ss;
	
	public MockDataParser(SensorServiceImpl ss) {
		super();
		this.ss = ss;
	}
	
	
//	HomeController에 넣어주면 잘 작동할 것임.
//	model.addAttribute("sensorList", parser.paseFromJSONData(service.getMockData()));
	
	public ArrayList<HashMap<String,Object>> paseFromJSONData(String data) {
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		String doc = ss.getMockData();
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray;
		try {
			jsonArray = (JSONArray)jsonParser.parse(doc);
			int size = jsonArray.size();
			for (int i = 0; i < size; i++) {
				HashMap<String,Object> map = new HashMap<String,Object>();
				JSONObject obj = (JSONObject)jsonArray.get(i);
				map.put("sensorId",obj.get("sensorId"));
				map.put("temp", obj.get("temp"));
				map.put("humidity", obj.get("humidity"));
				map.put("tm1", obj.get("tm1"));
				map.put("tm2_5", obj.get("tm2_5"));
				map.put("tm10", obj.get("tm10"));
				map.put("co2", obj.get("co2"));
				map.put("tvoc", obj.get("tvoc"));
				map.put("date", obj.get("date"));
				list.add(map);
				System.out.println(jsonArray.toJSONString());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	
}

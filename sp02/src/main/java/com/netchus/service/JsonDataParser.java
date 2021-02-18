package com.netchus.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class JsonDataParser {

	public ArrayList<HashMap<String, Object>> parseFromJSONData(String jsonData) {
		ArrayList<HashMap<String, Object>> arrayList = null;

		// jsonparser 객체 생성
		JSONParser jsonParser = new JSONParser();

		try {
			// JSON데이터를 넣어 JSON Object 로 만들어 준다.
			JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonData);

			// 시도별의 실시간측정정보 records 배열을 추출
			JSONArray listArray = (JSONArray) jsonObject.get("list");
			System.out.println("--listArray size : " + listArray.size());

			int size = listArray.size();

			arrayList = new ArrayList<HashMap<String, Object>>();

			for (int i = 0; i < listArray.size(); i++) {
				HashMap<String, Object> map = new HashMap<String, Object>();

				// 배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
				JSONObject listObject = (JSONObject) listArray.get(i);

				System.out.println("--- so2Value ==>" + listObject.get("so2Value")); // 아황산가스 농도(단위 : ppm)
				System.out.println("--- coValue ==>" + listObject.get("coValue")); // 일산화탄소 농도(단위 : ppm)
				System.out.println("--- o3Value ==>" + listObject.get("o3Value")); // 오존 농도(단위 : ppm)
				System.out.println("--- no2Value ==>" + listObject.get("no2Value")); // 이산화질소 농도(단위 : ppm)
				System.out.println("--- pm10Value ==>" + listObject.get("pm10Value")); // 미세먼지(PM10) 농도 (단위 : ㎍/㎥)
				System.out.println("--- pm25Value ==>" + listObject.get("no2Value")); // 미세먼지(PM2.5) 농도(단위 : ㎍/㎥)

				System.out.println("--- dataTime ==>" + listObject.get("dataTime")); // 발표날짜

				System.out.println("--------------------------------------------------------------------------");

				map.put("so2", listObject.get("so2Value"));
				map.put("co", listObject.get("coValue"));
				map.put("o3", listObject.get("o3Value"));
				map.put("no2", listObject.get("no2Value"));
				map.put("pm10", listObject.get("pm10Value"));
				map.put("pm25", listObject.get("pm25Value"));

				map.put("dataTime", listObject.get("dataTime"));

				arrayList.add(map);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}

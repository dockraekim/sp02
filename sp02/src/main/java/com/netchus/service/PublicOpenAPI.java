package com.netchus.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

@Service
public class PublicOpenAPI {

	public String callAPI() throws Exception {
		// 측정소별 실시간 측정정보 조회
		StringBuilder urlBuilder = new StringBuilder("http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=서비스 키"); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
		urlBuilder.append("&" + URLEncoder.encode("stationName", "UTF-8") + "=" + URLEncoder.encode("비전동", "UTF-8")); /*측정소 이름*/
		urlBuilder.append("&" + URLEncoder.encode("dataTerm", "UTF-8") + "=" + URLEncoder.encode("DAILY", "UTF-8")); /*요청 데이터기간 (하루 : DAILY, 한달 : MONTH, 3달 : 3MONTH)*/
		urlBuilder.append("&" + URLEncoder.encode("ver", "UTF-8") + "=" + URLEncoder.encode("1.3", "UTF-8")); /*버전별 상세 결과 참고문서 참조*/
		urlBuilder.append("&" + URLEncoder.encode("_returnType", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*return type = json*/
		URL url = new URL(urlBuilder.toString());

		// HTTP Connection 구하기
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		// 요청 방식 설정 ( GET or POST or .. 별도로 설정하지않으면 GET 방식 )
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");

		// 요청 방식 구하기
		System.out.println("getRequestMethod():" + conn.getRequestMethod());
		// 응답 콘텐츠 유형 구하기
		System.out.println("getContentType():" + conn.getContentType());
		// 응답 코드 구하기
		System.out.println("getResponseCode():" + conn.getResponseCode());
		// 응답 메시지 구하기
		System.out.println("getResponseMessage():" + conn.getResponseMessage());

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());

		return sb.toString();
	}

	public static void main(String[] args) {

	}
}

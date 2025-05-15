package controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiExplorer {

	// 접속용 url 생성 메서드
	public static <T extends Object> T getApiJsonData(String serviceKey, String srcUrl, String routeId, Class<T> dto)
			throws IOException, URISyntaxException {

		StringBuilder urlBuilder = new StringBuilder(srcUrl);
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
		urlBuilder.append("&" + URLEncoder.encode("routeId", "UTF-8") + "=" + routeId);
		urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));

//		System.out.println("url = " + urlBuilder.toString());

		// 커넥션 생성
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		// 접속 타입 지정(GET, json 형태)
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");

//		System.out.println("Response code: " + conn.getResponseCode());

		// 파일 읽어 오기
		BufferedReader rd;

		// 접속 url에 에러가 없으면
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {

			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		} else {

			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));

		}

		StringBuilder sb = new StringBuilder();
		String line;

		// 읽어올 데이터가 있으면 반복
		while ((line = rd.readLine()) != null) {

			sb.append(line);

		}

		// 연결 종료
		rd.close();
		conn.disconnect();

		ObjectMapper objMapper = new ObjectMapper();
		T data = objMapper.readValue(sb.toString(), dto);

		if (data != null) {

//			System.out.println("data = " + data.toString());

		}

		return data;

	} // 메서드 종료

} // class 끝
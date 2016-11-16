package com.sktelecom.tdrive;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public class TmapApi {
	static String url = "https://apis.skplanetx.com/tmap/routes?callback=&version=1";
	static String xskpopuserId = "hyun@sptek.co.kr";
	static String AcceptLanguage = "ko_KR";
	static String ContentType = "application/x-www-form-urlencoded;charset=utf-8";
	static String Accept = "application/json";
	static String access_token = "";
	static String appKey = "c50d5304-b445-3c35-8953-d9279928cc66";
	
	static String endX = "14133518.0344372";
	static String endY = "4505815.2222688";
	static int roadType = 32;
	static int tollgateFareOption = 8;
	static String startX = "14129748.9535116";
	static String startY = "4506820.3521510";
	
	protected static HttpPost setHeaderPost(HttpPost request) {
		request.setHeader("Content-Type", ContentType);
		request.setHeader("Accept", Accept);
		request.setHeader("access_token", access_token);
		request.setHeader("x-skpop-userId", xskpopuserId);
		request.setHeader("Accept-Language", AcceptLanguage);
		request.setHeader("appKey", appKey);
		
		return request;
	}

	public static void tmapRoute() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpPost postRequest = new HttpPost(url);
		setHeaderPost(postRequest);
		
		requestMap.put("endX", endX);
		requestMap.put("endY", endY);
		requestMap.put("roadType", roadType);
		requestMap.put("tollgateFareOption", tollgateFareOption);
		requestMap.put("startX", startX);
		requestMap.put("startY", startY);
		
		HttpUtil.requestTmapPostApi(requestMap, postRequest);
	}
}

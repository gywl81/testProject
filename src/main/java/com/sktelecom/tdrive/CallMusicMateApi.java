package com.sktelecom.tdrive;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public class CallMusicMateApi {
	static String url = "http://musicmate-service-lb-1496525638.ap-northeast-1.elb.amazonaws.com/was/tdrive";
//	static String url = "https://api.musicmates.co.kr/was/tdrive";
	static String login_id = "sptek17";
	static String uuid = "00000000-542a-6c0c-1f13-db8700000017";
	static String member_type = "tdrive";
	static String device_type = "android";
	static String SessionKey = "MDY2YmFlZjM4YTlkYzcwODpbQkA1NjM5YmZjYQ==";
	static int member_key = 201042;
	static String keyword = "발라드";
	static int page = 1;
	static int count = 20;
	static String content = null; // 이미지 Base64 로 인코딩 된 이미지 데이터
	static String ServiceKey = "95d940e7d0701064";
//	static String ServiceKey = "46d6b6bb6f83952f";
	static String ContentType = "application/json";
	static String criteria = "popular";
	static String criteria2 = "delegate";
	static String criteria3 = "category";
	static String criteria4 = "theme";
	static long category_code = 5;
	static long theme_code = 1;
	static String channel_id = "72839";
	static String music_ticket = "10";
	static String start_date = "20160701";
	static String end_date = "20160730";
	
	protected static HttpGet setHeaderGet(HttpGet request) {
//		request.setHeader("Content-Type", ContentType);
		request.setHeader("ServiceKey", ServiceKey);

		return request;
	}

	protected static HttpGet setHeaderGetWithSession(HttpGet request) {
//		request.setHeader("Content-Type", ContentType);
		request.setHeader("ServiceKey", ServiceKey);
		request.setHeader("SessionKey", SessionKey);
		
		return request;
	}

	protected static HttpPost setHeaderPost(HttpPost request) {
		request.setHeader("Content-Type", ContentType);
		request.setHeader("ServiceKey", ServiceKey);

		return request;
	}

	protected static HttpPost setHeaderPostWithSession(HttpPost request) {
		request.setHeader("Content-Type", ContentType);
		request.setHeader("ServiceKey", ServiceKey);
		request.setHeader("SessionKey", SessionKey);

		return request;
	}
	
	public static void register() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpPost postRequest = new HttpPost(url + "/member/v1/register.do");
		setHeaderPost(postRequest);
		
		requestMap.put("login_id", login_id);
		requestMap.put("uuid", uuid);
		requestMap.put("music_ticket", music_ticket);
		requestMap.put("start_date", start_date);
		requestMap.put("end_date", end_date);
		requestMap.put("member_type", member_type);
		requestMap.put("device_type", device_type);
		
		HttpUtil.requestPostApi(requestMap, postRequest);
	}
	public static void session() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpPost postRequest = new HttpPost(url + "/member/v1/session.do");
		setHeaderPost(postRequest);
		
		requestMap.put("login_id", login_id);
		requestMap.put("music_ticket", music_ticket);
		requestMap.put("start_date", start_date);
		requestMap.put("end_date", end_date);
		requestMap.put("uuid", uuid);
		
		HttpUtil.requestPostApi(requestMap, postRequest);
	}
	
	public static void sessionChk() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpGet getRequest = new HttpGet(url + "/member/v1/session.do?uuid=" + uuid + "&member_key=" + member_key);
		setHeaderGetWithSession(getRequest);
		
		HttpUtil.requestGetApi(requestMap, getRequest);
	}
	public static void logout() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpPost postRequest = new HttpPost(url + "/member/v1/session/delete.do");
		setHeaderPostWithSession(postRequest);
		
		requestMap.put("member_key", member_key);
		requestMap.put("uuid", uuid);
		
		HttpUtil.requestPostApi(requestMap, postRequest);
	}
	public static void unRegister() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpPost postRequest = new HttpPost(url + "/member/v1/unregister.do");
		setHeaderPostWithSession(postRequest);
		
		requestMap.put("member_key", member_key);
		requestMap.put("login_id", login_id);
		
		HttpUtil.requestPostApi(requestMap, postRequest);
	}
	public static void sessionRenew() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpPost postRequest = new HttpPost(url + "/member/v1/session/extend.do");
		setHeaderPostWithSession(postRequest);
		
		requestMap.put("member_key", member_key);
		requestMap.put("uuid", uuid);
		
		HttpUtil.requestPostApi(requestMap, postRequest);
	}
	public static void imageUpload() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		
		HttpPost postRequest = new HttpPost(url + "/member/v1/profile/image/upload.do");
		setHeaderPostWithSession(postRequest);
		
		requestMap.put("member_key", member_key);
		requestMap.put("content", CommonUtil.fileToString());
		requestMap.put("uuid", uuid);
		
		HttpUtil.requestPostApi(requestMap, postRequest);
	}
	public static void userSettingSelect() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpGet getRequest = new HttpGet(url + "/member/v1/profile/list.do?uuid=" + uuid + "&member_key=" + member_key);
		setHeaderGetWithSession(getRequest);
		
		HttpUtil.requestGetApi(requestMap, getRequest);
	}
	public static void serviceable() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpGet getRequest = new HttpGet(url + "/serviceable.do");
		setHeaderGet(getRequest);
		
		HttpUtil.requestGetApi(requestMap, getRequest);
	}
	public static void categoryList() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpGet getRequest = new HttpGet(url + "/category/v1/list.do?member_key=" + member_key);
		setHeaderGetWithSession(getRequest);
		
		HttpUtil.requestGetApi(requestMap, getRequest);
	}
	public static void channelHistoryList() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpGet getRequest = new HttpGet(url + "/channel/v1/history/list.do?member_key=" + member_key + "&page=" + page + "&count=" + count);
		setHeaderGetWithSession(getRequest);
		
		HttpUtil.requestGetApi(requestMap, getRequest);
	}
	public static void channelSearch() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		
		HttpPost postRequest = new HttpPost(url + "/channel/v1/search.do");
		setHeaderPostWithSession(postRequest);
		
		requestMap.put("member_key", member_key);
		requestMap.put("uuid", uuid);
		requestMap.put("keyword", keyword);
		requestMap.put("page", page);
		requestMap.put("count", count);
		
		HttpUtil.requestPostApi(requestMap, postRequest);
	}
	public static void channelList() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpGet getRequest = new HttpGet(url + "/channel/v1/list.do?member_key=" + member_key + "&criteria=" + criteria);
		setHeaderGetWithSession(getRequest);
		
		HttpUtil.requestGetApi(requestMap, getRequest);
	}
	public static void representList() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpGet getRequest = new HttpGet(url + "/channel/v1/list.do?member_key=" + member_key + "&criteria=" + criteria2);
		setHeaderGetWithSession(getRequest);
		
		HttpUtil.requestGetApi(requestMap, getRequest);
	}
	public static void themeList() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpGet getRequest = new HttpGet(url + "/theme/v1/list.do?member_key=" + member_key);
		setHeaderGetWithSession(getRequest);
		
		HttpUtil.requestGetApi(requestMap, getRequest);
	}
	public static void categoryChannelList() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpGet getRequest = new HttpGet(url + "/channel/v1/list.do?member_key=" + member_key + "&criteria=" + criteria3 + "&category_code=" + category_code);
		setHeaderGetWithSession(getRequest);
		
		HttpUtil.requestGetApi(requestMap, getRequest);
	}
	public static void themeChannelList() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		HttpGet getRequest = new HttpGet(url + "/channel/v1/list.do?member_key=" + member_key + "&criteria=" + criteria4 + "&theme_code=" + theme_code);
		setHeaderGetWithSession(getRequest);
		
		HttpUtil.requestGetApi(requestMap, getRequest);
	}
	public static void favorites() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		
		HttpPost postRequest = new HttpPost(url + "/channel/v1/favorites/mark.do");
		setHeaderPostWithSession(postRequest);
		
		requestMap.put("member_key", member_key);
		requestMap.put("channel_id", channel_id);
		
		HttpUtil.requestPostApi(requestMap, postRequest);
	}
	public static void favoritesUnMark() {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		
		HttpPost postRequest = new HttpPost(url + "/channel/v1/favorites/unmark.do");
		setHeaderPostWithSession(postRequest);
		
		requestMap.put("member_key", member_key);
		requestMap.put("channel_id", channel_id);
		
		HttpUtil.requestPostApi(requestMap, postRequest);
	}
}

package com.sktelecom.tdrive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.JsonParser;
import com.sktelecom.tdrive.util.JsonUtil;

@SuppressWarnings("deprecation")
public class HttpUtil {
	@SuppressWarnings({ "resource", "unused" })
	public static void requestTmapPostApi(Map<String, Object> userMap, HttpPost postRequest) {
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = null;
		String result = null;
		JsonParser parser = new JsonParser();
		int l;
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("endX", userMap.get("endX").toString()));
		    nameValuePairs.add(new BasicNameValuePair("endY", userMap.get("endY").toString()));
		    nameValuePairs.add(new BasicNameValuePair("startX", userMap.get("startX").toString()));
		    nameValuePairs.add(new BasicNameValuePair("startY", userMap.get("startY").toString()));

		    postRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			
			
			response = client.execute(postRequest);
			if (response != null) {
				int statusCode = response.getStatusLine().getStatusCode();
				
//				Header[] headers = response.getAllHeaders();
//				
//				for (Header header : headers) {
//					System.out.println("header getName=== :: " + header.getName());
//					System.out.println("header getValue=== :: " + header.getValue());
//				}
				HttpEntity resEntityPost = response.getEntity();
				
				System.out.println("statusCode === :: " + statusCode);
				if (statusCode == 200) {// 정상
					if (resEntityPost != null) {
						InputStream instream = resEntityPost.getContent();
						result = convertStreamToString(instream);
						
						System.out.println("totalTime === :: " + parser.parse(result).getAsJsonObject().get("features").getAsJsonArray().get(0).getAsJsonObject().get("properties").getAsJsonObject().get("totalTime"));
						
//						byte[] tmp = new byte[2048];
//						while ((l = instream.read(tmp)) != -1) {
//							System.out.println(new String(tmp));
//						}
					}
					
				} else {// 정상이 아닌 경우
					if (resEntityPost != null) {
						InputStream instream = resEntityPost.getContent();
						byte[] tmp = new byte[2048];
						while ((l = instream.read(tmp)) != -1) {
							System.out.println(new String(tmp));
						}
					}
				}
			} else {
				System.out.println("response === :: null");
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("System Error. requestPostApi 1>>>" + e.getMessage());
		} catch (Exception e) {
			System.out.println("System Error. requestPostApi 2>>>" + e.getMessage());
			System.out.println("System Error. requestPostApi 2>>>" + e.getCause());
			System.out.println("System Error. requestPostApi 2>>>" + e);
		}
	}
	@SuppressWarnings({ "resource", "unused" })
	public static void requestPostApi(Map<String, Object> userMap, HttpPost postRequest) {
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = null;
		int l;
		try {
//			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
//			nameValuePairs.add(new BasicNameValuePair("version", "1"));
//		    nameValuePairs.add(new BasicNameValuePair("callback", ""));
//
//		    postRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			
			StringEntity entity = new StringEntity(JsonUtil.convertJsonSerializeNulls(userMap), "UTF-8");

			postRequest.setEntity(entity);
			
			if (entity != null) {
				InputStream instream = entity.getContent();
				int k;
				byte[] tmp = new byte[2048];
				while ((k = instream.read(tmp)) != -1) {
					System.out.println("tmp === :: " + new String(tmp));
				}
			}
			
			response = client.execute(postRequest);
			if (response != null) {
				int statusCode = response.getStatusLine().getStatusCode();

//				Header[] headers = response.getAllHeaders();
//
//				for (Header header : headers) {
//					System.out.println("header getName=== :: " + header.getName());
//					System.out.println("header getValue=== :: " + header.getValue());
//				}
				HttpEntity resEntityPost = response.getEntity();

				System.out.println("statusCode === :: " + statusCode);
				if (statusCode == 200) {// 정상
					if (resEntityPost != null) {
						InputStream instream = resEntityPost.getContent();
						byte[] tmp = new byte[2048];
						while ((l = instream.read(tmp)) != -1) {
							System.out.println(new String(tmp));
						}
					}
				} else {// 정상이 아닌 경우
					if (resEntityPost != null) {
						InputStream instream = resEntityPost.getContent();
						byte[] tmp = new byte[2048];
						while ((l = instream.read(tmp)) != -1) {
							System.out.println(new String(tmp));
						}
					}
				}
			} else {
				System.out.println("response === :: null");
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("System Error. requestPostApi 1>>>" + e.getMessage());
		} catch (Exception e) {
			System.out.println("System Error. requestPostApi 2>>>" + e.getMessage());
			System.out.println("System Error. requestPostApi 2>>>" + e.getCause());
			System.out.println("System Error. requestPostApi 2>>>" + e);
		}
	}

	@SuppressWarnings({ "resource", "unused" })
	public static void requestGetApi(Map<String, Object> userMap, HttpGet getRequest) {
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = null;
		int l;
		try {
			response = client.execute(getRequest);
			if (response != null) {
				int statusCode = response.getStatusLine().getStatusCode();

//				Header[] headers = response.getAllHeaders();

//				for (Header header : headers) {
//
//				}
				
				HttpEntity resEntityGet = response.getEntity();
				System.out.println(response.getStatusLine().getStatusCode());
				if (statusCode == 200) {// 정상
					if (resEntityGet != null) {
						InputStream instream = resEntityGet.getContent();
						byte[] tmp = new byte[2048];
						while ((l = instream.read(tmp)) != -1) {
							System.out.println(new String(tmp));
						}
					}
				} else {// 정상이 아닌 경우
					if (resEntityGet != null) {
						InputStream instream = resEntityGet.getContent();
						byte[] tmp = new byte[2048];
						while ((l = instream.read(tmp)) != -1) {
							System.out.println(new String(tmp));
						}
					}
				}
			} else {

			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("System Error. requestGetApi 1>>>" + e.getMessage());
		} catch (Exception e) {
			System.out.println("System Error. requestGetApi 2>>>" + e.getMessage());
		}
	}
	public static String convertStreamToString(InputStream is) {
		StringBuilder sb = new StringBuilder(); // 변환된 값을 담을 객체 생성

		String line = null; // 한 줄씩 반복하여 String 변수를 선언
		String encoding = "utf-8";
		try

		{
			// InputStream 은 문자열로 해석하기 위해 InputStreamReader로 변환한 후
			// 다시 BufferedReader 로 변환
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, encoding), 8);
			// BufferedReader 를 한 줄씩 반복하여 문자열로 읽어오고
			// StringBuilder에 저장한다.
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e)

		{
			e.printStackTrace();
		} finally

		{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString(); // 저장 된 StringBuilder를 String 으로 변환하여 반환

	}
}

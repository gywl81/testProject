package com.sktelecom.tdrive;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class skNetworksApiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> transaction = new HashMap<String, Object>();
		Map<String, Object> attributes = new HashMap<String, Object>();
		Map<String, Object> dataSet = new HashMap<String, Object>();
		Map<String, Object> fields = new HashMap<String, Object>();
		Map<String, Object> recordSets = new HashMap<String, Object>();
		
		fields.put("TRD_NO", "20160303231111.123");
		fields.put("IF_ID", "SKTREQ001");
		fields.put("CHANNEL_TYPE", "SKT");
		fields.put("LOCATION_CD", "TDRV");
		fields.put("ISSUE_TYPE", "1");
		fields.put("GOODS_CD", "SKTDR16005");
		fields.put("JOIN_REQDATE", "20160303");
		fields.put("PERIOD_TYPE", "1");
		fields.put("CUST_NM", "홍길동");
		fields.put("CI_CD", "11111111111111111111111111111111111111");
		fields.put("BIRTH_YR", "1981");
		fields.put("BIRTH_MN", "1212");
		fields.put("GENDER", "1");
		fields.put("CELL_PHONE", "01011112222");
		fields.put("POST_CD", "1515");
		fields.put("ADDR1", "주소1");
		fields.put("ADDR2", "주소2");
		fields.put("CUSTINFO_SUP_YN", "Y");
		
		transaction.put("id", "MCHBuyMbsCard");
		attributes.put("FRST_TRNM_CHNL_CD", "SKT");
		dataSet.put("recordSets", recordSets);
		dataSet.put("fields", fields);
		
		resultMap.put("transaction", transaction);
		resultMap.put("attributes", attributes);
		resultMap.put("dataSet", dataSet);
		
		requestPostApi(resultMap);
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static String requestPostApi(Map<String, Object> userMap) {
		HttpClient client = new DefaultHttpClient();
		HttpParams httpParams = client.getParams();
		int timeout = 10;
		httpParams.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeout * 1000);
		
		HttpPost postRequest = new HttpPost("http://mobilehamdev.sknetworks.co.kr/web/json.jmd");
		HttpResponse response = null;
//		String result = null;
		String bodyJson = null;
		try {
			
			System.out.println("json data === :: " + JsonUtil.convertJsonSerializeNulls(userMap));
			StringEntity entity = new StringEntity(JsonUtil.convertJsonSerializeNulls(userMap), "UTF-8");
//			
//			 HashMap<String, Object> rs = new ObjectMapper().readValue(JsonUtil.convertJsonSerializeNulls(userMap), HashMap.class) ; 
//			 String user_name = (String)rs.get("user_name") ;
//			 entity.setContentType("application/json");
			 
			entity.setContentType("application/x-www-form-urlencoded");
			postRequest.setEntity(entity);

			response = client.execute(postRequest);
			if (response != null) {
				System.out.println("response === :: " + response);
				
				if ( HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
					System.out.println("success");
				} else {
					System.out.println("fail");
				}
				
				System.out.println("response.getStatusLine === :: " + response.getStatusLine().getStatusCode());
				
				bodyJson = EntityUtils.toString(response.getEntity());
				
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("System Error. requestPostApi >>>" + e.getMessage());
		} catch (Exception e) {
			System.out.println("System Error. requestPostApi >>>" + e.getMessage());
		}
		System.out.println("bodyJson" + bodyJson);
		return bodyJson;
	}
}

/*
 * Title : JsonUtil
 */
package com.sktelecom.tdrive;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

	public static String convertJson(Object obj) throws Exception{
        
		Gson gson = new Gson();
        
		return gson.toJson(obj);

	}
	
	public static String convertJsonSerializeNulls(Object obj) throws Exception{
        
		Gson gson = new GsonBuilder().serializeNulls().create();
        
		return gson.toJson(obj);

	}
	
/*	
	public static String convertJsonSerializeNullsNExcludeFields(Object obj) throws Exception{
        
		GsonBuilder builder = new GsonBuilder();
	    builder.excludeFieldsWithoutExposeAnnotation();
	    
	    Gson gson = builder.serializeNulls().create();
        
		return gson.toJson(obj);

	}
*/
	
	
	
}


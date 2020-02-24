package com.banirudh.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class EmployeeResponse {
	
	public static String responseMapper(String json) {
		
		String jsonMsg = null;
		JsonObject convertedObject = new Gson().fromJson(json, JsonObject.class);
		jsonMsg = convertedObject.toString();
		return jsonMsg;
		
	}

}

package com.deep.spring.controller;

import com.google.gson.Gson;

public class GetJsonFromObject {

	public static String getJsonData(Object objdata) {
		System.out.println("Executed method");
		System.out.println("objdata: "+objdata);
		Gson gson = new Gson();
		String json = gson.toJson(objdata);
		return json;
	}
}

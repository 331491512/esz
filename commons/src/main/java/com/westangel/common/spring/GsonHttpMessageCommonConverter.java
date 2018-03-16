package com.westangel.common.spring;

import org.springframework.http.converter.json.GsonHttpMessageConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonHttpMessageCommonConverter extends GsonHttpMessageConverter
{

	
	public GsonHttpMessageCommonConverter()
	 {
		 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		 this.setGson(gson);

	 }
}





package com.demo.dto;

import org.json.JSONObject;

import com.demo.base.Base;

import lombok.Getter;

@Getter
public class MainBuild {

	public static String book() {
		
		String run = null;
		JSONObject payload = Base.jsonRead("Cred").getJSONObject("tc01");
		Credentials credential=Credentials.builder().userName(payload.getString("userName")).passWord(payload.getString("password")).build();
		 run = Base.serialization(credential);
		 return run;

}
	
}

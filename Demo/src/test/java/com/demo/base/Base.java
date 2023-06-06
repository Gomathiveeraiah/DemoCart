package com.demo.base;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.demo.utilities.Path;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Base {
	static Logger logger = Logger.getLogger(Base.class);

	public static Properties readProperties() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(Path.configfile));
		} catch (Exception exception) {
			logger.error("Property file read is not performed :" + exception);
		}
		return properties;
	}

	public static JSONObject jsonRead(String Key) {
		try {
			InputStream input = new FileInputStream(Path.payload);
			JSONTokener tokener = new JSONTokener(input);
			JSONObject jsonObject = new JSONObject(tokener);
			JSONObject object = jsonObject.getJSONObject(Key);
			return object;
		} catch (Exception exception) {
			logger.error("Json Object Read is Not Performed :" + exception);
		}
		return null;
	}
	
	public static String serialization(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		} catch (Exception exception) {
			logger.error("Serialization is not performed :" + exception);
		}
		return null;
	}


}

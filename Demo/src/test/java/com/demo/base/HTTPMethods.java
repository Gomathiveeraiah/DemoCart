package com.demo.base;

import org.apache.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.response.Response;



/**
 * @author:Gomathi.Veeraiah
 * @description : This Class Contains HTTP Methods
 * 
 */

public class HTTPMethods {
	Logger logger = Logger.getLogger(Authentication.class);

	public Response get(String Url) {
		try {
            
			logger.info("Get call invoked");
			return RestAssured.given().contentType("application/json").when().log().all().get(Url);
		} catch (Exception exception) {
			logger.error("Get call not invoke: "+exception);

		}
		return null;
	}

	public Response post(String Url, Object payLoad) {
		try {
			logger.info("Put call invoked");
			return RestAssured.given().contentType("application/json").body(payLoad).when().log().all().post(Url);
		} catch (Exception exception) {
			logger.error("post call not invoke: "+exception);

		}
		return null;

	}
	/*
	 * public void post(String Url,Object payLoad,String auth) { try {
	 * 
	 * return RestAssured.given().contentType("application/json").body(payLoad)
	 * .when().log().all().post(Url);
	 * 
	 * 
	 * } catch (Exception exception) {
	 * 
	 * } return null; }
	 */

	public Response put(String Url, Object payLoad) {
		try {
			logger.info("Post call invoked");
			return RestAssured.given().contentType("application/json").body(payLoad).when().log().all().put(Url);
		} catch (Exception exception) {
			logger.error("Put call not invoke: "+exception);
		}
		return null;
		}

	public Response delete(String Url) {
		try {

			logger.info("Delete call invoked");
			return RestAssured.given().contentType("application/json").when().log().all().delete(Url);
		} catch (Exception exception) {
			logger.error("Delete call not invoke: "+exception);
		}
		return null;

	}

}

package com.demo.base;



import org.apache.log4j.Logger;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author:Gomathi.Veeraiah
 * @description : This Class Contains Authentication types
 * 
 */


public class Authentication {
	Logger logger = Logger.getLogger(Authentication.class);

	public RequestSpecification basicauth(String username, String password) {
		try {
			logger.info("credentials invoked: ");
			return RestAssured.given().auth().basic(username, password);
		} catch (Exception exception) {
			logger.info("credentials not invoked: " + exception);
		}
		return null;

	}

	public RequestSpecification bearerToken(String token) {

		try {
			logger.info("Bearer Token invoked: ");
			return RestAssured.given().header("Authentication", "Bearer" + token);
		} catch (Exception exception) {
			logger.error("Bearer Token not invoke: " + exception);

		}
		return null;

	}

	public RequestSpecification apiKeyAuth(String key, String value) {

		try {
			logger.info("APIkey Auth invoked: ");
			return RestAssured.given().queryParam(key, value);
		} catch (Exception exception) {
			logger.error("APIkey Auth not invoke: " + exception);

		}
		return null;

	}

	public RequestSpecification digest(String username, String password) {

		try {
			logger.info("Digest Auth invoked: ");
			return RestAssured.given().auth().basic(username, password);
		} catch (Exception exception) {
			logger.error("Digest Auth not invoke: " + exception);

		}
		return null;

	}

	public RequestSpecification oAuth(String clinetId, String clinetSceretId, String accessToken) {

		try {
			logger.info("OAuth invoked: ");
			Response oAuthResponse = RestAssured.given().auth().preemptive().basic(clinetId, clinetSceretId)
					.param("grant_type", "client_credentials")
					.param("Callback_URL", "https://oauth.pstmn.io/v1/browser-callback").post(accessToken);
			String accessTokenResponse = oAuthResponse.jsonPath().getString("acess_token");
			logger.info("oAuth invoke: " + accessTokenResponse);
			return RestAssured.given().auth().oauth2(accessTokenResponse);
		} catch (Exception exception) {
			logger.error("OAuth not invoke: " + exception);
		}
		return null;

	}

}

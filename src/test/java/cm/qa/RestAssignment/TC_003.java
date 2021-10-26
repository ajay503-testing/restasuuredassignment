package cm.qa.RestAssignment;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC_003 extends Tc_002{

	
	@Test
	public void createNewUser() {
		// http://rest-api.upskills.in/api/rest_admin/login

		RestAssured.baseURI = "http://rest-api.upskills.in/api/rest_admin/customers/limit/10/page/1";

		Map<String, Object> headerMap = new HashMap<String, Object>();

		headerMap.put("accept", "application/json");
		headerMap.put("Authorization", BeareraccessToken);
	
		/*
		Map<String, Object> headerMap1 = new HashMap<String, Object>();

		headerMap1.put("limit","10");
		headerMap1.put("page","1");*/
		
		
		String response=given().headers(headerMap).when().get().then().extract().response().asString();

		System.out.println(response);
	
	}
}
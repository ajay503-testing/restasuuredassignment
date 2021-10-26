package cm.qa.RestAssignment;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import UtilityModels.TC_002_POJO;
import io.restassured.RestAssured;

public class Tc_002 extends AccessToken {

	@BeforeMethod
	public void adminLogin() {
		// http://rest-api.upskills.in/api/rest_admin/login

		RestAssured.baseURI = "http://rest-api.upskills.in/api/rest_admin/login";

		Map<String, Object> headerMap = new HashMap<String, Object>();

		headerMap.put("accept", "application/json");
		headerMap.put("Authorization", BeareraccessToken);
		headerMap.put("Content-Type", "application/json");
		TC_002_POJO body = new TC_002_POJO();
		body.setUsername("upskills_admin");
		body.setPassword("Talent4$$");

		String response = given().headers(headerMap).body(body).when().post().then().extract().response().asString();

		System.out.println(response);

		
	}

}

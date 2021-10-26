package cm.qa.RestAssignment;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccessToken {

	public static String BeareraccessToken;
	
	public static String authvalue="Basic dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=";

	@BeforeClass
	public static String getToken() {
		RestAssured.baseURI = "http://rest-api.upskills.in/api/rest_admin/oauth2/token/client_credentials";

		String response = given().header("Authorization",
				authvalue)
				.param("grant_type ", "client_credentials").when().post().then().extract().response().asString();

		System.out.println(response);

		String jsonBody[] = response.split("\"data\":");

		System.out.println(jsonBody[1]);

		JsonPath path = new JsonPath(jsonBody[1]);

		String accessToken = path.get("access_token");
		System.out.println(accessToken);
		BeareraccessToken = "Bearer" + " " + accessToken;
		System.out.println(BeareraccessToken);

		return BeareraccessToken;
	}

	@AfterClass
	public static void logOut() {
		// http://rest-api.upskills.in/api/rest_admin/logout
		RestAssured.baseURI = "http://rest-api.upskills.in/api/rest_admin/logout";

		Map<String, Object> headerMap = new HashMap<String, Object>();

		headerMap.put("accept", "application/json");
		headerMap.put("Authorization", BeareraccessToken);
		String response = given().headers(headerMap)
				.when().post().then().extract().response().asString();

		System.out.println(response);
	}

}

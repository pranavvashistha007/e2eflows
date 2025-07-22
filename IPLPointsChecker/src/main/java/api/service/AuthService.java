package api.service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class AuthService {
	
	public static void main(String args[]) {
		
		AuthService self = new AuthService ();
		
		System.out.println(self.getBearerToken());
		
		System.out.println(self.getCsrfToken(self.getBearerToken()));
	}
	
	public String getBearerToken() {
		
	RestAssured.baseURI = "https://reqres.in";

    // Correct payload (no need for String.format here)
    String payload = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

    // Make the request

	Response response = given()
            .contentType(ContentType.JSON)
            .header("x-api-key", "reqres-free-v1")
            .body(payload)
    .when()
            .post("/api/login");

    // Optional: print for debugging
    //System.out.println("Status Code: " + response.getStatusCode());
    //response.prettyPrint();

    // Extract token from JSON response
    return response.jsonPath().getString("token");
    }
	
	
	  public String getCsrfToken(String bearerToken) {

			
			
		    return "csfr "+bearerToken;
	    }
	

}

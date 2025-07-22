package pages;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;



public class LoginApi {
	
	private String baseUri ;
	
	
	
	public Response  sendLoginRequest(String email , String password) {
		String payload = String.format("{ \"email\": \"%s\", \"password\": \"%s\" }", email, password);
		
		return  RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("x-api-key", "reqres-free-v1") 
                .body(payload)
                .post("/api/login");
		
	}
}

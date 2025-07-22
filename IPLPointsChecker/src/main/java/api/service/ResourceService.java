package api.service;

import api.pojo.Resource;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class ResourceService {

	//private static final String BASE_URI = "https://api.restful-api.dev";

	public Response createResource(Resource requestBody, String bearerToken, String csrfToken) {
		
		//Resource requestBody = new Resource("Pranav", "SDET");
		
		
		//RestAssured.baseURI = BASE_URI;
		
		RestAssured.baseURI = "https://reqres.in";

		Response response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + bearerToken)
                .header("x-csrf-token", csrfToken) // even if mocked
                .header("x-api-key", "reqres-free-v1") // still needed
                .body(requestBody)
        .when()
                .post("/api/users")
        .then()
                .log().all()
                .statusCode(201)
                .extract().response();

        System.out.println("✅ User Created with ID: " + response.jsonPath().getString("id"));
        return response ;
    }

}

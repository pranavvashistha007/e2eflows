package api.pojo;
import java.util.Map;

import io.restassured.path.json.JsonPath;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class TestParse {
	
	
	 
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		
		//String json = "{ \"user\": { \"name\": \"Pranav\", \"age\": 30 } }";
		String json = "{ \"user\": { \"name\":\"Pranav\"}} ";

		JsonPath jp = new JsonPath(json);
		String name = jp.getString("user.name");
	//	int age = jp.getInt("user.age");

		//Assert.assertEquals(name, "Pranav");
		//Assert.assertTrue(age > 18);
		
		System.out.println(name + " " + name);
		
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});

	//	Assert.assertEquals(map.get("status"), "success");
		
		
		System.out.println(  map.get("user").toString()  );
	}

}

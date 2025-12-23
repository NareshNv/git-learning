package restaplearn;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIGet {
	
	@Test(enabled = false)
	public void getElementAPI() {
		
		RestAssured.baseURI="https://api.restful-api.dev/";
		RequestSpecification request = RestAssured.given();
		Response res = request.request(Method.GET,"objects");
		System.out.println("Pretty string "+  res.asPrettyString());
		System.out.println("Content type "+ res.contentType());
		System.out.println("Status code "+ res.getStatusCode());
		System.out.println("Status line "+ res.getStatusLine());
	}
	
	@Test (enabled = false)
	public void postElementAPI() { 
		RestAssured.baseURI="https://api.restful-api.dev/";
		RequestSpecification post = RestAssured
				.given()
				.header("Content-Type","application/json")
				.body("{\r\n" +
						"   \"name\": \"Apple MacBook Pro 16\",\r\n" +
						"   \"data\": {\r\n" +
						"      \"year\": 2019,\r\n" +
						"      \"price\": 1849.99,\r\n" +
						"      \"CPU model\": \"Intel Core i9\",\r\n" +
						"      \"Hard disk size\": \"1 TB\"\r\n" +
						"   }\r\n" +
						"}");
		Response post1 = post.request(Method.POST,"objects");
		System.out.println("Pretty string "+  post1.asPrettyString());
		System.out.println("Content type "+ post1.contentType());
		System.out.println("Status code "+ post1.getStatusCode());
		System.out.println("Status line "+ post1.getStatusLine());
		
	}
	
	@Test
	public void putElementAPI() {
		RestAssured
		.given()
			.baseUri("https://api.restful-api.dev/")
			.header("Content-Type","application/json")
			.body("{\r\n" +
					"      \"price\": 9999,\r\n" +
					"   }\r\n" +
					"}")
			.when()
				.put("objects/7")
					.prettyPrint();
	}
}


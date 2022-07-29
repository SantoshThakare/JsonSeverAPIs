package JsonServerAPIs.ServerAPIs;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonServerAPITest {
	@Test(priority = 0)
	public void test_get_all_request() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
//		
		Response response = requestSpecification.request(Method.GET, "http://localhost:3000/posts/");
//		
		response.prettyPrint();
//		
//		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
		@Test(priority = 1)
		public void test_create_post() {
			RequestSpecification requestSpecification = RestAssured.given();
			requestSpecification.accept(ContentType.JSON);
			requestSpecification.contentType("application/json");
			requestSpecification.body(" { \"id\": 15, \"title\": \"json-server13\", \"author\": \"Santosh13\" }");
			
			Response response = requestSpecification.request(Method.POST, "http://localhost:3000/posts/");
			
			response.prettyPrint();
			
			
			int statusCode = response.statusCode();
			Assert.assertEquals(statusCode, 201);
		}

	
	@Test(priority = 2)
	public void test_update_post() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.body(" { \"id\": 15, \"title\": \"json-server15\", \"author\": \"Santosh15\" }");
		
		Response response = requestSpecification.request(Method.PUT, "http://localhost:3000/posts/15");
		
		response.prettyPrint();
		
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	
	@Test(priority = 4)
	public void test_delete_post() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		Response response = requestSpecification.request(Method.DELETE, "http://localhost:3000/posts/15");
		
		response.prettyPrint();
		
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test(priority = 3)
	public void test_patch_post() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.body(" { \"id\": 15, \"title\": \"json-server22\", \"author\": \"Santosh15\" }");
		
		Response response = requestSpecification.request(Method.PATCH, "http://localhost:3000/posts/15");
		
		response.prettyPrint();
		
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	

}

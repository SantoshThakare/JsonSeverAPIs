package JsonServerAPIs.ServerAPIs;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonServerCommentsAPITest {
	
	@Test(priority = 0)
	public void test_get_all_comment() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		
		Response response = requestSpecification.request(Method.GET, "http://localhost:3000/comments");
		
		response.prettyPrint();
		
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test(priority = 1)
	public void test_add_comment() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.body(" { \"id\": 8, \"body\": \"bridgelabz comment\", \"postId\": 8}");
		
		Response response = requestSpecification.request(Method.POST, "http://localhost:3000/comments");
		
		response.prettyPrint();
		
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 201);
	}
	
	@Test(priority = 2)
	public void test_update_comments() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.body(" {\r\n"
				+ "    \"id\": 6,\r\n"
				+ "    \"body\": \"Hi Friends Godd Afternoon6\",\r\n"
				+ "    \"postId\": 6\r\n"
				+ "}");
		
		Response response = requestSpecification.request(Method.PUT, "http://localhost:3000/comments/6");
		
		response.prettyPrint();
		
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 3)
	public void test_delete_comments() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		Response response = requestSpecification.request(Method.DELETE, "http://localhost:3000/comments/6");
		
		response.prettyPrint();
		
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority = 4)
	public void test_patch_comments() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.body("{\"body\": \"bridgelabz comment7\"}");
		
		Response response = requestSpecification.request(Method.PATCH, "http://localhost:3000/comments/7");
		
		response.prettyPrint();
		
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	

}

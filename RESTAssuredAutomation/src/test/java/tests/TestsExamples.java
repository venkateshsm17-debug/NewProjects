package tests;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TestsExamples {
	
	
	@Test
	public void test_1() {
		
		//Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		Response response=get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode()); 
		System.out.println(response.getTime());
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	@Test
	public void test_2() {
		baseURI= "https://reqres.in/api";
		given().header("x-api-key", "reqres-free-v1").
		get("/users?page=2").then().statusCode(200)
		.body("data[1].id",equalTo(8))
		.log().all();

		
	}

}

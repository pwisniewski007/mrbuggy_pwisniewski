package net.petrikainulainen.junit5;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import org.junit.jupiter.api.*;
import org.hamcrest.Matchers;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JUnit5NestedExampleTest {



	@Test
	public void simple_get_test() {
		
   given().queryParam("CUSTOMER_ID","68195")
           .queryParam("PASSWORD","1234!")
           .queryParam("Account_No","1")
           .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
           .body();
	}
	@Test
	public void test2()
	{
		int statusCode= given().queryParam("CUSTOMER_ID","68195")
           .queryParam("PASSWORD","1234!")
           .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
   System.out.println("The response status is "+statusCode);

   given().when().get(url).then().assertThat().statusCode(200);
	}
}
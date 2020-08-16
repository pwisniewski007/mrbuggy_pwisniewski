package net.petrikainulainen.junit5;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.get;

import static org.hamcrest.Matchers.hasItems;

import org.junit.jupiter.api.*;
import org.hamcrest.Matchers;

import org.json.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JUnit5NestedExampleTest {

	private static final String URL_GET = "http://localhost:8080";


	@Test
	public void testGetUsers()
	{
		String result = given().headers(
				"Authorization", "cHJ6ZW1lazI=:UHJ6ZW1lazEyMyE=",
				"Accept", "application/json",
				"Content-Type","application/x-www-form-urlencoded")
				.when()
				.get(URL_GET + "/user")
				.then()
				.statusCode(200)
				.extract()
				.asString();
		System.out.println(result);
	}

	@Test
	public void testPostAdmin()
	{

		String response = given()
				//				.urlEncodingEnabled(true)
				.param("username", "przemek32")
				.param("first_name", "Testowy")
				.param("last_name", "User")
				.param("email", "test321218@test.com")
				.param("phone_number", "+48981232853")
				.param("password", "tajnehaslo9$")
				.headers(
						"Authorization", "cHJ6ZW1lazI=:UHJ6ZW1lazEyMyE=",
						"Accept", "application/json",
						"Content-Type", "application/x-www-form-urlencoded")
				.when()
				.post(URL_GET + "/user/admin")
				.then().statusCode(200)
				.extract()
				.asString();
		System.out.println(response);
	}

	@Test
	public void editUser()
	{

		String response = given()
				.contentType(ContentType.URLENC)
				.formParam("username", "przemek323")
				.formParam("first_name", "przemyslaw")
				.formParam("last_name", "UserZmieniony")
				.formParam("email", "jakisemail@o2.pl")
				.formParam("phone_number", "333444555")
				.formParam("password", "password123!")
				.headers(
						"Authorization", "cHJ6ZW1lazI=:UHJ6ZW1lazEyMyE=",
						"Accept", "application/json",
						"Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"
				)
				.when()
				.put( URL_GET + "/user/5")
				.then()
				.extract()
				.asString();

		System.out.println(URL_GET + "/user/5");
		System.out.println(response);
	}
}
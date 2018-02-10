package com.ing.technicaltest.integrationtest;



import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.technicaltest.entity.Currency;

import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoIntegrationTest {

	@LocalServerPort 
    int port;
	
	@Test
	public void test_200_DemoScenario() {
		given().
			port(port).
		when().
			get("/1/account").
		then().
			statusCode(200).
			contentType(ContentType.JSON).
			and().
			body("id", hasItems(1,2,3,4)).
			and().
			body("amount", hasSize(4)).
			and().
			body("currency", not(hasItem(Currency.CNY))).
			and().
			body("name", hasItems("Main Account",
								  "Credit Card", 
								  "US Deposit", 
								  "Swiss Deposit"));
	}
	
	@Test
	public void test_404_UserNotPresent() {
		given().
			port(port).
		when().
			get("/2/account").
		then().
			statusCode(404);
	}
	
	@Test
	public void test_405_post_not_allowed() {
		given().
			port(port).
		when().
			post("/1/account").
		then().
			statusCode(405);
	}

	@Test
	public void test_405_put_not_allowed() {
		given().
			port(port).
		when().
			put("/1/account").
		then().
			statusCode(405);
	}
	
	@Test
	public void test_405_delete_not_allowed() {
		given().
			port(port).
		when().
			delete("/1/account").
		then().
			statusCode(405);
	}
}

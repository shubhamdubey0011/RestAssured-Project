package com.valtech.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.testng.annotations.Test;

public class RestAssuredDemo {

	@Test
	public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {

		given().when().get("http://ergast.com/api/f1/2017/circuits.json").then().assertThat()
				.body("MRData.CircuitTable.Circuits.circuitId", hasSize(20));
	}

	@Test
	public void test_ResponseHeaderData_ShouldBeCorrect() {

		given().when().get("http://ergast.com/api/f1/2017/circuits.json").then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().header("Content-Length", equalTo("4551"));
	}

	
	@Test
	public void test_Md5CheckSumForTest_ShouldBe098f6bcd4621d373cade4e832627b4f6() {

		String username = "shubham.dubey";
		String password = "123456";

//		given().auth().form(username, password).when().get().then().assertThat().statusCode(200);
		
		given().auth().basic(username, password).when().get("http://10.12.40.220/login").then().statusCode(200);
	}

}

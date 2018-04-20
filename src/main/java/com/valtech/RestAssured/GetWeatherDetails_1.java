package com.valtech.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GetWeatherDetails_1 
{

	@Test
	public void verifyWeatherDetails_statusCode()
	{
		
		RestAssured.baseURI="http://qas.qmetry.com/struts2-rest-showcase-2.3.16.3/orders";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/52.json");
		int statuscode = response.getStatusCode();
		System.out.println("StatusCode ::"+statuscode);
		Assert.assertEquals(statuscode , 200 , "Correct status code returned");
		 String statusLine = response.getStatusLine();
		 System.out.println(" StatusLine ::"+statusLine);
		 Assert.assertEquals(statusLine , "HTTP/1.1 200 " , "Correct status line returned");
		 
		
		
	}
	
	
}

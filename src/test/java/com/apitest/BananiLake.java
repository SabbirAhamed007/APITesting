package com.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BananiLake {

	@Test

	void getweatherDetails() {

		// Specify base URI

		RestAssured.baseURI = "https://buyrentbd.com";

		// Request object
		RequestSpecification httprequest = RestAssured.given();

		// Response object

		Response response = httprequest.request(Method.GET, "/property/বনানী-লেক-পাড়ে-১০-তলা-বিশি");

		// Print response in console window

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

		// Status code validation

		int statusCode = response.getStatusCode();
		System.out.println("status code is: " + statusCode);
		Assert.assertEquals(statusCode, 200);

		// Status line verification

		String statusLine = response.getStatusLine();
		System.out.println("Status Line is: " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

}

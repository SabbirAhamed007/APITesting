package com.apitest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Request {

	@Test

	void getweatherDetails() {

		// Specify base URI

		RestAssured.baseURI = "https://reqres.in/api";

		// Request object
		RequestSpecification httprequest = RestAssured.given();

		// Request payload sending along with post request

		JSONObject requestParams = new JSONObject();

		requestParams.put("name", "morpheus");
		requestParams.put("job", "leader");

		httprequest.header("Content_Type", "application/json");

		httprequest.body(requestParams.toJSONString());

		// Response object

		Response response = httprequest.request(Method.POST, "/users");

		// Print response in console window

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

		// Status code validation

		int statusCode = response.getStatusCode();
		System.out.println("status code is: " + statusCode);
		Assert.assertEquals(statusCode, 201);

		// Status line verification

		String statusLine = response.getStatusLine();
		System.out.println("Status Line is: " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
		
		
		

	}

}

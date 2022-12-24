package webServicesTestCases;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC2_POST_Request {
	@Test
	public void getWeatherDetails()
	{
		//url
		RestAssured.baseURI="https://reqres.in/api";
		
		//post request payload in json format
		JSONObject requestParams=new JSONObject();
		requestParams.put("name", "Reka");
		requestParams.put("job","Narayanasamy");
		String payload=requestParams.toString();	
		System.out.println(payload);
		
		//get request
		RequestSpecification request=RestAssured.given();
		request.header("content-Type","application/json");
		request.body(requestParams.toJSONString());
		
		Response response=request.post("/users");
		
		//extract body from response
		String responsebody=response.getBody().asString();
		System.out.println("ResponseBody of the get request"+ responsebody);
		
		//extract Response statusCode
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		
		//validation
        //response status code
	    Assert.assertEquals(statuscode,201);
	    //response success code
	    //String successCode=response.jsonPath().get("SuccessCode");
	    //Assert.assertEquals(successCode,"OPERATION_SUCCESS");
	    
	    
	}
}

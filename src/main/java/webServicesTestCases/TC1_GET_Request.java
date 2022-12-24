package webServicesTestCases;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class TC1_GET_Request
{
	@Test
	public void getWeatherDetails()
	{
		//url
		RestAssured.baseURI="https://restcountries.com/v3.1/capital";
		//get request
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/Delhi");
		//extract body from response
		String responsebody=response.getBody().asString();
		System.out.println("ResponseBody of the get request"+ responsebody);
		//extract statusCode
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		//capture status line
		//String statusline=response.getStatusLine();
		//System.out.println(statusline);
		//validation
		//Assert.assertEquals(statusline, "HTTP/1.1 200OK ");
	    Assert.assertEquals(String.valueOf(statuscode),"200");
	}
}

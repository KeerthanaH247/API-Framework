package stepDefinations;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import resources.TestBuilder;
import resources.Utils;

import static org.junit.Assert.*;

public class StepDefinition extends Utils{

	ResponseSpecification resspec ;
	RequestSpecification res;
	RequestSpecification req;
	Response response;
	TestBuilder data=new TestBuilder();
	
@Given("Add place payload")
public void add_place_payload() {
	
	 resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	 res=given().spec(requestSpecification()).body(data.addPlacePayload());
	 //data is driven from test data class
}
@When("User calls {string} with POST http request")
public void user_calls_with_post_http_request(String string) {
	 response=res.when().post("/maps/api/place/add/json")
				.then().spec(resspec).extract().response();

}
@Then("the API call got success with status code {int}")
public void the_api_call_got_success_with_status_code(Integer int1) {
	
	assertEquals(response.getStatusCode(),200);
	
}
@Then("{string} in response body is {string}")
public void in_response_body_is(String keyValue, String ExpectedValue) {
	String resp=response.asString();
	JsonPath js=new JsonPath(resp);
	assertEquals(js.get(keyValue).toString(), ExpectedValue);
}




}

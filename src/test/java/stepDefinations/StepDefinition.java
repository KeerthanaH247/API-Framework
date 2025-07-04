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
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import static org.junit.Assert.*;

public class StepDefinition {

	ResponseSpecification resspec ;
	RequestSpecification res;
	RequestSpecification req;
	Response response;
	
@Given("Add place payload")
public void add_place_payload() {
	AddPlace p=new AddPlace();
	p.setAccuracy(50);
	p.setAddress("29, side layout, cohen 09");
	p.setLanguage("French-IN");
	p.setPhone_number("(+91) 983 893 3937");
	p.setWebsite("http://google.com");
	p.setName("Frontline house");
	List<String> myList=new ArrayList<String>();
	myList.add("shoe park");
	myList.add("shop");
	p.setTypes(myList);
	pojo.Location l=new pojo.Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	p.setLocation(l);
	 req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
	.setContentType(ContentType.JSON).build();
	 resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	 res=given().spec(req).body(p);

}
@When("User calls AddPlaceAPI with POST http request")
public void user_calls_add_place_api_with_post_http_request() {

	 response=res.when().post("/maps/api/place/add/json")
			.then().spec(resspec).extract().response();

}
@Then("the API call got success with status code {int}")
public void the_api_call_got_success_with_status_code(Integer int1) {
	String resp=response.asString();
	assertEquals(0, 0);
	response.getStatusCode()
}
@Then("status in response body is OK")
public void status_in_response_body_is_ok() {

}


}

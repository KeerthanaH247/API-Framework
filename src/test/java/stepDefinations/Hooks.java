package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		//Execute this code only when Place_id is null
		//Write a code that will give us Place_id 
		StepDefinition m=new StepDefinition();
		if(StepDefinition.place_id==null)
		{
		m.add_place_payload_with("Keer", "English", "Asia");
		m.user_calls_with_post_http_request("AddPlaceAPI", "POST");
		m.verify_place_id_created_maps_to_using("Keer", "GetPlaceAPI");
		}
	}
}

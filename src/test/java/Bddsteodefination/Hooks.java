package Bddsteodefination;

import java.io.IOException;

import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void beforescenario() throws IOException
	{
		
		
		Apistepdef app= new Apistepdef();
	     if(app.PlaceId==null)	
	     {
		app.add_Place_Payload_With("Sourabh","Marathi", "Pune");
		app.user_calls_with_http_request("AddPlaceAPI","Post");
	     }
	}
	
}

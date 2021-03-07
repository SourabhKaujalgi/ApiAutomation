package resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.DeletePlace;
import Pojo.Root;

public class TestDataBuild {
	
	public Root addPlacePayload(String name,String language,String address)
	{
		List<String> types=new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		
		Pojo.Location location=new Pojo.Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		
		Pojo.Root r=new Pojo.Root();
		r.setLocation(location);
		r.setAccuracy(60);
		r.setName(name);
		r.setPhone_number("(+91) 983 893 3937");
		r.setAddress(address);
		r.setTypes(types);
		r.setWebsite("http://google.com");
		r.setLanguage(language);
		return r;
	}

	
	public DeletePlace deleteplace(String Placeid)
	{
		Pojo.DeletePlace deleplace= new Pojo.DeletePlace();
		deleplace.setPlace_id(Placeid);
		return deleplace;
		
				
	}
	
}

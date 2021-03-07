package resources;
//Speacial class in java wich have collection of contstants and Methods
public enum APIresources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceApi("/maps/api/place/get/json"),
	deletePlaceAPi("/maps/api/place/delete/json");
	private String resource;
	
	
	APIresources(String resource)
	{
		this.resource=resource;
	}
   public String getResource()
   {
	   return resource;
   }
}

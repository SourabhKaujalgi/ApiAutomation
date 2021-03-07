Feature: Validating Place API 



 @AddPlace
Scenario Outline: Verify if place added using Add place API 

Given Add Place Payload With "<name>" "<launguage>" "<address>"
When user calls "AddPlaceAPI" with "Post" http request 
Then the API call is sucess with status code 200 
And "status" in reponse body is "OK"
And "scope" in reponse body is "APP"
And verify place_id created maps to to "<name>" using "getPlaceApi" 
Examples: 
 | name  | launguage | address                   |
 |skhouse|English    |Wolrd Calss Center         |
 |Akhouse|Freanch    |Wolrd Calss Center France  |
 
 
 
 @DeletePlace	
Scenario: 
Given Delete Place Payload
When user calls "deletePlaceAPi" with "Post" http request 
Then the API call is sucess with status code 200 


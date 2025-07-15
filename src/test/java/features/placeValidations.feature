Feature: Validating Place API's

@AddPlace
Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI

Given Add place payload with "<name>" "<language>" "<address>"
When User calls "AddPlaceAPI" with "POST" http request
Then the API call got success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And Verify place_Id created maps to "<name>" using "GetPlaceAPI"
When User calls "GetPlaceAPI" with "GET" http request
When User calls "DeletePlaceAPI" with "DELETE" http request

Examples:
| name | language | address |
| Alex | English | World cross center |
#| Keer | Kannada | Tumkur |

@DeletePlace
Scenario: Verify if Delete place functionality is working

Given DeletePlace Payload
When User calls "DeletePlaceAPI" with "POST" http request
Then the API call got success with status code 200
And "status" in response body is "OK"


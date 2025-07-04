Feature: Validating Place API's

Scenario: Verify if Place is being Successfully added using AddPlaceAPI

Given Add place payload
When User calls "AddPlaceAPI" with POST http request
Then the API call got success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"


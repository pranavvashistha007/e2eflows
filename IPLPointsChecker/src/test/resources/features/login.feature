Feature: Login API

  @api
  Scenario: Valid login should return auth token
    Given I set the base URI to "https://reqres.in"
    When I login with valid credentials
    Then the response status code should be 200
    And the response should contain a token

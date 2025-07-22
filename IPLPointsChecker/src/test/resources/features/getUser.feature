Feature: Get User Details

  @apiSkip
  Scenario: Retrieve user information by ID
    Given I set the base URI to "https://reqres.in"
    When I retrieve user details for ID 2
    Then the response status code should be 200
    And the response should contain the user's email

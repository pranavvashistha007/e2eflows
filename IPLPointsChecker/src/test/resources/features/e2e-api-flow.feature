@api
Feature: Post a resource using authentication and CSRF in a secure flow
@api
  Scenario: Authenticated user posts a new resource with nested JSON payload
    Given the user retrieves a bearer token
    And the user retrieves a CSRF token
    When the user sends a POST request with a nested JSON payload
    And the response body should match the request payload

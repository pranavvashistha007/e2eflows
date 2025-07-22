@smoke
Feature: Validate winning team details

  @smoke
  Scenario Outline: Get IPL "<year>" final winner and validate points, wins, and losses
    Given I open the IPL website homepage
    Then the IPL logo should be visible
    And the page load should be complete
    When I select the Points Table from the mega menu
    Then the Points Table page is displayed
    When I select the Playoffs tab from the Points Table page
    Then the latest Playoffs section is displayed
    When I select the year "<year>" from the dropdown
    Then the Playoffs section for "<year>" is displayed
    When I extract the winning team name
    And I extract the final match location and date
    And I navigate to the Points Table section again
    Then the Points Table section is displayed
    When I find the winning team's row from the table using the previously stored name
    And I extract the winning team's points, wins, and losses based on the row
    Then the validation is complete
    
   Examples: 
      | year |
      | 0226 |
      
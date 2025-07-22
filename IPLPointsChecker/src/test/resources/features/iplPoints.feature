#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@smoke
Feature: IPL 2023 Points Table Scraper
  As a cricket fan,
  I want to view all IPL 2023 team names and their respective points,
  So that I can know how teams are performing.

  @smoke
  Scenario: Fetch all team names and points from the IPL 2023 points table
    Given  I open the IPL 2023 points table webpage
    
    When I extract the team names and their respective points
    Then I store them in a HashMap

    And I display the contents of the HashMap on the console

  
@datatable @smoketest
Feature: Single data table
  Scenario Outline: TC01_google seach test
    Given user is on the google page
    And user searches for "<value>"
    Then verify the result has "<value>"
    Examples: Test Data
    |value    |
    |iphone   |
    |istanbul |
    |apple    |
    |orange   |
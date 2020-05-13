@wip1
Feature: fluent wait demo
  Scenario: fluent wait scenario
    Given user is on the demo page
    And user clicks on the Start button
    And user waits fluently until the page loads and verify the text message

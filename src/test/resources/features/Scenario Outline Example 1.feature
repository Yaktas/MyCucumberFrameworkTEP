@datatable4 @regression
Feature: scenario outline example
  Scenario: testing the data tables web page
    Given user is on the datatables
    And user clicks on new button
    And user enters firstname "first name"
    And user enters lastname "last name"
    And user enters position "QA"
    And user enters office "London"
    And user enters extension "555"
    And user enters startdate "2020-05-06"
    And user enters salary "90000"
    And clicks create button
    And user enters firstname "first name" to the searchbox
    Then verify that user see the first name "first name" in the searchbox
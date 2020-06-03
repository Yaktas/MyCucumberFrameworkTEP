@db
Feature:

  Background: user is on the google page
    Given user connects to the database

  Scenario: TC01_User verified the table data
    And user connects the Book Table
    And prints the first value on BookName
    And print the BookName values on the Book Table
    And print the total row count
    And verify the 5th value is Java
    And verify the 1st value is SQL
    And verify the last value is UIPath

@FHClogin @smoketest
Feature: login feature

  Scenario: TC01_user should login with manager credentials
    Given user is on the fhctriplogin page
    And user enter valid manager username
    And user enter valid manager password
    And user clicks on login button
    Then verify the manager login is successful
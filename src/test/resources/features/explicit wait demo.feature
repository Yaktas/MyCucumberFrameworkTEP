Feature: Explicit wait demo
  Scenario: Explicit wait example
    Given user is on the demo page
    And user clicks on the Start button
    And user waits until the page loads
    Then verify the Hello World! text is visible
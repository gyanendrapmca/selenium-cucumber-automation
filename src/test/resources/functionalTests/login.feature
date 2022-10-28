Feature: Login Functionality
Description: The purpose of this feature is to cover all login scenario of the application

  Scenario: Verify that user is able to login
    Given User is on login page
    When User enter user name "tomsmith"
    And User enter password "SuperSecretPassword!"
    And User click on Login button
    Then User is able to see successful login message
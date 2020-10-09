Feature: Rightwayautosale main page tests

  Background:
    Given User navigates to 'https://www.rightwayautosale.com/' page


  Scenario: Navigate to the main page and verify web elements
    And Verify that Rightwayautosale logo is displayed
    Then Verify that Rightwayautosale navigation bar is displayed on Main page

  Scenario: Navigate to the main page and click AboutUs option
    When User clicks AboutUs option
    Then Verify that Rightwayautosale navigation bar is displayed on AboutUs page

  Scenario: Navigate to the main page and click ContactUs option
    When User clicks ContactUs option
    Then Verify that Rightwayautosale navigation bar is displayed on ContactUs page
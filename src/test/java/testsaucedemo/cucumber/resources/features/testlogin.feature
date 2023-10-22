Feature: Saucedemo Automation
  Scenario: Success login saucedemo
    Given Saucedemo login page
    When Input username
    And Input password
    And Click login button
    Then User in on dashboard page

  Scenario: Failed login saucedemo
    Given Saucedemo login page
    When Input username
    And Input invalid password
    And click login button
    Then User get error message
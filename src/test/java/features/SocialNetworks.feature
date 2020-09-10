Feature: Social Networks

  Background:
    Given Navigate to http://automationpractice.com/
    And   Click on sign in button
    When  Enter the username and password and click on login button
    Then  User should login successfully

  Scenario Outline: Social Networks Buttons Functionality
    And   Click on "<Social network button>" and verify "<url>"

    Examples:
      | Social network button | url      |
      | facebook              | facebook |
      | twitter               | failStep |
      | youtube               | youtube  |
      | google                | google   |

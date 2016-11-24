@MobileLogin
Feature: This is login feature

  @MobileValid
  Scenario: Testing with valid credentials
    Given Login popup is opened
    When Valid app credentials are entered
    Then HomeScreen should be visible

  @outlineMobileInvalid
  Scenario Outline: Testing with invalid credentials
    Given Login popup is opened
    When invalid app username <username> is entered
    And invalid app password <password> is entered
    Then HomeScreen should not be visible

    Examples: 
      | username | password |
      | test     | 12345678 |
      | shreya   |     1234 |
      
      

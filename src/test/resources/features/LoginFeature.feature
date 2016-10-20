Feature: This is login feature

  @valid
  Scenario: Testing with valid credentials
    Given Login page is opened
    When valid credentials are entered
    Then HomePage should be visible

  @invalid
  Scenario Outline: Testing with invalid credentials
    Given Login page is opened
    When invalid username <username> is entered
    And invalid password <password> is entered
    Then HomePage should not be visible

    Examples: 
      | username | password |
      | vipul    |     5556 |
      | amit     |      756 |

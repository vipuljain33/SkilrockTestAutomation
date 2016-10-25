@login
Feature: This is login feature

  @valid
  Scenario: Testing with valid credentials
    Given Login page is opened
    When valid credentials are entered
    Then HomePage should be visible

  @outline
  Scenario Outline: Testing with invalid credentials
    Given Login page is opened
    When invalid username <username> is entered
    And invalid password <password> is entered
    Then HomePage should not be visible

    Examples: 
      | username | password |
      | vipul    |     5556 |
      | amit     |      756 |

  @invalid
  Scenario: Testing with invalid credentials blank credentials are entered
    Given Login page is opened
    When blank credentials are entered
    Then verify error msg

  @invalid
  Scenario: Testing with invalid credentials only username credentials are entered
    Given Login page is opened
    When only username credentials are entered
    Then verify error msg

  @invalid
  Scenario: Testing with invalid credentials only password credentials are entered
    Given Login page is opened
    When only password credentials are entered
    Then verify error msg

  

  

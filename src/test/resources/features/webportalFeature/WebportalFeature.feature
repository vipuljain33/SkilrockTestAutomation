@WebportalLogin
Feature: login feature for web portal

  @Webportal
  Scenario: valid credentials
    Given login button is selected
    And Username text box display
    When entered valid fields value
    Then Homepage should be visible

  Scenario Outline: Testing with invalid credentials for webportal
    Given login button is selected
    When invalid username <username> is enter
    And invalid password <password> is enter
    Then HomePage should not visible

    Examples: 
      | username | password |
      | vipul    |     5556 |
      | amit     |      756 |

  Scenario: Testing with invalid credentials blank credentials are entered
    Given login button is selected
    When blank username password credentials are entered
    Then validate error msg

  Scenario: Testing with invalid credentials only username credentials are entered
    Given login button is selected
    When only username credential is entered
    Then verify error msg for invalid username credentials

  Scenario: Testing with invalid credentials only password credentials are entered
    Given login button is selected
    When only password credential is entered
    Then verify error msg for invalid password credentials

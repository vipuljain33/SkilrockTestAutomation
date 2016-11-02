@Luckynumber
Feature: Lucky Number Sale

  Background: 
    Given login with valid credentials
    And Draw game option is selected
    And Lucky number game is selected

@drawGame
  Scenario: Validate all bet type display on screen
    Given Active bet types are present in DB
    Then Active bet types are visible

  Scenario: Validate min and maximum number selected for perm1 bet type
    When Perm1 bet type is selected
    And select more than ten numbers
    Then popup error message should display

  Scenario: Validate  minimum and maximum number selected for perm2 bet type
    When Perm2 bet type is selected
    And select numbers less than three and greater than twenty
    Then popup error message should display for greater than twenty numbers
    And buy now should be disabled for less than "3" numbers

  
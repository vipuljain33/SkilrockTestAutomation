@LuckyNumber
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
    When Permone bet type is selected
    And select more than ten numbers
    Then popup error message should display

  Scenario: Validate maximum number selected for perm2 bet type
    When Permtwo bet type is selected
    And select more than twenty numbers
    Then popup error message should display for greater than twenty numbers

  Scenario: Validate maximum number selected for perm3 bet type
    When Permthree bet type is selected
    And select more than twenty numbers for permthree bet type
    Then popup error message for permthree should display

  Scenario: Validate minimum numbers selected for perm2 bet type
    When Permtwo bet type is selected
    And Select numbers less than three
    Then buy now button should be disabled for permtwo

  Scenario: validate minimum number selected for permthree bet type
    When Permthree bet type is selected
    And Select numbers less than four
    Then buy now button should be disabled for permthree

  Scenario: Validate number of boxes for permone bet type
    Given Permone bet type is selected
    Then Number of boxes should be ten

  Scenario: Validate number of boxes for permtwo bet type
    Given Permtwo bet type is selected
    Then Number of boxes should be twenty

  Scenario: Validate number of boxes for permthree bet type
    Given Permthree bet type is selected
    Then Number of boxes should be twenty for permthree

  Scenario: Validate number of lines for permone bet type
    When Permone bet type is selected
    And numbers are picked for permone bet type
    Then number of lines should be ten

  Scenario Outline: Validate No. of lines for perm2 bet type
    When Permtwo bet type is selected
    And selected numbers given <numbers>
    Then Number of lines should be <nolines>

    Examples: 
      | numbers | nolines |
      |      10 |      45 |
      |      15 |     105 |
      |      20 |     190 |

  Scenario Outline: Validate No. of lines for perm3 bet type
    When Permthree bet type is selected
    And selected numbers given <numbers> for permthree
    Then Number of lines should be <nolines> for permthree

    Examples: 
      | numbers | nolines |
      |      10 |     120 |
      |      15 |     455 |
      |      20 |    1140 |


  @test
  Scenario: Validate panel price for permone bet types
    When Permone bet type is selected
    And selected numbers ten are given
    Then total ticket amount should be one

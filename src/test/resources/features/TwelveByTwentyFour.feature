@TwelveByTwentyfour
Feature: TwelveByTwentyfour Sale

  Background: 
    Given login with valid credentials tbtf
    And draw game option is selected tbtf
    Then TwelveByTwentyfour game is selected

  @test2
  Scenario: Validate all bet type display on screen tbtf
    Given Active bet types are present in DB tbtf
    Then Active bet types are visible tbtf

  Scenario: Validate selected numbers for First Twelve bet type
    When First Twelve bet type is selected
    Then one to twelve numbers selected automatically
    And quick pick should be disbale

  Scenario: Validate selected numbers for Last Twelve bet type
    When Last Twelve bet type is selected
    Then Twelve to TwentyFour numbers selected automatically
    And quick pick should be disbale

  Scenario: Validate selected numbers for AllOdd bet type
    When AllOdd bet type is selected for AllOdd bet type
    Then Twelve Odd numbers selected automatically for AllOdd bet type
    And quick pick should be disbale

  Scenario: Validate selected numbers for AllEven bet type
    When AllEven bet type is selected for AllEven bet type
    Then Twelve Even numbers selected automatically for AllEven bet type
    And quick pick should be disbale

  Scenario: Validate selected numbers for OddEven bet type
    When OddEven bet type is selected
    Then Twelve Odd and Even numbers selected automatically for OddEven bet type
    And quick pick should be disbale

  Scenario: Validate selected numbers for EvenOdd bet type
    When EvenOdd bet type is selected
    Then Twelve Even and Odd numbers selected automatically for EvenOdd bet type
    And quick pick should be disbale

  Scenario: Validate selected numbers for JumpEvenOdd bet type
    When JumpEvenOdd bet type is selected
    Then Twelve Even and Oddd numbers selected in pair automatically for JumpEvenOdd bet type
    And quick pick should be disbale

  Scenario: Validate selected numbers for JumpOddEven bet type
    When JumpOddEven bet type is selected
    Then Twelve Even and Odd numbers selected in pair automatically for JumpOddEven bet type
    And quick pick should be disbale

  Scenario: Validate number of boxes for  FirstTwelve
    When select first twelve bet type
    Then Number of boxes should be Twelve for  FirstTwelve

  Scenario: Validate number of boxes for perm Twelve
    When select perm twelve bet type
    Then Number of boxes should be Twelve for perm Twelve

  Scenario: Validate minimum numbers selected for perm Twelve bet type
    When Perm twelve bet type is selected
    And Select numbers less than thirteen
    Then buy now button should be disabled for perm twelve

  Scenario: Validate maximum numbers selected for perm Twelve bet type
    When Perm twelve bet type is selected
    And Select numbers greater than fourteen for tbtf
    Then popup error message for permthree should display for tbtf

  Scenario: Validate quick pick
    When selected bet type is direct twelve
    Then Random number should be selected for direct twelve

  #    Scenario Outline: Validate quick pick for perm Twelve
  #    When Perm twelve is selected
  #    And select <number> for perm twelve
  #    Then Random number should be selected for perm twelve
  #    Examples:
  #      | number |
  #      |     13 |
  #      |     14 |
  @test
  Scenario Outline: Validate No. of lines for perm Twelve bet type
    When Perm Twelve bet type is selected
    And selected numbers given <numbers> for perm Twelve
    Then Number of lines should be <nolines> for perm Twelve

    Examples: 
      | numbers | nolines |
      |      13 |      13 |
      |      14 |      91 |

  Scenario Outline: Validate No. of lines for tbtf
    When select <bettype>
    Then Number of lines should be <nolines> for tbtf

    Examples: 
      | bettype       | nolines |
      | direct twelve |       1 |
      | first twelve  |       1 |

  Scenario: Validate panel price for first twelve bet types
    When first twelve bet type is selected
    And selected numbers twelve are given
    Then total ticket amount should be one for first twelve

  Scenario: Validate advance draw info for tbtf in db
    When Perm twelve bet type is selected
    And Advance draw is selected for perm twelve
    Then draw info should be matched with db

  Scenario: Validate sale for direct twelve using quickpick
    When direct twelve quickpick option is selected
    And buy now button selected
    And popup alert box accepted
    Then ticket should be puchased for direct twelve

  Scenario: Validate ticket number after sale for direct twelve
    When direct twelve ticket purchased
    And ticket preview display for direct twelve
    Then ticket number in preview should be equal to db value

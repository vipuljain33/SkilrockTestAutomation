@MobileLuckyNumber
Feature: Mobile app Lucky Number Sale

  Background: 
    Given User is logged in
    And Draw games icon is selected
    And Lucky numbers game is selected

  @MobileLuckyNumPickNewsaleTest
  Scenario Outline: Validate Perm1 bet type using Pick New
    Given PermOne bet type and Pick New is selected
    And numbers <numPicked> are picked
    When number of lines selected are <noOfLines> and NumberSelected <numberSelected> and increase betAmount by <clickBetAmt>
    Then PurchaseAmt $ <amount>
    And Purchased ticket is generated

    Examples: 
      | numPicked | noOfLines | numberSelected | clickBetAmt | amount |
      |        10 |        10 |             10 |           2 |   3.00 |

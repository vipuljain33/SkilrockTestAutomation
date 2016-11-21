@MobileLuckyNumber
Feature: Mobile app Lucky Number Sale

  Background: 
    Given User is logged in
    And Draw games icon is selected
    And Lucky numbers game is selected

  @MobileLuckyNumPickNewsaleTest
  Scenario Outline: Validate Perm1 bet type using Pick New
    Given PermOne bet type and Pick New is selected
    And numbers <numberSelected> are picked
    When Number of lines selected are <noOfLines>
    Then betAmount <clickBetAmt> and NumberPicked <numPicked> and PurchaseAmt $<amount>
    And Purchased ticket is generated

    Examples: 
      | numberSelected | clickBetAmt | numPicked | noOfLines | amount |
      |             10 |           2 |        10 |        10 |   3.00 |

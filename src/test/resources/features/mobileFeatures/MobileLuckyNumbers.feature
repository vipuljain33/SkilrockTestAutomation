@MobileLuckyNumber
Feature: Mobile app Lucky Number Sale

  Background: 
    Given User is logged in
    And Draw games icon is selected
    And Lucky numbers game is selected

  @MobileLuckyNumberDBValidate
  Scenario: Validate all bet type display on screen
    Given Active bet types in app are present in DB
    Then Active bet types are visible in app

  @MobileLuckyNumberGamePlayValidate
  Scenario Outline: Validate ticket is not generated when less than minimum nos are selected for bet types
    When <betType> bet type and Pick New is selected
    And <numPicked> numbers are picked
    Then Ticket should not be generated

    Examples: 
      | betType | numPicked |
      | Perm1   |         9 |
      | Perm2   |         4 |
      | Perm3   |         4 |

  Scenario Outline: Validate No. of lines , Numbers selected & Final Amount in all bet types using Quick Pick
    Given <betType> bet type and Quick Pick is selected
    And <clickQpNumPicked> qp numbers are picked
    When number of lines selected are <noOfLines> and NumberSelected <numberSelected> and bet type is <betType>
    Then PurchaseAmt $ <amount>

    Examples: 
      | betType | clickQpNumPicked | numberSelected | noOfLines | amount |
      | Perm1   |                0 |             10 |        10 |   1.00 |
      | Perm2   |                0 |              5 |        10 |   1.00 |
      | Perm3   |                5 |             10 |       120 |  12.00 |
      | Perm3   |               15 |             20 |      1140 | 114.00 |

  @MobileLuckyNumberGamePlayValidate
  Scenario Outline: Validate No. of lines , Numbers selected & Final Amount in all bet types using Pick New
    Given <betType> bet type and Pick New is selected
    And <numberSelected> numbers are picked
    When number of lines selected are <noOfLines> and NumberSelected <numberSelected> and bet type is <betType>
    Then PurchaseAmt $ <amount>

    Examples: 
      | betType | numberSelected | noOfLines | amount |
      | Perm1   |             10 |        10 |   1.00 |
      | Perm2   |             10 |        45 |   4.50 |
      | Perm2   |             20 |       190 |  19.00 |
      | Perm3   |              5 |        10 |   1.00 |

  @MobileLuckyNumQuickPickSale
  Scenario Outline: Validate sale for Perm1, Perm2 and Perm3 bet types using Quick Pick
    Given <betType> bet type and Quick Pick is selected
    And <clickQpNumPicked> qp numbers are picked
    When number of lines selected are <noOfLines> and NumberSelected <numberSelected> and bet type is <betType>
    And increase betAmount by <clickBetAmt>
    Then PurchaseAmt $ <amount>
    And Purchased ticket is generated

    Examples: 
      | betType | clickQpNumPicked | numberSelected | noOfLines | clickBetAmt | amount |
      | Perm1   |                0 |             10 |        10 |           0 |   1.00 |
      | Perm1   |                0 |             10 |        10 |           5 |   6.00 |
      | Perm2   |                0 |              5 |        10 |           2 |   3.00 |
      | Perm2   |               15 |             20 |       190 |           1 |  38.00 |
      | Perm3   |                0 |              5 |        10 |           3 |   4.00 |
      | Perm3   |               15 |             20 |      1140 |           0 | 114.00 |

  @MobileLuckyNumPickNewSale
  Scenario Outline: Validate sale for Perm1, Perm2 and Perm3 bet types using Pick New
    Given <betType> bet type and Pick New is selected
    And <numberSelected> numbers are picked
    When number of lines selected are <noOfLines> and NumberSelected <numberSelected> and bet type is <betType>
    And increase betAmount by <clickBetAmt>
    Then PurchaseAmt $ <amount>
    And Purchased ticket is generated

    Examples: 
      | betType | numberSelected | noOfLines | clickBetAmt | amount |
      | Perm1   |             10 |        10 |           2 |   3.00 |
      | Perm2   |              5 |        10 |           1 |   2.00 |
      | Perm2   |             12 |        66 |           3 |  26.40 |
      | Perm2   |             20 |       190 |           2 |  57.00 |
      | Perm3   |              5 |        10 |           3 |   4.00 |
      | Perm3   |              9 |        84 |           4 |  42.00 |
      | Perm3   |             20 |      1140 |           1 | 228.00 |

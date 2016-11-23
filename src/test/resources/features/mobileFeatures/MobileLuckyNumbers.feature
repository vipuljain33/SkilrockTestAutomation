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
  Scenario Outline: Validate no ticket generated when less than minimum numbers are selected for bet types
    When <betType> bet type and Pick New is selected
    And <numPicked> numbers are picked
    Then Ticket should not be generated

    Examples: 
      | betType | numPicked |
      | Perm1   |         9 |
      | Perm2   |         4 |
      | Perm3   |         4 |

  #comment: validate No. of lines , Numbers selected and Final Amount
  @MobileLuckyNumQuickPickSale
  Scenario Outline: Validate Perm1, Perm2 and Perm3 bet types using Quick Pick
    Given <betType> bet type and Quick Pick is selected
    And <clickQpNumPicked> qp numbers are picked
    When number of lines selected are <noOfLines> and NumberSelected <numberSelected> and bet type is <betType>
    And increase betAmount by <clickBetAmt>
    Then PurchaseAmt $ <amount>
    And Purchased ticket is generated

    Examples: 
      | betType | clickQpNumPicked | noOfLines | numberSelected | clickBetAmt | amount |
      | Perm1   |                0 |        10 |             10 |           0 |   1.00 |
      | Perm1   |                0 |        10 |             10 |           5 |   6.00 |
      | Perm2   |                0 |        10 |              5 |           2 |   3.00 |
      | Perm2   |               15 |       190 |             20 |           1 |  38.00 |
      | Perm3   |                0 |        10 |              5 |           3 |   4.00 |
      | Perm3   |               15 |      1140 |             20 |           0 | 114.00 |

  @MobileLuckyNumPickNewSale
  Scenario Outline: Validate Perm1, Perm2 and Perm3 bet types using Pick New
    Given <betType> bet type and Pick New is selected
    And <numPicked> numbers are picked
    When number of lines selected are <noOfLines> and NumberSelected <numberSelected> and bet type is <betType>
    And increase betAmount by <clickBetAmt>
    Then PurchaseAmt $ <amount>
    And Purchased ticket is generated

    Examples: 
      | betType | numPicked | noOfLines | numberSelected | clickBetAmt | amount |
      | Perm1   |        10 |        10 |             10 |           2 |   3.00 |
      | Perm2   |         5 |        10 |              5 |           1 |   2.00 |
      | Perm2   |        12 |        66 |             12 |           3 |  26.40 |
      | Perm2   |        20 |       190 |             20 |           2 |  57.00 |
      | Perm3   |         5 |        10 |              5 |           3 |   4.00 |
      | Perm3   |         9 |        84 |              9 |           4 |  42.00 |
      | Perm3   |        20 |      1140 |             20 |           1 | 228.00 |

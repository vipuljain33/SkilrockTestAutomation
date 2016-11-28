@MobileLuckyNumber
Feature: Mobile app Lucky Number Sale

  Background: 
    Given User is logged in app
    And Draw games app icon is selected
    And Lucky numbers app game is selected

  @MobileLuckyNumberDBValidate
  Scenario: Validate all bet type display on app screen
    Given Active bet types in app are present in DB
    Then Active bet types are visible in app

  Scenario Outline: Validate minimum numbers selected for all bet types
    When <betType> and Pick New is selected in app
    And <numbers> are picked in app
    Then ticket should not be generated in app

    Examples: 
      | betType | numbers |
      | Perm1   |       9 |
      | Perm2   |       4 |
      | Perm3   |       4 |

  @MobileLuckyNumberGamePlayValidate
  Scenario Outline: Validate maximum numbers selected for all bet types
    When <betType> and Pick New is selected in app
    And <numbers> are picked in app
    Then Maximum Numbers should be displayed in <numberSelected> in app

    Examples: 
      | betType | numbers | numberSelected |
      | Perm1   |      11 |             10 |
      | Perm2   |      21 |             20 |
      | Perm3   |      21 |             20 |

  Scenario Outline: Validate No. of lines , Numbers selected & Final Amount in all bet types using Quick Pick
    Given <betType> and Quick Pick is selected in app
    And qp <numbers> are picked in app
    When number of lines selected are <noOfLines> and NumberSelected <numberSelected> for bet type <betType> QP in app
    Then Purchase amount is $ <amount> in app

    Examples: 
      | betType | numbers | numberSelected | noOfLines | amount |
      | Perm1   |       0 |             10 |        10 |   1.00 |
      | Perm2   |       0 |              5 |        10 |   1.00 |
      | Perm3   |       5 |             10 |       120 |  12.00 |
      | Perm3   |      15 |             20 |      1140 | 114.00 |

  Scenario Outline: Validate No. of lines , Numbers selected & Final Amount in all bet types using Pick New
    Given <betType> and Pick New is selected in app
    And <numberSelected> are picked in app
    When number of lines selected are <noOfLines> and NumberSelected <numberSelected> for bet type <betType> in app
    Then Purchase amount is $ <amount> in app

    Examples: 
      | betType | numberSelected | noOfLines | amount |
      | Perm1   |             10 |        10 |   1.00 |
      | Perm2   |             10 |        45 |   4.50 |
      | Perm2   |             20 |       190 |  19.00 |
      | Perm3   |              5 |        10 |   1.00 |

  @MobileLuckyNumQuickPickSale
  Scenario Outline: Validate sale for Perm1, Perm2 and Perm3 bet types using Quick Pick
    Given <betType> and Quick Pick is selected in app
    And qp <numbers> are picked in app
    When number of lines selected are <noOfLines> and NumberSelected <numberSelected> for bet type <betType> QP in app
    And increase app betAmount by <clickBetAmt>
    Then Purchase amount is $ <amount> in app
    And Purchased ticket is generated in app

    Examples: 
      | betType | numbers | numberSelected | noOfLines | clickBetAmt | amount |
      | Perm1   |       0 |             10 |        10 |           0 |   1.00 |
      | Perm1   |       0 |             10 |        10 |           5 |   6.00 |
      | Perm2   |       0 |              5 |        10 |           2 |   3.00 |
      | Perm2   |      15 |             20 |       190 |           1 |  38.00 |
      | Perm3   |       0 |              5 |        10 |           3 |   4.00 |
      | Perm3   |      15 |             20 |      1140 |           0 | 114.00 |

  @MobileLuckyNumPickNewSale
  Scenario Outline: Validate sale for Perm1, Perm2 and Perm3 bet types using Pick New
    Given <betType> and Pick New is selected in app
    And <numberSelected> are picked in app
    When number of lines selected are <noOfLines> and NumberSelected <numberSelected> for bet type <betType> in app
    And increase app betAmount by <clickBetAmt>
    Then Purchase amount is $ <amount> in app
    And Purchased ticket is generated in app

    Examples: 
      | betType | numberSelected | noOfLines | clickBetAmt | amount |
      | Perm1   |             10 |        10 |           2 |   3.00 |
      | Perm2   |              5 |        10 |           1 |   2.00 |
      | Perm2   |             12 |        66 |           3 |  26.40 |
      | Perm2   |             20 |       190 |           2 |  57.00 |
      | Perm3   |              5 |        10 |           3 |   4.00 |
      | Perm3   |              9 |        84 |           4 |  42.00 |
      | Perm3   |             20 |      1140 |           1 | 228.00 |

  Scenario Outline: Validate advance draw info with database
    Given <betType> and Quick Pick is selected in app
    When Advance draws are selected in app
    Then app draw info should be matched with database

    Examples: 
      | betType |
      | Perm1   |
      | Perm2   |
      | Perm3   |

  @MobileLuckyNumberAdvanceDraw
  Scenario Outline: Verify total price for ticket when multiple draws are selected
    Given <betType> and Quick Pick is selected in app
    When select multiple draws
    Then Purchase amount is $ <amount> in app

    Examples: 
      | betType | amount |
      | Perm1   |   3.00 |
      | Perm2   |   3.00 |
      | perm3   |   3.00 |

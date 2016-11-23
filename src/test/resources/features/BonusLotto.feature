@BonusLotto
Feature: Bonus Lotto Sale

  Background: 
    Given login with valid credentials bonusLotto
    And Bonus Lotto Game is selected

  Scenario: Validate Invalid selection for Direct6 bet type
    When Direct6 is selected
    And select num different than sixN numbers
      |  5 |
      | 10 |
      | 15 |

  Scenario: Validate Invalid Quick Pick functionality for DIRECT-SIX
    When QuickPick for direct-six is checked
    And number num greater than Four is entered
      | 6 |
      | 8 |
	@test
  Scenario: Validate valid Quick Pick Functionality for DIRECT-SIX
    When QuickPick for direct-six is checked
    And number less than Five is entered
      | 2 |
      | 3 |

  Scenario Outline: Validate the RESET functionality
    Given <num> numbers are picked
    When reset button is clicked
    Then validate reset

    Examples: 
      | num |
      |   8 |

  Scenario: Validate max number selected for Direct6 bet type
    When Direct6 is selected
    And select more than 24 numbers
    Then popup error message should display Bonus Lotto

  Scenario Outline: Validate the DIRECT-SIX Ticket Price
    Given <num> numbers are picked
    When bet amount <amount> is selected
    Then validate ticket price direct6

    Examples: 
      | num | amount |
      |  12 |    0.2 |
      |  18 |    0.4 |

  Scenario: Validate number of boxes for Direct6 bet type
    When Direct6 is selected
    Then Number of boxes should be twentyfour

  Scenario: Validate number of boxes for perm6 bet type
    Given Perm6 is selected
    Then Number of boxes should be fifteen

  Scenario: Validate min number selected for Perm6 bet type
    When Perm6 is selected
    And select less than 7 numbers
    Then buy option is not enable

  Scenario: Validate max number selected for Perm6 bet type
    When Perm6 is selected
    And select more than 15 numbers
    Then permsix popup error message should display

  Scenario: Validate min number selected for Perm6 bet type QP
    When Perm6 is selected
    And select less than 7 numberOfline
    Then permsixQp popup error message should display

  Scenario: Validate max number selected for Perm6 bet type QP
    When Perm6 is selected
    And select more than 15 numberOfline
    Then permsixQp popup error message should display

  Scenario Outline: Validate Buy button for Perm6 bet type
    When Perm6 is selected
    And <num> numbers are picked
    Then buy option should enable to buy

    Examples: 
      | num |
      |   7 |
      |  10 |

  Scenario Outline: Validate buy button for Perm6 bet type QP
    When Perm6 is selected
    And select <noOfLine> numberOfline
    Then buy option should enable to buy

    Examples: 
      | noOfLine |
      |        8 |
      |        9 |

  Scenario: Validate noOflines for Perm6 bet type
    When Perm6 is selected
    And number are selected
      | 7 |
      | 8 |

  Scenario Outline: Validate the PERM_SIX Ticket Price
    When Perm6 is selected
    Given <num> numbers are picked
    When bet amount <amount> is selected
    Then validate ticket price perm6

    Examples: 
      | num | amount |
      |   7 |    0.2 |
      |   8 |    0.4 |

  Scenario: Validate all bet type display on screen
    Given Active bet types are present in DB BonusLotto
    Then Active bet types are visible for BonusLotto

  Scenario Outline: validate sale for permsix using quickpick
    Given Perm6 is selected
    When <num> numbers are picked
    And buynow button selected bonus Lotto
    And In popup alert box accepted bonus Lotto
    Then ticket should be puchased bonus Lotto

    Examples: 
      | num |
      |   7 |

  Scenario Outline: validate sale for directsix using quickpick
    Given Direct6 is selected
    When <num> numbers are picked
    And buynow button selected bonus Lotto
    And In popup alert box accepted bonus Lotto
    Then ticket should be puchased bonus Lotto

    Examples: 
      | num |
      |   6 |

  Scenario: Validate advance draw info with database
    When Perm6 is selected
    And Advance draw is selected bonus Lotto
    Then draw info should be matched with database bonus Lotto

  Scenario: Validate advance draw info with database
    When Direct6 is selected
    And Advance draw is selected bonus Lotto
    Then draw info should be matched with database bonus Lotto

  Scenario: Validate ticket number after sale
    When Perm6 ticket purchased
    And ticket preview display bonus Lotto
    Then ticket number in preview should be equal to database value bonus Lotto

  Scenario Outline: Validate sale for Multiple draws
    When Perm6 is selected
    And Advance draw is selected bonus Lotto
    And select <noOfDraws>
    And <num> numbers are picked
    Then validate ticket price perm6

    Examples: 
      | noOfDraws | num |
      |         2 |   7 |
      |         3 |   8 |

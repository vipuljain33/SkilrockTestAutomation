
Feature: validating various scenarios under mini-roulette

  Background: 
    Given login with valid credentials MiniRoulette
    And Draw game option is selected MiniRoulette
    And miniRoulette is selected

  Scenario Outline: 
    Given select bet amount<amount>
    When select bet types randomly <N> n times
    Then validate ticket price

    Examples: 
      | amount | N |
      |     20 | 2 |
      |     50 | 2 |

  
  Scenario Outline: 
    Given select bet amount<amount>
    When select bet types randomly <N> n times
    Then validate price per element

    Examples: 
      | amount | N  |
      |     50 | 28 |

  Scenario Outline: 
    Given select bet amount<amount>
    When select bet types randomly <totalBetTypes> n times
    And select <N> advance draw
    Then validate ticket price

    Examples: 
      | amount | totalBetTypes | N |
      |     50 |            10 | 3 |

  Scenario: Validate advance draw info with database
    Given Advance draw is selected MiniRoulette
    Then draw info should be matched with database MiniRoulette

  @MiniRullet  
  Scenario Outline: Validate ticket number after sale
    When any BetType ticket purchased <N>
    And ticket preview display MiniRoulette
    Then ticket number in preview should be equal to database value MiniRoulette

    Examples: 
      | N  |
      | 10 |

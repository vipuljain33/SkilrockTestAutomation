@Now
Feature: validating various scenarios under Soccer Thirteen

  Scenario Outline: validate Ticket sale for Soccer13
    Given sale done for soccerThirteen through api <str>
    Given login with valid credentials soccerThirteen
    And Draw game option is selected soccerThirteen
    And soccerThirteen is selected
    Then validate soccerThirteen ticket data

    Examples: 
      | str      |
      | "Random" |
      | "All-D"  |
      | "All-H"  |

  
  Scenario Outline: 
    Given login with valid credentials soccerThirteen
    And Draw game option is selected soccerThirteen
    And soccerThirteen is selected
    When <No-Of-Events> n events are selected
    Then validate buy button

    Examples: 
      | No-Of-Events |
      |            7 |
      |           13 |

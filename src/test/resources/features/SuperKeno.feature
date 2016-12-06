@SuperKeno
Feature: Super Keno Sale

  Background: 
    Given login with valid credentials SuperKeno
    And SuperKeno Game is selected
    
   @ApiReprintSuperKeno
  	Scenario Outline: validate Ticket Reprint for SuperKeno GAMES
    Then validate Ticket Reprint for <bettypes>  By API after sale for SuperKenoHybrid

    Examples: 
      | bettypes |
      | Direct2  |
      | Direct3  |
      | Direct4  |
      | Direct5  |
      | Direct6  |
      | Direct7  |
      | Direct8  |
      | Direct9  |
      | Direct10 |
   

@MobileSoccer13
Feature: Mobile app Soccer13 Sale

  Background: 
    Given User is logged in app
    And Sports Lottery app icon is selected
    And Soccer13 app bet is selected

  @Running
  Scenario Outline: Validate Soccer13 sale from app
    Given <betName> is displayed in app Bettype dropdown
    When atlest one team is selected in each app event
    Then No of lines should be <noOfLines> and Bet amount is <betAmount> for $ <ticketAmount> in app

    Examples: 
      | betName  | noOfLines | betAmount | ticketAmount |
      | Soccer13 |         1 |       1.0 |         1.00 |

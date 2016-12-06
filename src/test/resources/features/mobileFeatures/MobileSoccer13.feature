@MobileSoccer13
Feature: Mobile app Soccer13 Sale

  Background: 
    Given User is logged in app Soccer13
    And Sports Lottery app icon is selected
    And Soccer13 app bet is selected

  @MobileSoccer13-1
  Scenario Outline: Validate Soccer13 sale from app
    Given <betName> is displayed in app Bet type dropdown
    When Atleast one team is selected in each app event
    Then No of lines should be <noOfLines> and Bet amount is <betAmount> for $ <ticketAmount> in app
    And SLE Purchased ticket is generated in app with <noOfLines> and $ <ticketAmount> in app

    Examples: 
      | betName   | noOfLines | betAmount | ticketAmount |
      | Soccer 13 |         1 |       1.0 |         1.00 |

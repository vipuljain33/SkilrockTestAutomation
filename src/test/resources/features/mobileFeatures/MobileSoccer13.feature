@MobileSoccer13
Feature: Mobile app Soccer13 Sale

  Background: 
    Given User is logged in app Soccer13
    And Sports Lottery app icon is selected
    And Soccer13 app game is selected

  @MobileSoccer13-1
  Scenario Outline: Validate Soccer13 sale from app
    Given <betName> is displayed in app Bet type dropdown
    When Atleast one team is selected in each app event
    Then No of lines should be <noOfLines> and Bet amount is <betAmount> for $ <ticketAmount> in app

    Examples: 
      | betName   | noOfLines | betAmount | ticketAmount |
      | Soccer 13 |     1     |    1.0    |      1.00    |
      | Soccer 13 |     3     |    4.0    |     12.00    |
    
Scenario:
Given We click on Buy now button
When A confirmation pop up appears
And We click on Ok button of pop up
Then Ticket gets printed and displayed in My Tickets section

Scenario:
When We select more than one option 
Then No of lines should increase accordingly 
And Ticket amount should increase accordingly too



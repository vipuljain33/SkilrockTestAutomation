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

    Examples: 
      | betName   | noOfLines | betAmount | ticketAmount |
      | Soccer 13 |         1 |       1.0 |         1.00 |
      | Soccer 13 |         3 |       4.0 |        12.00 |

  Scenario: Validate ticket purchase if atleast one team is selected in each app event
    Given Buy now button is clicked
    When A confirmation pop up appears
    And We click on Ok button of pop up
    Then Ticket gets printed and displayed in My Tickets section

  Scenario: Validate no of lines and ticket amount if we select more than one option(Home,Draw,Away)
    When We select more than one option
    Then No of lines should increase accordingly
    And Ticket amount should increase accordingly too

  Scenario: Validate ticket purchase if atleast one team is not selected in each app event
    When Atleast one team is not selected in each app event
    And We click on Buy now button
    Then A confirmation pop up should not appear

  Scenario: Validate clicks on plus correspodning to Bet Amount
    When We click on plus icon
    Then Bet amount should increase accordingly

  Scenario: Validate clicks on minus correspodning to Bet Amount
    When We click on minus icon
    Then Bet amount should decrease accordingly

  Scenario Outline: Validate maximum bet amount
    Given Bet amount is <bet amount>
    When We click on minus icon
    Then Maximum bet amount should be <max bet amount>

    Examples: 
      | bet amount   | max bet amount |
      |     1        |     600        |

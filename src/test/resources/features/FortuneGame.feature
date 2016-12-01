@FortuneGame
Feature: Fortune Game sale

Background: 
    Given Login with valid credentials fg
    And Draw game option is selected fg
    And Fortune game is selected

@Fortune1
 Scenario: Validate range of number or zodiac signs selected
    When We select more than five numbers
    Then Popup error message should be displayed for more than five numbers
 
@Fortune2 
 Scenario: Validate maximum number of draws
    When We click on number of draws field 
    And Enter more than three numbers
    Then Popup error message should be displayed for more than three numbers
 
@Fortune3    
 Scenario: Validate maximum number of quick pick numbers
    When We click on quick pick checkbox
    And Enter more than five numbers in text field 
    Then Popup error message should be displayed for more than five numbers in qp
 
 @Fortune4 
 Scenario: Validate maximum Bet Amount
    When We click on other option of Bet Amount
    And Enter an amount greater than hundred
    Then Popup error message should be displayed for greater than hundred amount
  
 @Fortune5    
 Scenario: Validate click on Buy Now button without selecting any number
    When We do not select any number
    And Hover on Buy Now button case1
    Then A hint should appear case1

@Fortune6
 Scenario: Validate click on Buy Now button by selecting numbers but without selecting bet amount
    When We select any number
    But Do not select bet amount(by clicking on other and not entering any bet amount)
    And Hover on Buy Now button case2
    Then A hint should appear case2
  
 @Fortune7
    Scenario: Validate selected numbers with numbers in Purchase details after selecting QP
    When QP checkbox is selected
    And Enter a number in no to be selected field
    Then Verify selected numbers in purchase details qp
    
 @Fortune8
 Scenario Outline: Validate total amount calculated which is visible beside Buy Now button.
    When We select numbers <numbers>,bet amount <bet amount> and number of draws <no of draws>
    Then Total amount <total amount> should be equal to number count multiplied by No of draws multiplied by Bet amount
    
     Examples: 
               | numbers  | bet amount | no of draws | total amount |
               |   3      |      2     |     1       |     6        |
               |   4      |      4     |     2       |     32       |
               |   5      |      5     |     3       |     75       |
 
 @Fortune9
  Scenario: Validate advance draw info with database fg  
    When Advance draw is selected fg
    Then Draw info should be matched with database fg

 #@Fortune10    
#Scenario: Validate ticket number after sale fg
#    When Fortune game ticket purchased
#    And Ticket preview is displayed
 #  Then Ticket number in preview should be equal to database value fg
 
 
 # Scenario: Validate click on other option of Bet Amount
 #   When We click on other option of Bet Amount
 #   Then Other option should disappear
 #   And  editable text field should appear   
    
 #Scenario: Validate click on reset button
 #  When We click on reset button
 #  Then All selected numbers should get deselected
 
    
   #Scenario: Validate click on various bet amountss
   # When We click on various bet amounts
   # Then Bet Amount should get selected  
   # And  color should change
 
 
   #Scenario: Validate numbers which can be entered manually in five fields
   #  When We enter numbers in these fields
   #  Then Zodiac signs corresponding to manually entered numbers should get highlighted
  
    
 #Scenario: Validate selected numbers with numbers in Purchase details
 # When We select numbers manually
 # Then verify selected numbers in purchase details m
    
    
      
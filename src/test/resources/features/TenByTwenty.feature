@TenByTwenty
Feature: Ten By Twenty sale

  Background: 
    Given login with given credentials for TenByTwenty
    And select Ten By Twenty game for TenByTwenty

  #Scenario: verify ten by twenty is available for TenByTwenty
  # Given logged in successfully for TenByTwenty
  #  When draw game is selected for TenByTwenty
  # Then ten by twenty should be visible for TenByTwenty\
 
  Scenario: verify direct ten bet type for TenByTwenty
    Given direct ten bet type is selected for TenByTwenty
    When Quickpick is selected for TenByTwenty
    Then random number between one to twenty should be selected for TenByTwenty

  Scenario: verify first ten bet type for TenByTwenty
    When first ten bet type is selected for TenByTwenty
    Then number picked should be one to ten for TenByTwenty
    And QP should not enable for TenByTwenty

  Scenario: verify last ten bet type for TenByTwenty
    When last ten bet type is selected for TenByTwenty
    Then number picked should be eleven to twenty for TenByTwenty
    And QP should not enable for TenByTwenty

  Scenario: verify all odd bet type for TenByTwenty
    When all odd bet type is selected for TenByTwenty
    Then number picked should be odd for TenByTwenty
    And QP should not enable for TenByTwenty

  Scenario: verify all even bet type for TenByTwenty
    When all even bet type is selected for TenByTwenty
    Then number picked should be even for TenByTwenty
    And QP should not enable for TenByTwenty

  Scenario: verify evenodd bet type for TenByTwenty
    When evenodd bet type is selected for TenByTwenty
    Then number picked should be even between one to ten and odd between eleven to twenty for TenByTwenty
    And QP should not enable for TenByTwenty

  Scenario: verify oddeven bet type for TenByTwenty
    When oddeven bet type is selected for TenByTwenty
    Then number picked should be odd between one to ten and even between eleven to twenty for TenByTwenty
    And QP should not enable for TenByTwenty

  Scenario: verify jumpoddeven bet type for TenByTwenty
    When jumpoddeven  bet type is selected for TenByTwenty
    Then number picked should be in oddeven pair for TenByTwenty
    And QP should not enable for TenByTwenty

  Scenario: verify jumpevenodd bet type for TenByTwenty
    When jumpevenodd  bet type is selected for TenByTwenty
    Then number picked should be in evenodd pair for TenByTwenty
    And QP should not enable for TenByTwenty

  Scenario: Validate ticket price for all odd TenByTwenty
    When all odd bet type is selected for TenByTwenty
    And other bet amount selected five point five
    Then total ticket amount should be five point five
 @amit
  Scenario: verify Direct ten by quick pick TenByTwenty
    Given click on direct ten bet type TenByTwenty
    When select the QuickPick option TenByTwenty
    Then ten numbers should be randomly selected TenByTwenty

  Scenario: verify Sale for Direct10 QP TenByTwenty
    Given click on direct ten bet type TenByTwenty
    When select the QuickPick option TenByTwenty
    And Click on buy button TenByTwenty
    Then ticket preview should shown TenByTwenty

  Scenario: verify Sale for FIRST10 TenByTwenty
    Given Click on FIRST10 Bet type TenByTwenty
    When Click on buy button TenByTwenty
    Then ticket preview should shown TenByTwenty

  Scenario: verify Sale for LAST10 TenByTwenty
    Given Click on LAST10 Bet type TenByTwenty
    When Click on buy button TenByTwenty
    Then ticket preview should shown TenByTwenty

  Scenario: verify Sale for AllODD TenByTwenty
    Given Click on ALLODD Bet type TenByTwenty
    When Click on buy button TenByTwenty
    Then ticket preview should shown TenByTwenty

  Scenario: verify Sale for AllEVEN TenByTwenty
    Given Click on FIRST10 Bet type TenByTwenty
    When Click on buy button TenByTwenty
    Then ticket preview should shown TenByTwenty

  Scenario: verify Sale for  ODDEVEN TenByTwenty
    Given Click on ODDEVEN Bet type TenByTwenty
    When Click on buy button TenByTwenty
    Then ticket preview should shown TenByTwenty

  Scenario: verify Sale for EVENODD TenByTwenty
    Given Click on EVENODD Bet type TenByTwenty
    When Click on buy button TenByTwenty
    Then ticket preview should shown TenByTwenty

  Scenario: verify Sale for JUMPEVENODD TenByTwenty
    Given Click on JUMPEVENODD Bet type TenByTwenty
    When Click on buy button TenByTwenty
    Then ticket preview should shown TenByTwenty

  Scenario: verify Sale for JUMPODDEVEN TenByTwenty
    Given Click on JUMPODDEVEN Bet type TenByTwenty
    When Click on buy button TenByTwenty
    Then ticket preview should shown TenByTwenty

  Scenario: verify advance draw sale for Direct10 Quick Pick TenByTwenty
    Given click on direct ten bet type TenByTwenty
    And select the QuickPick option TenByTwenty
    When Click on Advance Draw Section TenByTwenty
    And Click on buy button TenByTwenty
    And ticket preview should shown TenByTwenty

  Scenario: Validate advance draw info with database
    When click on direct ten bet type TenByTwenty
    Then draw info should be matched with database TenByTwenty

  Scenario: verify database table for sale TenByTwenty
    When First10 Ticket purchased TenByTwenty
    Then ticket number in preview should be equal to database value TenByTwenty

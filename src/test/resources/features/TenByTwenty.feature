@TenByTwenty
Feature: Ten By Twenty sale

  Background: 
    Given login with given credentials for TenByTwenty
    And select Ten By Twenty game for TenByTwenty

  #Scenario: verify ten by twenty is available for TenByTwenty
  # Given logged in successfully for TenByTwenty
  #  When draw game is selected for TenByTwenty
  # Then ten by twenty should be visible for TenByTwenty
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

  @shiwangi
  Scenario: Validate ticket price for all odd TenByTwenty
    When all odd bet type is selected for TenByTwenty
    And other bet amount selected five point five
    Then total ticket amount should be five point five

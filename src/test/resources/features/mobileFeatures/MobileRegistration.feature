@MobileRegisteration
Feature: This is Registration feature

  @MobileValidReg
  Scenario: Testing valid app enteries for Registration
    Given Registration popup is opened
    When Valid app enteries are entered
    Then Login popup should be visible

  @MobileInvalidReg
  Scenario Outline: Testing blank app enteries for Registration
    Given Registration popup is opened
    When blank app enteries <username> <mobileNo> <emailId> is entered
    Then Login popup should not be visible

    Examples: 
      | username | mobileNo | emailId      |
      | test1    |          | abc@skil.com |

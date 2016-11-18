@MobileRegisteration
Feature: This is Registration feature

  Background: 
    Given Open Registration popup

  @MobileValidReg
  Scenario: Testing valid app data for Registration
    When Valid app enteries are entered
    Then Login popup should be visible

  @MobileInvalidReg1
  Scenario: Testing duplicate app data so that Registration is unsuccessful
    When Invalid app data is entered on the page
      | username | mobileNo   | emailId      |
      | testdata | 9999999999 | abc@skil.com |
      | test1    | 9560488046 | abc@skil.com |

  @MobileInvalidReg2
  Scenario: Testing invalid app data so that Registration is unsuccessful
    When Invalid app data is entered on the page
      | username  | mobileNo   | emailId      |
      | testdata1 |            | abc@skil.com |
      |           | 9999999999 | abc@skil.com |
      | abcde     | 9999999999 |              |
      | abc       | 9999999999 | abc@skil.com |
      | abcde     |     999999 | abc@skil.com |
      | abcde     | 9999999999 | abc          |

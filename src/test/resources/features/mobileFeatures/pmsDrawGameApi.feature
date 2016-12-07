@MobileDrawGameApi
Feature: DrawGame Sale Api

  Background: 
    Given App user is Authenticated

  Scenario Outline: Verify purchase ticket api response with QP for all bet types
    When Draw game app data is fetched
    Then <gameCode> ticket is purchased with <isQP> and <pickedNumbers> for <playType> and <noPicked> in app

    Examples: 
      | gameCode      | isQP | pickedNumbers | noPicked | playType |
      | KenoTwo       | true | QP            |       10 | Perm1    |
      | KenoTwo       | true | QP            |        5 | Perm2    |
      | KenoTwo       | true | QP            |        5 | Perm3    |
      | ZimLottoBonus | true | QP            |        1 | Direct6  |
      | ZimLottoBonus | true | QP            |        7 | Perm6    |

  @PickNewApi
  Scenario Outline: Verify purchase ticket api response with Pick New for all bet types
    When Draw game app data is fetched
    Then <gameCode> ticket is purchased with <isQP> and <pickedNumbers> for <playType> and <noPicked> in app

    Examples: 
      | gameCode      | isQP  | pickedNumbers        | noPicked | playType |
      | KenoTwo       | false | 1,2,3,4,5,6,7,8,9,10 |       10 | Perm1    |
      | KenoTwo       | false |            5,6,7,8,9 |        5 | Perm2    |
      | KenoTwo       | false |       11,12,13,14,15 |        5 | Perm3    |
      | ZimLottoBonus | false |          1,2,5,6,8,9 |        1 | Direct6  |
      | ZimLottoBonus | false |        1,2,3,4,5,6,7 |        7 | Perm6    |

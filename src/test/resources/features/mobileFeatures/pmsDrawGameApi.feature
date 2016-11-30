@MobileDrawGameApi
Feature: DrawGame Sale Api

  Background: 
    Given App user is Authenticated

  Scenario Outline: 
    When Draw game app data is fetched
    Then <gameCode> ticket is purchased with <isQP> and <pickedNumbers> for <playType> and <noPicked> in app

    Examples: 
      | gameCode      | isQP | pickedNumbers | noPicked | playType |
      | KenoTwo       | true | QP            |       10 | Perm1    |
      | KenoTwo       | true | QP            |       10 | Perm2    |
      | KenoTwo       | true | QP            |       10 | Perm3    |
      | ZimLottoBonus | true | QP            |        1 | Direct6  |
      | ZimLottoBonus | true | QP            |        7 | Perm6    |

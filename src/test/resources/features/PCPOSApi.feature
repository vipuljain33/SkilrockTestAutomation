@Api
Feature: Api Testing For PCPOS Game

  Background: 
    Given authenticate User

  @Apisale
  Scenario Outline: validate API sale for LuckyNumber GAMES
    When <bettypes> is selected and Sale Performed By API
    Then <bettypes> validate responce data from API

    Examples: 
      | bettypes |
      | Perm1    |
      | Perm2    |
      | Perm3    |

  @Apicancel
  Scenario Outline: validate Ticket Cancelatilon for LuckyNumber GAMES
    Then validate Ticket Cancelatilon for <bettypes>  By API after sale

    Examples: 
      | bettypes |
      | Perm1    |
      | Perm2    |
      | Perm3    |

  @Apireprint
  Scenario Outline: validate Ticket Reprint for LuckyNumber GAMES
    Then validate Ticket Reprint for <bettypes>  By API after sale

    Examples: 
      | bettypes |
      | Perm1    |
      | Perm2    |
      | Perm3    |

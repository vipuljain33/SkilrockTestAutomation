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

  @ApisaleBonusLotto
  Scenario Outline: validate API sale for BonusLotto Games
    When <bettypes> is selected and Sale Performed By API for BonusLotto
    Then <bettypes> validate responce data from API for BonusLotto

    Examples: 
      | bettypes |
      | Perm6    |
      | Direct6  |

  @ApiCancelBonusLotto
  Scenario Outline: validate Ticket Cancelatilon for BonusLotto GAMES
    Then validate Ticket Cancelatilon for <bettypes>  By API after sale for BonusLotto

    Examples: 
      | bettypes |
      | Perm6    |
      | Direct6  |

  @ApiReprintBonusLotto
  Scenario Outline: validate Ticket Reprint for BonusLotto GAMES
    Then validate Ticket Reprint for <bettypes>  By API after sale for BonusLotto

    Examples: 
      | bettypes |
      | Perm6    |
      | Direct6  |

  @PcposDrewFreeze
  Scenario: Perform Draw Freeze for LuckyNumber PCPOS GAMES
    Given perform sale for single bet type and capture sale data
    When authenticate BackOffice User
    Then validate Freeze API Response with DB for LuckyNumber

  @PcposResultSubmission
  Scenario: Perform Result submission for LuckyNumber PCPOS GAMES
    Given fetch DrawGame data For PCPOS Game
    When validate Freeze API Response with DB for LuckyNumber
    Then validate Result Submission API Response with DB for LuckyNumber

  @ApisaleSuperKeno
  Scenario Outline: validate API sale for SuperKeno Games
    When <bettypes> is selected and Sale Performed By API for SuperKeno
    Then <bettypes> validate responce data from API for SuperKeno

    Examples: 
      | bettypes |
      | Direct2  |
      | Direct3  |
      | Direct4  |
      | Direct5  |
      | Direct6  |
      | Direct7  |
      | Direct8  |
      | Direct9  |
      | Direct10 |

  @ApiCancelSuperKeno
  Scenario Outline: validate Ticket Cancelatilon for SuperKeno GAMES
    Then validate Ticket Cancelatilon for <bettypes>  By API after sale for SuperKeno

    Examples: 
      | bettypes |
      | Direct2  |
      | Direct3  |
      | Direct4  |
      | Direct5  |
      | Direct6  |
      | Direct7  |
      | Direct8  |
      | Direct9  |
      | Direct10 |

  @ApiReprintSuperKeno
  Scenario Outline: validate Ticket Reprint for SuperKeno GAMES
    Then validate Ticket Reprint for <bettypes>  By API after sale for SuperKeno

    Examples: 
      | bettypes |
      | Direct2  |
      | Direct3  |
      | Direct4  |
      | Direct5  |
      | Direct6  |
      | Direct7  |
      | Direct8  |
      | Direct9  |
      | Direct10 |

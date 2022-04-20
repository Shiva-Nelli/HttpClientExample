@AddHero @regresssion
Feature: Add Hero

  @regression
  Scenario Outline: Add Hero
    Given user launches HTTPClient
    When user enters "<HeroName>" value in the Hero name
    And user clicks on add button
    Then hero will be added
    Examples:
    |HeroName|
    |   Spiderman     |
    |  12345      |
    |  @#$@@@      |


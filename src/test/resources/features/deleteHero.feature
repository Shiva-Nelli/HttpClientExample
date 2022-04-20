@DeleteHero @regresssion
Feature: Delete Hero

  @regression
  Scenario: Delete Hero
    Given user launches HTTPClient
    When user enters "Spiderman" value in the Hero name
    And user clicks on add button
    Then hero will be added
    Then user clicks on delete the newly added hero

@SearchHero @regresssion
Feature: Search Hero

  @regression
  Scenario: Search Hero
    Given user launches HTTPClient
    When user enters "Spiderman" value in the Hero name
    And user clicks on add button
    And hero will be added
    And user searches newly added heroname
    Then user will be displayed with newly added hero name
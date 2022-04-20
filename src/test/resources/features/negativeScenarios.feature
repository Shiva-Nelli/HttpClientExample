@regression
Feature: Add Hero

  @regression
  Scenario Outline: Add Duplicate Hero
    Given user launches HTTPClient
    When user enters "<HeroName>" value in the Hero name
    And user clicks on add button
    When user enters "<HeroName>" value in the Hero name
    And user clicks on add button
    Examples:
      |HeroName|
      |   Spiderman     |


  @regression
  Scenario Outline: Add Hero Name with more letters
    Given user launches HTTPClient
    When user enters "<HeroName>" value in the Hero name
    And user clicks on add button
    Examples:
      |HeroName|
      |   sdlfkjsdlfkjsdlkfjsdlfkjsdlfjsldfjsdlfjksldfjsldfjsldfjsldkfjlsdfjsldkfjslkdfjsldfjslkdfjsldkfjslkfdjasldkfjlsdkfjlskdfjsldfkjslfkjsdfkljsfldsdfjdlskjfsdlkfjsdlkfjsdlkfjsldfjklsdjflsdkfjsldf     |


  @regression
  Scenario Outline: Edit/Update Hero
    Given user launches HTTPClient
    When user enters "<HeroName>" value in the Hero name
    And user clicks on add button
    And hero will be added
    Then update the hero value "<Updated hero name>" by editing
    Examples:
      |HeroName|Updated hero name|
      |   Spiderman     | batman |

  @regression
  Scenario Outline: Add duplicate Heros and search
    Given user launches HTTPClient
    When user enters "<HeroName>" value in the Hero name
    And user clicks on add button
    When user enters "<HeroName>" value in the Hero name
    And user clicks on add button
    And user searches newly added heroname
    Then user will be displayed with newly added hero name
Examples:
      |HeroName|
      |   Spid|


  @regression
  Scenario Outline: Delete All Heros and Add New Hero to check its record number
    Given user launches HTTPClient
    When user deletes all heros
    When user enters "<HeroName>" value in the Hero name
    And user clicks on add button
    Then hero will be added
    Then count should be started with 11
    Examples:
      |HeroName|
      |   Spid|

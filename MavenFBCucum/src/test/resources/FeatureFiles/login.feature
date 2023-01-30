Feature: Validate the login funtionality of facebook

  Background: 
    Given user should launch the Chrome Browser and enter the url

  @smoke
  Scenario: Validate login funtionality with incorrect uername and password
    When User should enter the incorrect username and password
    And user should click login button
    Then user should navigate to incorrect credential page

  @regression
  Scenario: Validate login funtionality with valid username and invalid password
    When User should enter the valid username and invalid password
    And user should click login button
    Then user should navigate to incorrect credential page

  @sanity
  Scenario Outline: Validate login funtionality with invalid username and valid password
    When User should enter the invalid username "<sports>" and valid password "<colours>"
    And user should click login button
    Then user should navigate to incorrect credential page

    Examples: 
      | sports | colours |
      | ram    | 1qaz    |
      | wsz    | Waz@345 |

  @sanity @regresion
  Scenario: Validate login funtionality with valid username and password
    When User should enter the valid username and valid password
    And user should click login button
    Then user should navigate to home page

Feature: Login Feature Test Suite

  Scenario Outline: An error message is displayed when login is performed with invalid data <attribute>
    Given the "https://andreisecuqa.host/index.php?route=account/login&language=en-gb" is accessed
    And the following data is entered into the login form:
      | <email>    |
      | <password> |
    When loginButton is clicked
    Then the following error messages are displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | attribute | email             | password       |
      | email     | invalid@email.com | nevermind      |
      | password  | andrei@email.com  | fsdfdsf@23ewrw |

  Scenario Outline: A valid user is able to log into the system
    Given the "https://andreisecuqa.host/index.php?route=account/login&language=en-gb" is accessed
    And the following data is entered into the login form:
      | <email>    |
      | <password> |
    When loginButton is clicked
    Then the current url contains the following keyword: "account"
    Examples:
      | email            | password    |
      | andrei@email.com | Cc27481145! |

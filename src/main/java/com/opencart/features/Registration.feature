Feature: Register Flow Feature Test Suite
  Background:
    Given Home Page is accessed
    And "accountIcon" from "Page" is clicked
    And "registerBtn" from "Page" is clicked

  @Regression @Smoke
  Scenario: Access the Account Page after successful registration
    When the registration form is completed with valid random data
    And "privacyToggle" from "RegisterPage" is clicked
    And "continueButton" from "RegisterPage" is clicked
    Then the current url contains the following keyword: "account"

  Scenario: User remains on Register Page when continue button is not clicked during the register flow
    When the registration form is completed with valid random data
    And "privacyToggle" from "RegisterPage" is clicked
    Then  the current url contains the following keyword: "account"

  @Regression
  Scenario: User remains on Register Page when privacy conditions are not accepted during the registration flow
    When the registration form is completed with valid random data
    And "continueButton" from "RegisterPage" is clicked
    Then the current url contains the following keyword: "account"

  @run
  Scenario Outline: Error messages are displayed when trying to register with invalid <attribute> data
    And the registration form is completed with the following data:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | random      |
      | password  | Random      |
    When "continueButton" from "RegisterPage" is clicked
    Then the following error messages are displayed:
      | Warning: You must agree to the Privacy Policy!   |
      | <attribute> must be between 1 and 32 characters! |
    Examples:
      | attribute  | firstName                                         | lastName                                          |
      | First Name | Skdmsdlkfndskndsfknfkldsngkdfngfkdngvdfnkvdfkvbdf | random                                            |
      | Last Name  | random                                            | Skdmsdlkfndskndsfknfkldsngkdfngfkdngvdfnkvdfkvbdf |

  @execution
  Scenario: Error messages are displayed when trying to register with invalid <attribute> data
    And the following fields from "RegisterPage" are populated with data:
      | firstNameInput | Andrei                |
      | lastNameInput  | Secu                  |
      | emailInput     | andrei.s3cu@gmail.com |
      | passwordInput  | ThePassword!21        |
    When "continueButton" from "RegisterPage" is clicked
    Then the following error messages are displayed:
      | Warning: You must agree to the Privacy Policy! |
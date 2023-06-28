Feature: Register Flow Feature Test Suite

  @Regression @Smoke
  Scenario: Access the Account Page after successful registration
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And the privacyToggle is enabled
    And continueButton is clicked
    Then the new page url contains "=account/success&l" keyword

  Scenario: User remains on Register Page when continue button is not clicked during the register flow
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And the privacyToggle is enabled
    Then the new page url contains "route=account/register&language=en-gb" keyword

  @Regression
  Scenario: User remains on Register Page when privacy conditions are not accepted during the registration flow
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And continueButton is clicked
    Then the new page url contains "route=account/register&language=en-gb" keyword
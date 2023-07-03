package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @And("the following data is entered into the login form:")
    public void theFollowingDataIsEnteredIntoTheLoginForm(List<String> userDetailsList) {
        String emailValue = userDetailsList.get(0);
        String passwordValue = userDetailsList.get(1);
        loginPage.fillInTheLoginForm(emailValue, passwordValue);
    }

    @When("loginButton is clicked")
    public void loginbuttonIsClicked() {
        loginPage.clickOnLoginBtn();
    }
}

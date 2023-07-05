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

}

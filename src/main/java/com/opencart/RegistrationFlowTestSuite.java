package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class RegistrationFlowTestSuite {

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    static int counter = 0;

    @BeforeEach
    public void executeTheCodeBeforeEachTestFromThisClass() {
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        counter++;
        System.out.println("The test number " + counter + " started!");
    }

    @Test
    @DisplayName("The url contains success keyword after registration with valid data")
    public void registerFlowRedirectsTheUserToTheCorrectUrl() throws InterruptedException {
//        homePage.navigateToRegisterPageFromHeaderMenu();

        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String randomEmail = DataFakerManager.getRandomEmail("ggalbur", "@gmail.com");
        String password = DataFakerManager.getRandomPassword(21, 22);

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, password);
//        registerPage.switchOnThePrivacyToggle(driver);
//        registerPage.clickOnContinueButton();

        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());

        boolean urlContainsTheCorrectKeyWords = driver.getCurrentUrl().contains("/index.php?route=account/success&language");
        String errorMessage = "The Url " + driver.getCurrentUrl() + " contains success keyword";
        Assertions.assertTrue(urlContainsTheCorrectKeyWords, errorMessage);
    }

    @Test
    @DisplayName("The Url contains register keyword when privacy policy is not accepted")
    public void registerFlowIsBlockedByPrivacyPolicyToggleThatIsNotAccepted() throws InterruptedException {

//        homePage.navigateToRegisterPageFromHeaderMenu();

        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String randomEmail = DataFakerManager.getRandomEmail("ggalbur", "@gmail.com");
        String password = DataFakerManager.getRandomPassword(21, 22);

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, password);
//        Do not enable the Privacy Toggle
//        registerPage.switchOnThePrivacyToggle(driver);

//        registerPage.clickOnContinueButton();

        Thread.sleep(500);
        System.out.println(driver.getCurrentUrl());

        boolean urlContainsTheCorrectKeyWords = driver.getCurrentUrl().contains("/index.php?route=account/success&language");
        String errorMessage = "The Url " + driver.getCurrentUrl() + " does not contain success keyword";
        Assertions.assertFalse(urlContainsTheCorrectKeyWords, errorMessage);

        boolean urlContainsRegisterKeyword = driver.getCurrentUrl().contains("route=account/register&language=en-gb");
        Assertions.assertTrue(urlContainsRegisterKeyword, "The Url belongs to register page");

    }

    @AfterEach
    public void executeThisMethodsAfterEachTestCase(){
        DriverManager.getInstance().quitTheDriver();
        System.out.println("The test number " + counter + " finished!");
    }

}

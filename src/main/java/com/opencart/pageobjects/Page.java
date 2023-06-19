package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    public Page(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='fa-solid fa-user']")
    protected WebElement accountIcon;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    protected WebElement registerBtn;

    public void navigateToRegisterPageFromHeaderMenu() {
        accountIcon.click();
        System.out.println("The Account Icon was clicked");

        registerBtn.click();
        System.out.println("The Register Button was clicked");
    }

}

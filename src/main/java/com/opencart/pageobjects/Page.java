package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {

    public Page(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='fa-solid fa-user']")
    protected WebElement accountIcon;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    protected WebElement registerBtn;

}

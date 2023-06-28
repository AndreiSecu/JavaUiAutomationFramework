package com.opencart;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/com/opencart/features",
        glue = "com.opencart.stepdefinitions",
        tags = "@Regression or @Smoke",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class CucumberTestRunner {
}

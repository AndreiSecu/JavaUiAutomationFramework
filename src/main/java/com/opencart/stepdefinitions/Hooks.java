package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {

    static int counter = 0;

    @BeforeAll
    public static void beforeAllTheTestsAreExecuted() {
        System.out.println("The execution of features is started");
    }

    @Before
    public void beforeEachTest() {
        counter++;
        System.out.println("The [" + counter + "] Test Started");
    }

    @After
    public void afterEachTest() {
        DriverManager.getInstance().quitTheDriver();
        System.out.println("The [" + counter + "] Test is Finished");
    }

    @AfterAll
    public static void afterAllTheTestsAreExecuted() {
        System.out.println("The execution of all the features is finished");
    }

}

package com.bagisto.android.automation.steps;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.bagisto.android.automation.baseFactory;
import com.bagisto.android.automation.driver.AndroidDriverInit;
import org.springframework.beans.factory.annotation.Value;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;

public class home_steps extends baseFactory {

    @Autowired
    AndroidDriverInit androidDriverInit;

    @Value("${appium.port}")
    private int port;

    @Given("user run automation for device")
    public void runApplication(){
        androidDriverInit.runTest(this.port);
    }

    @And("user should see title header on Home Page")
    public void userShouldSeeTitleHeaderOnHomePage(){
        Assert.assertTrue(home_page.isDisplayedHeaderHomePage());
    }
}

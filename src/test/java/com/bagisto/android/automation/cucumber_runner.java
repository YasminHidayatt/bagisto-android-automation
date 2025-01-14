package com.bagisto.android.automation;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
    glue = {"com/bagisto/android/automation"},
    features = {"src/test/resources/features"},
    stepNotifications = true,
    tags = "@Test",
    publish = true
)
public class cucumber_runner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void beforeClass(){
    }

    @AfterClass
    public static void afterClass(){
    }
}

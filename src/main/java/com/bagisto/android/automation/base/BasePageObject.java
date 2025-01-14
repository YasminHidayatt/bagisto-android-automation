package com.bagisto.android.automation.base;

import java.util.List;
import static com.bagisto.android.automation.driver.AndroidDriverInit.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.time.Duration;


public class BasePageObject {


    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    public AndroidElement find(By locator){
        return getDriver().findElement(locator);
    }

    public void waitUntilPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getText(By locator){
        return find(locator).getText();
    }

    public boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    public void click(By locator){
        find(locator).click();
    }

    public void inputText(By locator, String text){
        AndroidElement element  = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    public List<AndroidElement> findAll(By locator){
        return getDriver().findElements(locator);
    }
}

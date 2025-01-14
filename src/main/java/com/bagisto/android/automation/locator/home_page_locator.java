package com.bagisto.android.automation.locator;

import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;

public interface home_page_locator {
    By LABEL_HOME_PAGE = MobileBy.xpath("//android.view.View[@content-desc=\"Bagisto Laravel App \"]");
}

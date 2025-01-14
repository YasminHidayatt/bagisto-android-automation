package com.bagisto.android.automation.pages;

import com.bagisto.android.automation.base.BasePageObject;
import org.springframework.stereotype.Component;

@Component
public class Home_page extends BasePageObject {
    
    public boolean  isDisplayedHeaderHomePage(){
        try {
            waitUntilPresent(null);
            return isDisplayed(null);
        } catch (Exception e) {
            return false;
        }
    }
}
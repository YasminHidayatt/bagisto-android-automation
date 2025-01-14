package com.bagisto.android.automation.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.spring.ScenarioScope;
import java.time.Duration;

@Configuration
public class AndroidDriverInit {
    public static AndroidDriver<AndroidElement> driver;
      
    @Value("${driver.mobile.android.capabilities.platformName}")
    private String  platfromName;

    @Value("${driver.mobile.android.capabilities.deviceName}")
    private String deviceName;

    @Value("${driver.mobile.android.capabilities.udid}")
    private String appiumUdid;

    @Value("${driver.mobile.android.capabilities.app}")
    private String app;

    @Value("${driver.mobile.android.capabilities.automationName}")
    private String automationName;

    @Value("${driver.mobile.android.capabilities.newCommandTimeout}")
    private Integer newCommandTimeout;

    @Value("${driver.mobile.android.capabilities.autoGrantPermissions}")
    private Boolean autoGrantPermissions;

    @Value("${driver.mobile.android.capabilities.noReset}")
    private Boolean noReset;

    @Value("${driver.mobile.android.appiumUrl}")
    private String appiumUrl;

    @Value("${driver.mobile.android.capabilities.chromeDriverExecutable1}")
    private String chromeDriverExecutable1;

    @Value("${driver.mobile.android.capabilities.appPackage}")
    private String appPackage;


    public void initialize(int port){
        DesiredCapabilities caps = new DesiredCapabilities(); 
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, this.platfromName);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, this.deviceName);
        caps.setCapability(MobileCapabilityType.UDID, this.appiumUdid);
        caps.setCapability(MobileCapabilityType.APP, this.app);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, this.automationName);
        caps.setCapability(MobileCapabilityType.EVENT_TIMINGS, this.newCommandTimeout);
        caps.setCapability(MobileCapabilityType.NO_RESET, this.noReset);
        caps.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, this.chromeDriverExecutable1);
        caps.setCapability(AndroidMobileCapabilityType.RECREATE_CHROME_DRIVER_SESSIONS, true);
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, this.appPackage);  
        try {
        driver = new AndroidDriver<>(new URL ("http://127.0.0.1:" + port), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void tearDown() {
        if (driver != null) {
          driver.quit();
        }
      }

    @ScenarioScope
    public void runTest(int port) {
        try {
        initialize(port);
        } catch (Exception e) {
        e.printStackTrace();
        }
  }
}

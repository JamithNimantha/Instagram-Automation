package com.jamith.instagramautomation;


import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author Jamith Nimantha
 */

@Component
public class DriverInitializer {
    FirefoxDriver getFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "/Users/jamithnimantha/DebuggerMe/Fiverr/Instagram Automation/geckodriver");
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        File pathBinary = new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin");

        FirefoxOptions options = new FirefoxOptions();
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);

        DesiredCapabilities desired = DesiredCapabilities.firefox();
        desired.setPlatform(Platform.ANY);
//        desired.setCapability("version", "66");
        desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));

        options.setHeadless(false); // false make visualise
        return new FirefoxDriver(options);


//        System.setProperty("webdriver.gecko.driver", "C:\\jamith\\\\src\\main\\resources\\geckodriver.exe");
//        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
//        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
//        File pathBinary = new File("C:\\Users\\User\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
//
//        FirefoxOptions options = new FirefoxOptions();
//        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
//
//        DesiredCapabilities desired = DesiredCapabilities.firefox();
//        desired.setPlatform(Platform.WIN10);
//        desired.setCapability("version", "66");
//        desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
//
//        options.setHeadless(false); // false make visualise
//        return new FirefoxDriver(options);
    }

}

package com.awdenegest.appium.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;

public class DriverFactory {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options();

                // Path to APK on local computer
                File apkFile = new File("C:\\Users\\keysy\\AndroidStudioProjects\\AmharicNameCalculator\\app\\release\\app-release.apk");
                options.setApp(apkFile.getAbsolutePath());

                // Set package and main activity
                options.setAppPackage("com.example.amharicnamecalculator");
                options.setAppActivity("com.example.amharicnamecalculator.MainActivity");

                options.setDeviceName("Android Device");
                options.setPlatformName("Android");
                options.setAutomationName("UiAutomator2");

                // Optional: keep app data, skip lock screen
                options.setNoReset(true);
                options.setSkipUnlock(true);

                // Start the driver
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize AndroidDriver", e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

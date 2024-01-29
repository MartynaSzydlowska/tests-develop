package com.gitlab.rmarzec.framework.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.time.Duration;

public class DriverFactory {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public WebDriver initDriver() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("intl.accept_languages", "pl-PL");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("-private");
        WebDriverManager.getInstance(FirefoxDriver.class).driverVersion("0.30.0").setup();
        WebDriver webDriver = new FirefoxDriver(firefoxOptions);
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        tlDriver.set(webDriver);
        return getDriver();
    }
}

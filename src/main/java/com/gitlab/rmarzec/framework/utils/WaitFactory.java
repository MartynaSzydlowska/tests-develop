package com.gitlab.rmarzec.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitFactory {
    private WaitFactory() {
    }

    public static WebDriverWait createWait(Duration duration, WebDriver webDriver) {
        return new WebDriverWait(webDriver, duration, Duration.ofMillis(100));
    }
}

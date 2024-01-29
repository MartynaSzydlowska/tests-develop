package com.gitlab.rmarzec.framework.w3schools;

import com.gitlab.rmarzec.framework.utils.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class W3SchoolsCookiesComponent {
    private static final By ACCEPT_BUTTON = By.id("accept-choices");
    private final WebDriver webDriver;

    public W3SchoolsCookiesComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void acceptCookies() {
        WebElement acceptButton = webDriver.findElement(ACCEPT_BUTTON);

        WebDriverWait wait = WaitFactory.createWait(Duration.ofSeconds(3), webDriver);
        wait.until(ExpectedConditions.elementToBeClickable(acceptButton));
        acceptButton.click();
    }
}

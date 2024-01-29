package com.gitlab.rmarzec.framework.google;

import com.gitlab.rmarzec.framework.utils.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCookiesComponent {
    private static final By ACCEPT_BUTTON = By.xpath("//div[text()='Zaakceptuj wszystko']");
    private final WebDriver webDriver;

    public GoogleCookiesComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void acceptCookies() {
        WebElement acceptButton = webDriver.findElement(ACCEPT_BUTTON);

        WebDriverWait wait = WaitFactory.createWait(Duration.ofSeconds(5), webDriver);
        wait.until(ExpectedConditions.elementToBeClickable(acceptButton));
        acceptButton.click();

        wait.until(ExpectedConditions.invisibilityOf(acceptButton));
    }
}

package com.gitlab.rmarzec.framework.youtube;

import com.gitlab.rmarzec.framework.utils.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YouTubeCookiesComponent {
    private static final By ACCEPT_BUTTON = By.xpath("//button[descendant::text()='Accept all']");
    private final WebDriver webDriver;

    public YouTubeCookiesComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void acceptCookies() {
        WebElement acceptButton = webDriver.findElement(ACCEPT_BUTTON);

        WebDriverWait wait = WaitFactory.createWait(Duration.ofSeconds(3), webDriver);
        wait.until(ExpectedConditions.elementToBeClickable(acceptButton));
        acceptButton.click();
    }
}

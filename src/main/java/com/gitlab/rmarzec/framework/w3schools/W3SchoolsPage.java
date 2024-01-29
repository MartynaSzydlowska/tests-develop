package com.gitlab.rmarzec.framework.w3schools;

import com.gitlab.rmarzec.framework.utils.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class W3SchoolsPage {
    private static final By TRY_IT_YOURSELF_BUTTON = By.linkText("Try it Yourself »");
    private final WebDriver webDriver;
    private final W3SchoolsCookiesComponent w3SchoolsCookiesComponent;

    public W3SchoolsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.w3SchoolsCookiesComponent = new W3SchoolsCookiesComponent(webDriver);
    }

    public TryItYourselfPage clickTryItYourself() {
        Set<String> currentWindowHandles = new HashSet<>(webDriver.getWindowHandles());

        webDriver.findElement(TRY_IT_YOURSELF_BUTTON).click();

        WebDriverWait wait = WaitFactory.createWait(Duration.ofSeconds(3), webDriver);
        wait.until(ExpectedConditions.numberOfWindowsToBe(currentWindowHandles.size() + 1));

        for (String windowHandle : webDriver.getWindowHandles()) {
            if (!currentWindowHandles.contains(windowHandle)) {
                webDriver.switchTo().window(windowHandle);
                break;
            }
        }

        TryItYourselfPage tryItYourselfPage = new TryItYourselfPage(webDriver);

        return tryItYourselfPage;
    }

    public W3SchoolsPage acceptCookies() {
        w3SchoolsCookiesComponent.acceptCookies();
        return this;
    }
}

package com.gitlab.rmarzec.framework.google;

import com.gitlab.rmarzec.framework.utils.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GooglePage {
    private static final By SEARCH_FIELD = By.cssSelector("[title='Szukaj']");
    private static final By SEARCH_FORM = By.cssSelector("[role='search']");
    private static final By LUCKY_BUTTON = By.cssSelector("[value='Szczęśliwy traf']");

    private final GoogleCookiesComponent googleCookiesComponent;
    private final WebDriver webDriver;

    public GooglePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.googleCookiesComponent = new GoogleCookiesComponent(webDriver);
    }

    public GooglePage enterTextInSearchField(String text) {
        webDriver.findElement(SEARCH_FIELD).sendKeys(text);
        return this;
    }

    public GooglePage clickLuckyButton() {
        WebElement luckyButton = webDriver.findElement(SEARCH_FORM).findElement(LUCKY_BUTTON);

        WebDriverWait wait = WaitFactory.createWait(Duration.ofSeconds(3), webDriver);
        wait.until(ExpectedConditions.elementToBeClickable(luckyButton));
        luckyButton.click();

        return this;
    }

    public GooglePage acceptCookies() {
        googleCookiesComponent.acceptCookies();
        return this;
    }
}

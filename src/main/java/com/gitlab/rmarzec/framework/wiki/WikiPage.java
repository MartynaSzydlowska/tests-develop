package com.gitlab.rmarzec.framework.wiki;

import com.gitlab.rmarzec.framework.utils.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class WikiPage {
    private static final By LANGUAGES_BUTTON = By.id("p-lang-btn");
    private static final By LANGUAGES_LIST = By.className("interlanguage-link");
    private static final By LANGUAGE_LINK = By.cssSelector("a");

    private final WebDriver webDriver;

    public WikiPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public List<Language> getAllLanguages() {
        WebDriverWait wait = WaitFactory.createWait(Duration.ofSeconds(3), webDriver);
        wait.until(ExpectedConditions.elementToBeClickable(LANGUAGES_BUTTON));

        WebElement languageDropdown = webDriver.findElement(LANGUAGES_BUTTON);
        languageDropdown.click();

        return webDriver.findElements(LANGUAGES_LIST).stream()
                .map(webElement -> new Language(
                        webElement.getAttribute("textContent"),
                        webElement.findElement(LANGUAGE_LINK).getAttribute("href")
                ))
                .collect(Collectors.toList());
    }
}

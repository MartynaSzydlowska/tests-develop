package com.gitlab.rmarzec.framework.w3schools;

import com.gitlab.rmarzec.framework.common.SelectOption;
import com.gitlab.rmarzec.framework.utils.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TryItYourselfPage {
    private final WebDriver webDriver;

    private static final By IFRAME_RESULT = By.id("iframeResult");
    private static final By HEADER = By.tagName("h1");
    private static final By CAR_SELECT = By.id("cars");

    public TryItYourselfPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        WebDriverWait wait = WaitFactory.createWait(Duration.ofSeconds(10), webDriver);
        wait.until(ExpectedConditions.presenceOfElementLocated(IFRAME_RESULT));
    }

    public String getHeader() {
        webDriver.switchTo().frame(webDriver.findElement(IFRAME_RESULT));
        return webDriver.findElement(HEADER).getText();
    }

    public TryItYourselfPage selectCar(CarMake carMake) {
        Select carSelect = new Select(webDriver.findElement(CAR_SELECT));
        carSelect.selectByVisibleText(carMake.getLabel());
        return this;
    }

    public SelectOption getSelectedCar() {
        Select carSelect = new Select(webDriver.findElement(CAR_SELECT));
        WebElement selectedOption = carSelect.getFirstSelectedOption();
        return new SelectOption(selectedOption.getAttribute("value"),
                selectedOption.getText());
    }
}

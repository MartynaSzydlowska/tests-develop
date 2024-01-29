package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.common.SelectOption;
import com.gitlab.rmarzec.framework.google.GooglePage;
import com.gitlab.rmarzec.framework.w3schools.CarMake;
import com.gitlab.rmarzec.framework.w3schools.TryItYourselfPage;
import com.gitlab.rmarzec.framework.w3schools.W3SchoolsPage;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class Task3Test extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(Task3Test.class);

    private static final String SELECT_TAG_EXPECTED_URL = "https://www.w3schools.com/tags/tag_select.asp";

    @Test
    public void Task3Test() {
        webDriver.get("https://www.google.com/");
        GooglePage googlePage = new GooglePage(webDriver);
        googlePage.acceptCookies();

        googlePage.enterTextInSearchField("HTML select tag - W3Schools");
        googlePage.clickLuckyButton();

        String currentUrl = webDriver.getCurrentUrl();
        if (!SELECT_TAG_EXPECTED_URL.equals(currentUrl)) {
            logger.info("Lucky search directed us to: {}, changing page to: {}", currentUrl, SELECT_TAG_EXPECTED_URL);
            webDriver.get(SELECT_TAG_EXPECTED_URL);
        }

        W3SchoolsPage w3SchoolsPage = new W3SchoolsPage(webDriver);
        w3SchoolsPage.acceptCookies();

        TryItYourselfPage tryItYourselfPage = w3SchoolsPage.clickTryItYourself();
        String header = tryItYourselfPage.getHeader();
        logger.info("Header is: {}", header);

        tryItYourselfPage.selectCar(CarMake.OPEL);
        SelectOption selectedCar = tryItYourselfPage.getSelectedCar();
        logger.info("{}", selectedCar);

        Assertions.assertThat(selectedCar).isEqualTo(new SelectOption("opel", "Opel"));
    }
}

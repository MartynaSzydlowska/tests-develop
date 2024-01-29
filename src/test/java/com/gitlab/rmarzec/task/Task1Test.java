package com.gitlab.rmarzec.task;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;


public class Task1Test extends BaseTest {
    private static final String ONET_URL = "https://www.onet.pl/";

    @Test
    public void Task1Test() {
        webDriver.get(ONET_URL);
        String currentUrl = webDriver.getCurrentUrl();

        Assertions.assertThat(currentUrl).isEqualTo(ONET_URL);
    }
}

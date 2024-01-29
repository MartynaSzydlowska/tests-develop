package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.wiki.Language;
import com.gitlab.rmarzec.framework.wiki.WikiPage;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;


public class Task2Test extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(Task2Test.class);

    @Test
    public void Task2Test() {
        webDriver.get("https://pl.wikipedia.org/wiki/Wiki");

        WikiPage wiki = new WikiPage(webDriver);
        List<Language> allLanguages = wiki.getAllLanguages();

        for (Language language : allLanguages) {
            String name = language.getName();
            if ("English".equals(name)) {
                logger.info("Language: {}, link {}", name, language.getUrl());
            } else {
                logger.info("Language: {}", name);
            }
        }

        Assertions.assertThat(allLanguages).isNotEmpty();
    }
}

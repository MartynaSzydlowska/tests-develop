package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.DriverFactory;
import com.gitlab.rmarzec.framework.youtube.YTTile;
import com.gitlab.rmarzec.framework.youtube.YouTubePage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;


public class Task4Test extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(Task4Test.class);

    @Test
    public void Task4Test() {
        webDriver.get("https://www.youtube.com/");
        YouTubePage youTubePage = new YouTubePage(webDriver);
        youTubePage.acceptCookies();

        List<YTTile> tiles = youTubePage.getTiles(12);
        List<String> nonLiveVideosTitlesAndDurations = tiles.stream()
                .filter(this::isNotLive)
                .map(tile -> String.format("[title: %s, duration: %s]", tile.getTitle(), tile.getLength()))
                .collect(Collectors.toList());
        logger.info("Non live videos titles and durations: {}", nonLiveVideosTitlesAndDurations);

        Assertions.assertThat(tiles.size()).isEqualTo(12);
    }

    private boolean isNotLive(YTTile tile) {
        return !YouTubePage.LIVE.equals(tile.getLength());
    }
}

package com.gitlab.rmarzec.framework.youtube;

import com.gitlab.rmarzec.framework.utils.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YouTubePage {
    public static final String LIVE = "live";
    private static final By VIDEO = By.cssSelector("ytd-rich-item-renderer");
    private static final By VIDEO_TITLE = By.id("video-title");
    private static final By CHANNEL_NAME = By.id("channel-name");
    private static final By AD_INDICATOR = By.cssSelector("ytd-ad-slot-renderer");
    private static final By SHORT_INDICATOR = By.cssSelector("ytd-rich-grid-slim-media[is-short]");
    private static final By LIVE_VIDEO_INDICATOR = By.cssSelector("ytd-thumbnail[is-live-video]");
    private static final By VIDEO_LENGTH = By.id("length");
    private final WebDriver webDriver;
    private final YouTubeCookiesComponent youTubeCookiesComponent;


    public YouTubePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.youTubeCookiesComponent = new YouTubeCookiesComponent(webDriver);
    }

    public YouTubePage acceptCookies() {
        youTubeCookiesComponent.acceptCookies();
        return this;
    }

    public List<YTTile> getTiles(int count) {
        WebDriverWait wait = WaitFactory.createWait(Duration.ofSeconds(10), webDriver);
        wait.until(webDriver -> getVideos(webDriver).count() >= 12);

        return getVideos(webDriver).limit(count)
                .map(this::mapToYouTubeTile)
                .collect(Collectors.toList());
    }

    private YTTile mapToYouTubeTile(WebElement webElement) {
        String videoTitle = webElement.findElement(VIDEO_TITLE).getText();
        String channelName = webElement.findElement(CHANNEL_NAME).getText();
        String length = webElement.findElements(LIVE_VIDEO_INDICATOR).isEmpty()
                ? webElement.findElement(VIDEO_LENGTH).getAttribute("textContent")
                : LIVE;
        YTTile ytTile = new YTTile();
        ytTile.setTitle(videoTitle);
        ytTile.setChannel(channelName);
        ytTile.setLength(length);
        return ytTile;
    }

    private Stream<WebElement> getVideos(WebDriver webDriver) {
        return webDriver.findElements(VIDEO).stream()
                .filter(this::isNotAd)
                .filter(this::isNotShort);
    }

    private boolean isNotAd(WebElement webElement) {
        return webElement.findElements(AD_INDICATOR).isEmpty();
    }

    private boolean isNotShort(WebElement webElement) {
        return webElement.findElements(SHORT_INDICATOR).isEmpty();
    }
}

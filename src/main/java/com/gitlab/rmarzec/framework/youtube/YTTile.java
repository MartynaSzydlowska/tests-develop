package com.gitlab.rmarzec.framework.youtube;

public class YTTile {
    String title;
    String channel;
    String length;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "YTTile{" +
                "title='" + title + '\'' +
                ", channel='" + channel + '\'' +
                ", length='" + length + '\'' +
                '}';
    }
}

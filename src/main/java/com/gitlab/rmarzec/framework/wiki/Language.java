package com.gitlab.rmarzec.framework.wiki;

public class Language {
    private final String name;
    private final String url;

    public Language(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Language{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

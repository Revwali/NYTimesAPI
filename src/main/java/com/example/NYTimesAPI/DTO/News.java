package com.example.NYTimesAPI.DTO;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
needs to be upldated to match json from nytimes
 */
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class News {
    //private Results[] results;
    private String title;
    private String section;
    private String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public News(String title, String section, String url) {
        this.title = title;
        this.section = section;
        this.url = url;
    }

    public News() {
        super();

    }

}

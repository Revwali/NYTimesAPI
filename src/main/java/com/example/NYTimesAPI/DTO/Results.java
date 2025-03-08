package com.example.NYTimesAPI.DTO;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {

    private String title;
    private String secton;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSecton() {
        return secton;
    }

    public void setSecton(String secton) {
        this.secton = secton;
    }

    public Results(String title, String secton) {
        super();
        this.title = title;
        this.secton = secton;
    }

    public Results() {
        super();
    }


}

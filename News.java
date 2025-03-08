package com.example.demo;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class News {
    //private Results[] results;
    private String title;
    private String section;

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

    public News(String title, String section) {
        super();
        this.title = title;
        this.section = section;
    }

    public News() {
        super();
/*	}
	public Results[] getResults() {
		return results;
	}
	public void setResults(Results[] results) {
		this.results = results;
	}*/




        /*
         * private Results[] results;
         *
         * public News(Results[] results) { super(); this.results = results; }
         *
         * public News() { super(); }
         *
         * public Results[] getResults() { return results; }
         *
         * public void setResults(Results[] results) { this.results = results; }
         *
         */
    }

}

package com.example.NYTimesAPI.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.NYTimesAPI.DTO.News;
import com.example.NYTimesAPI.service.NYTimesService;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController()
public class Controller {

    	@Autowired
        private NYTimesService nyTimesService;

    // @CrossOrigin(origins = "*")
    @GetMapping("/g")
    public News sayHi() throws JsonMappingException, JsonProcessingException, ParseException {
        Map<String, ArrayList<Map<String, String>>> res = new HashMap<String, ArrayList<Map<String, String>>>();


      /*  ResponseEntity<Map> s = restTemplate.getForEntity(
                "https://api.nytimes.com/svc/topstories/v2/arts.json?api-key=udAHowoeyoAWtCtKiVEdEp8E0UYKHQ7D",
                Map.class);

        res = s.getBody();

        News news = new News();
        Results[] results = new Results[3];
        results[0] = new
                Results();
        results[0].setTitle(res.get("results").get(0).get("title"));
        //  news.setResults(results);
        news.setSection(res.get("results").get(0).get("section"));
        news.setTitle(res.get("results").get(0).get("title"));
        return news;
        */
        return new News();


    }
}

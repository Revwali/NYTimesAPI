package com.example.NYTimesAPI.service;

import com.example.NYTimesAPI.DTO.News;
import com.example.NYTimesAPI.customjsonconverterimpl.JsonToNewsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NYTimesService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JsonToNewsConverter resultsConverter;


    private  final String arts = "arts.json";
    private  final String science = "science.json";
    private  final String home = "home.json";
    private  final String us = "us.json";
    private  final String world = "world.json";



    @Value("${NYTimesAPIUri}")
    private String nytimesuri;

    @Value("${NYTimesAPIKey}")
    private String apiKey;

    public List<News> getResultsFromNYTimes(String topic){
        nytimesuri = buildUri(nytimesuri, apiKey,topic);
        Map<String, List<Map<String, String>>> josnResult =   restTemplate.getForObject(nytimesuri, Map.class);
   return resultsConverter.convertJsonContentToResults(josnResult.get("results"));
    }

    public News getOneStoryFromNYTimes(String topic){
        nytimesuri = buildUri(nytimesuri,apiKey,topic);
        return null;
    }

    private String buildUri(String nyTimesUri, String apiKey, String topic) {
        if(topic != null)
      return  nyTimesUri = nyTimesUri+topic+"?api-key="+apiKey;
        else
            return  nyTimesUri = nyTimesUri+arts+"?api-key="+apiKey;
    }

}

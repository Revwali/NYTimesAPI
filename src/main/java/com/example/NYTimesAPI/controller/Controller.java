package com.example.NYTimesAPI.controller;


import java.util.ArrayList;



import com.example.NYTimesAPI.DTO.News;
import com.example.NYTimesAPI.service.NYTimesService;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.List;


@RestController()
@RequestMapping("/NYTimes/topStories/")
public class Controller {

    	@Autowired
        private NYTimesService nyTimesService;

    // @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public ResponseEntity<List<News>> getAllResults(@PathVariable(required = false, value = "topic") String topic) throws JsonMappingException, JsonProcessingException, ParseException {


    return ResponseEntity.ok(nyTimesService.getResultsFromNYTimes(topic));
    }




}

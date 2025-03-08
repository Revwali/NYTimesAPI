package com.example.NYTimesAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NYTimesService {

    @Autowired
    private RestTemplate restTemplate;


}

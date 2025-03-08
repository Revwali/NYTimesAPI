package com.example.NYTimesAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/*
  Class to parse the
 */
@Service
public class NYTimesService {

    @Autowired
    private RestTemplate restTemplate;


}

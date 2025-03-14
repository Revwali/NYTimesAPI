package com.example.NYTimesAPI.customjsonconverterimpl;

import com.example.NYTimesAPI.DTO.News;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

/*
this class will be singleton as many requests needs to converted but cannot give each a class
 */
@Component
@Slf4j
public class JsonToNewsConverter {
    public List<News> convertJsonContentToResults(List<Map<String, String>> josnResult) {
      return  stringToJson(josnResult);
    }
    public List<News> stringToJson(List<Map<String, String>> jsonString){

         if(jsonString == null ) return null;

       News oneNews = new News();
       List<News> list = new ArrayList<>(jsonString.size());

           for(Map<String, String> res : jsonString){
              oneNews.setSection( res.get("section") );
              oneNews.setTitle( res.get("title") );
              oneNews.setUrl( res.get("url") );
              list.add(oneNews);
               oneNews = new News();
           }


       return list;



    }



}

package com.flzpenteado.stockquotemanager.service.impl;

import com.flzpenteado.stockquotemanager.dto.stockquote.StockDto;
import com.flzpenteado.stockquotemanager.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class StockService implements IStockService {

    RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/stock";

    public StockService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public void sendNotification(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Map<String, Object> payload = new HashMap<>();
        payload.put("host", "localhost");
        payload.put("port", 8081);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);

        this.restTemplate.postForLocation("http://localhost:8080/notification", entity);
    }


    @Cacheable("stocks")
    public StockDto getStockById(String id){
        String url = baseUrl + "/{id}";
        return this.restTemplate.getForObject(url, StockDto.class, id);
    }

    public boolean stockExists(String id){

        StockDto stock = this.getStockById(id);

        return stock == null ? false : true;
    }

}

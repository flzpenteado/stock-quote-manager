package com.flzpenteado.stockquotemanager.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stockcache")
public class NotificationController {

    @DeleteMapping
    @CacheEvict(value="stocks", allEntries = true)
    public void delete(){
        System.out.println("Cache deleted!!!");
    }
}

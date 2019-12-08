package com.flzpenteado.stockquotemanager.controller;

import com.flzpenteado.stockquotemanager.service.impl.StockQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stock-quote")
public class StockQuoteController {

    @Autowired
    private StockQuoteService service;

    @GetMapping("/")
    public String getAll(){
        return "getAll";
    }


}

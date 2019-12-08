package com.flzpenteado.stockquotemanager.controller;

import com.flzpenteado.stockquotemanager.dto.stockquote.StockQuoteRequestDto;
import com.flzpenteado.stockquotemanager.entity.StockQuote;
import com.flzpenteado.stockquotemanager.service.impl.StockQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stock-quote")
public class StockQuoteController {

    @Autowired
    private StockQuoteService service;

    @GetMapping(value = "")
    public List<StockQuote> getAll(){

        List<StockQuote> list = service.getAll();
        return list;
    }

    @PostMapping
    public ResponseEntity<StockQuote> add(@RequestBody StockQuoteRequestDto quoteDto){
        StockQuote quote = service.save(quoteDto);

        return new ResponseEntity<StockQuote>(quote, HttpStatus.CREATED);
    }
}

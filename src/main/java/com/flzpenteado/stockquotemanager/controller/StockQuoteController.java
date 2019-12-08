package com.flzpenteado.stockquotemanager.controller;

import com.flzpenteado.stockquotemanager.dto.stockquote.StockQuoteDto;
import com.flzpenteado.stockquotemanager.service.impl.StockQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.status;

import java.text.ParseException;
import java.util.*;

@RestController
@RequestMapping("stock-quote")
public class StockQuoteController {

    @Autowired
    private StockQuoteService service;

    @GetMapping("/{id}")
    public ResponseEntity<StockQuoteDto> get (@PathVariable String id){
        StockQuoteDto quote = service.findByQuoteId(id);

        return ResponseEntity.status( HttpStatus.FOUND).body(quote);
    }

    @GetMapping("")
    public List<StockQuoteDto> getAll(){

        List<StockQuoteDto> list = service.getAll();

        return list;
    }

    @PostMapping
    public void add(@RequestBody StockQuoteDto request) {
        service.save(request);
    }
}

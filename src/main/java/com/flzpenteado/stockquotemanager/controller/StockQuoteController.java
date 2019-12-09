package com.flzpenteado.stockquotemanager.controller;

import com.flzpenteado.stockquotemanager.dto.stockquote.StockQuoteDto;
import com.flzpenteado.stockquotemanager.exception.StockNotFoundException;
import com.flzpenteado.stockquotemanager.service.impl.StockQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("quote")
public class StockQuoteController {

    @Autowired
    private StockQuoteService service;

    @GetMapping("/{id}")
    public ResponseEntity<StockQuoteDto> get (@PathVariable String id){
        StockQuoteDto quote = service.findByStockId(id);

        return ResponseEntity.status( HttpStatus.FOUND).body(quote);
    }

    @GetMapping("")
    public ResponseEntity<List<StockQuoteDto>> getAll(){

        List<StockQuoteDto> list = service.getAll();

        return ResponseEntity.status(HttpStatus.FOUND).body(list);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody StockQuoteDto request) {
        try {
            service.save(request);
        } catch (StockNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}

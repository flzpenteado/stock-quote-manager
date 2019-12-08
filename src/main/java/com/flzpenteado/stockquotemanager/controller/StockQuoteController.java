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
    public void add(@RequestBody StockQuoteDto request) throws ParseException {

        System.out.println(request);


//        // TODO: I'm pretty sure that there's a much better way to do this in Java!!!! ;)
//        StockQuoteDto dto = new StockQuoteDto();
//        dto.setId((String) request.get("id"));
//
//        HashMap<String, List<String>> quotes = (HashMap<String, List<String>>) request.get("quotes");
//
//        Set<String> keys = quotes.keySet();
//
//        for(String k: keys){
//            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(k);
//            Float value = Float.parseFloat(String.valueOf(quotes.get(k)));
//            dto.getQuotes().add(new StockQuoteDto.Quote(date, value));
//        }
//
//        service.save(dto);
//        return (ResponseEntity) ResponseEntity.status(HttpStatus.CREATED).body("Created");
    }
}

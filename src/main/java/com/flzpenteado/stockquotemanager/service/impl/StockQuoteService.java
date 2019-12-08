package com.flzpenteado.stockquotemanager.service.impl;

import com.flzpenteado.stockquotemanager.dto.stockquote.StockQuoteDto;
import com.flzpenteado.stockquotemanager.entity.StockQuote;
import com.flzpenteado.stockquotemanager.repository.IStockQuoteRepository;
import com.flzpenteado.stockquotemanager.service.IStockQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockQuoteService implements IStockQuoteService {

    @Autowired
    IStockQuoteRepository repository;

    @Override
    public void save(StockQuoteDto quoteDto) {
//
//        quoteDto.getQuotes().forEach(q -> {
//            StockQuote quote = new StockQuote();
//            quote.setQuoteId(quoteDto.getId());
////            quote.setDate(q.getDate());
////            quote.setValue(q.getValue());
//            repository.save(quote);
//        });
    }

    @Override
    public StockQuoteDto findByQuoteId(String quoteId) {
         List<StockQuote> list = repository.findByQuoteIdEquals(quoteId);

         if(list.size() == 0) return null;

         StockQuoteDto dto = new StockQuoteDto();
         dto.setId(quoteId);

         list.forEach(item -> {
             dto.getQuotes().put(item.getDate(), item.getValue());
         });

         return  dto;
    }

    @Override
    public List<StockQuoteDto> getAll() {
        return null;
    }

//    @Override
//    public List<StockQuoteRequestDto> getAll() {
//
//        List<StockQuote> quotes = repository.findAll();
//
//        quotes.forEach(quote -> {
//
//        });
//
//        return null;
//    }


}

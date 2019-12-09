package com.flzpenteado.stockquotemanager.service.impl;

import com.flzpenteado.stockquotemanager.dto.stockquote.StockQuoteDto;
import com.flzpenteado.stockquotemanager.entity.StockQuote;
import com.flzpenteado.stockquotemanager.repository.IStockQuoteRepository;
import com.flzpenteado.stockquotemanager.service.IStockQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockQuoteService implements IStockQuoteService {

    @Autowired
    IStockQuoteRepository repository;

    @Override
    public void save(StockQuoteDto dto) {

        if(dto.getQuotes().isEmpty()) return;

        dto.getQuotes().forEach((date, value) -> {
            StockQuote quote = new StockQuote();
            quote.setQuoteId(dto.getId());
            quote.setDate(date);
            quote.setValue(value);

            repository.save(quote);
        } );
    }

    private StockQuoteDto convertToDto(String stockId, List<StockQuote> list){
        StockQuoteDto dto = new StockQuoteDto();
        dto.setId(stockId);

        list.forEach(item -> {
            dto.getQuotes().put(item.getDate(), item.getValue());
        });

        return  dto;
    }

    @Override
    public StockQuoteDto findByQuoteId(String stockId) {
         List<StockQuote> quotes = repository.findByQuoteIdEquals(stockId);

         if(quotes.size() == 0) return null;

         return convertToDto(stockId, quotes);
    }

    @Override
    public List<StockQuoteDto> getAll() {
        List<StockQuote> quotes = repository.findAll();

        List<StockQuoteDto> dtoList = new ArrayList<StockQuoteDto>();

        List<String> stockIds = quotes.stream().map(item -> item.getQuoteId()).distinct().collect(Collectors.toList());

        stockIds.forEach(stockId ->{
            List<StockQuote> list =quotes.stream().filter(q -> stockId.equals(q.getQuoteId())).collect(Collectors.toList());
            StockQuoteDto dto = convertToDto(stockId, list);
            dtoList.add(dto);
        });

        return dtoList;
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

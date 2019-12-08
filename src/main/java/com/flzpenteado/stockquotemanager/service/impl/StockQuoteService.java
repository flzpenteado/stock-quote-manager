package com.flzpenteado.stockquotemanager.service.impl;


import com.flzpenteado.stockquotemanager.dto.stockquote.StockQuoteRequestDto;
import com.flzpenteado.stockquotemanager.entity.StockQuote;
import com.flzpenteado.stockquotemanager.repository.IStockQuoteRepository;
import com.flzpenteado.stockquotemanager.service.IStockQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockQuoteService implements IStockQuoteService {

    @Autowired
    IStockQuoteRepository repository;

    @Override
    public StockQuote save(StockQuoteRequestDto quoteDto) {
        StockQuote quote = quoteDto.toEntity();
        return repository.save(quote);
    }

    @Override
    public Optional<StockQuote> findByQuoteId(String quoteId) {
        return repository.findByQuoteIdEquals(quoteId);
    }

    @Override
    public List<StockQuote> getAll() {



        return repository.findAll();
    }


}

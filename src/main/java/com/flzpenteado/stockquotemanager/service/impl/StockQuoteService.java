package com.flzpenteado.stockquotemanager.service.impl;


import com.flzpenteado.stockquotemanager.entity.StockQuote;
import com.flzpenteado.stockquotemanager.repository.IStockQuoteRepository;
import com.flzpenteado.stockquotemanager.service.IStockQuoteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StockQuoteService implements IStockQuoteService {

    @Autowired
    IStockQuoteRepository repository;

    @Override
    public StockQuote save(StockQuote quote) {
        return repository.save(quote);
    }

    @Override
    public Optional<StockQuote> findByQuoteId(String quoteId) {
        return repository.findByQuoteIdEquals(quoteId);
    }
}

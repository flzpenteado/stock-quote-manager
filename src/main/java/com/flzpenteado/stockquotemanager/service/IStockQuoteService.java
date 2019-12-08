package com.flzpenteado.stockquotemanager.service;

import com.flzpenteado.stockquotemanager.entity.StockQuote;

import java.util.Optional;

public interface IStockQuoteService {
    StockQuote save (StockQuote quote);

    Optional<StockQuote> findByQuoteId(String quoteId);
}

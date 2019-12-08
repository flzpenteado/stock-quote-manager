package com.flzpenteado.stockquotemanager.service;

import com.flzpenteado.stockquotemanager.dto.stockquote.StockQuoteRequestDto;
import com.flzpenteado.stockquotemanager.entity.StockQuote;

import java.util.List;
import java.util.Optional;

public interface IStockQuoteService {
    StockQuote save (StockQuoteRequestDto quoteDto);

    Optional<StockQuote> findByQuoteId(String quoteId);

    List<StockQuote> getAll();
}

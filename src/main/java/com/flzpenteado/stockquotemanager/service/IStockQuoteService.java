package com.flzpenteado.stockquotemanager.service;

import com.flzpenteado.stockquotemanager.dto.stockquote.StockQuoteDto;

import java.util.List;

public interface IStockQuoteService {
    void save (StockQuoteDto quoteDto);

    StockQuoteDto findByQuoteId(String quoteId);

    List<StockQuoteDto> getAll();
}

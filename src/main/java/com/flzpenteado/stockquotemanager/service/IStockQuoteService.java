package com.flzpenteado.stockquotemanager.service;

import com.flzpenteado.stockquotemanager.dto.stockquote.StockQuoteDto;

import java.util.List;

public interface IStockQuoteService {
    void save (StockQuoteDto quoteDto) throws Exception;

    StockQuoteDto findByStockId(String quoteId);

    List<StockQuoteDto> getAll();
}

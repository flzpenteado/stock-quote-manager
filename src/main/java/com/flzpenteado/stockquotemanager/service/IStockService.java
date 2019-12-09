package com.flzpenteado.stockquotemanager.service;

import com.flzpenteado.stockquotemanager.dto.stockquote.StockDto;

public interface IStockService {
    StockDto getStockById(String id);

    public boolean stockExists(String id);
}
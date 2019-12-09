package com.flzpenteado.stockquotemanager.exception;

public class StockNotFoundException extends RuntimeException {
    public StockNotFoundException(String errorMessage){
        super(errorMessage);

    }
}

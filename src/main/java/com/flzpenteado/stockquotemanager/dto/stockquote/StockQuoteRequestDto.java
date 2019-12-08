package com.flzpenteado.stockquotemanager.dto.stockquote;

import com.flzpenteado.stockquotemanager.entity.StockQuote;

import java.util.Date;

public class StockQuoteRequestDto {

    private Long id;

    private String quoteId;

    private Date date;

    private Float value;

    public StockQuoteRequestDto(Long id, String quoteId, Date date, Float value){
        this.id = id;
        this.quoteId = quoteId;
        this.date = date;
        this.value = value;
    }

    public StockQuote toEntity(){
        StockQuote quote = new StockQuote();
        quote.setQuoteId(this.quoteId);
        quote.setDate(this.date);
        quote.setValue(this.value);

        return quote;
    }
}

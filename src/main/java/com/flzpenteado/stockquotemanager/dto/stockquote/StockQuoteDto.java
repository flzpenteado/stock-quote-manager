package com.flzpenteado.stockquotemanager.dto.stockquote;

import java.util.Date;
import java.util.HashMap;

public class StockQuoteDto {
    private String id;
    private HashMap<String, Float> quotes;

    public HashMap<String, Float> getQuotes() {
        if(quotes == null){
            quotes = new HashMap<String, Float>();
        }
        return quotes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public static class Quote{
        private Date date;
        private Float value;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Float getValue() {
            return value;
        }

        public void setValue(Float value) {
            this.value = value;
        }

        public Quote(Date date, Float value){
            this.date = date;
            this.value = value;
        }
    }

}
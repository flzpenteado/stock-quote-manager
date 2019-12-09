package com.flzpenteado.stockquotemanager.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(StockQuote.CompositeId.class)
public class StockQuote implements Serializable {

    private static final long serialVersionUID = 1693850165739564098L;

    @Id
    @Column(name = "quote_id")
    private String quoteId;

    @Id
    private String date;

    private Float value;

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    static class CompositeId implements Serializable {
        protected String quoteId;
        protected String date;

        private CompositeId() {
        }

        private CompositeId(String quoteId, String date) {
            this.quoteId = quoteId;
            this.date = date;
        }
    }

}
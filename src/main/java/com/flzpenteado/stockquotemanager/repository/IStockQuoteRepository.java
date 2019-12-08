package com.flzpenteado.stockquotemanager.repository;

import com.flzpenteado.stockquotemanager.entity.StockQuote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IStockQuoteRepository extends JpaRepository<StockQuote, Long> {

    Optional<StockQuote> findByQuoteIdEquals(String quoteId);
}
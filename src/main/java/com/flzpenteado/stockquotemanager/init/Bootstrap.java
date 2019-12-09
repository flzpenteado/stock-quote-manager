package com.flzpenteado.stockquotemanager.init;

import com.flzpenteado.stockquotemanager.service.impl.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bootstrap {

    @Autowired
    private StockService stockService;

    @PostConstruct
    public void init(){
        stockService.sendNotification();
    }
}

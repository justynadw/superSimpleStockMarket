package com.company.sssm;

/**
 * Created by justynadworakowska on 22.10.2016.
 */
public enum StockMarket {
    TEA_STOCK(new Stock(StockSymbol.TEA, StockType.COMMON, 0, 1)),
    POP_STOCK(new Stock(StockSymbol.POP, StockType.COMMON, 0.08, 1)),
    ALE_STOCK(new Stock(StockSymbol.ALE, StockType.COMMON, 0.23, 0.6)),
    GIN_STOCK(new Stock(StockSymbol.GIN, StockType.PREFERRED, 0.08, 2, 1)),
    JOE_STOCK(new Stock(StockSymbol.JOE, StockType.COMMON, 0.13, 2.5))
    ;
    public Stock stock;

    StockMarket(Stock stock) {
        this.stock = stock;
    }
}

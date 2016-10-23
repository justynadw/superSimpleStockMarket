package com.company.sssm;

import java.math.BigDecimal;

/**
 * Created by justynadworakowska on 22.10.2016.
 */
public enum StockMarket {
    TEA_STOCK(StockSymbol.TEA, StockType.COMMON, BigDecimal.valueOf(0), BigDecimal.valueOf(1)),
    POP_STOCK(StockSymbol.POP, StockType.COMMON, BigDecimal.valueOf(0.08), BigDecimal.valueOf(1)),
    ALE_STOCK(StockSymbol.ALE, StockType.COMMON, BigDecimal.valueOf(0.23), BigDecimal.valueOf(0.6)),
    GIN_STOCK(StockSymbol.GIN, StockType.PREFERRED, BigDecimal.valueOf(0.08), BigDecimal.valueOf(2, 1)),
    JOE_STOCK(StockSymbol.JOE, StockType.COMMON, BigDecimal.valueOf(0.13), BigDecimal.valueOf(2.5))
    ;

    private StockSymbol symbol;
    private StockType type;
    private BigDecimal lastDividend;
    private BigDecimal fixedDividend;
    private BigDecimal parValue;

    StockMarket(StockSymbol symbol, StockType type, BigDecimal lastDividend, BigDecimal fixedDividend, BigDecimal parValue) {
        this.symbol = symbol;
        this.type = type;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
    }

    StockMarket(StockSymbol symbol, StockType type, BigDecimal lastDividend, BigDecimal parValue) {
        this.symbol = symbol;
        this.type = type;
        this.lastDividend = lastDividend;
        this.parValue = parValue;
    }
}

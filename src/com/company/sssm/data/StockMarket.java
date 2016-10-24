package com.company.sssm.data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by justynadworakowska on 22.10.2016.
 */
public enum StockMarket {
    TEA_STOCK(StockSymbol.TEA, StockType.COMMON, new BigDecimal("0.00"), new BigDecimal("1.00")),
    POP_STOCK(StockSymbol.POP, StockType.COMMON, new BigDecimal("0.08"), new BigDecimal("1.00")),
    ALE_STOCK(StockSymbol.ALE, StockType.COMMON, new BigDecimal("0.23"), new BigDecimal("0.60")),
    GIN_STOCK(StockSymbol.GIN, StockType.PREFERRED, new BigDecimal("0.08"), new BigDecimal("0.02"), new BigDecimal("1.00")),
    JOE_STOCK(StockSymbol.JOE, StockType.COMMON, new BigDecimal("0.13"), new BigDecimal("2.50"))
    ;

    public static StockType getTypeForStock(StockSymbol stockSymbol) {
        StockMarket stock = getStockBySymbol(stockSymbol);
        return stock.type;
    }

    public static BigDecimal getLastDividendForStock(StockSymbol stockSymbol) {
        StockMarket stock = getStockBySymbol(stockSymbol);
        return stock.lastDividend;
    }

    public static BigDecimal getFixedDividendForStock(StockSymbol stockSymbol) {
        StockMarket stock = getStockBySymbol(stockSymbol);
        return stock.fixedDividend;
    }

    public static BigDecimal getParValueForStock(StockSymbol stockSymbol) {
        StockMarket stock = getStockBySymbol(stockSymbol);
        return stock.parValue;
    }

    private static StockMarket getStockBySymbol(StockSymbol stockSymbol) {
        return Arrays.asList(values()).stream().filter(stockMarket -> (stockMarket.symbol == stockSymbol))
                .collect(Collectors.toList()).get(0);
    }

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
        this.fixedDividend = BigDecimal.ZERO; //TODO check it
        this.parValue = parValue;
    }
}

package com.company.sssm;

/**
 * Created by justynadworakowska on 22.10.2016.
 */
public class Stock {
    private StockSymbol symbol;
    private StockType type;
    private double lastDividend;
    private double fixedDividend;
    private double parValue;

    public Stock(StockSymbol symbol, StockType type, double lastDividend, double fixedDividend, double parValue) {
        this.symbol = symbol;
        this.type = type;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
    }

    public Stock(StockSymbol symbol, StockType type, double lastDividend, double parValue) {
        this.symbol = symbol;
        this.type = type;
        this.lastDividend = 0;
        this.lastDividend = lastDividend;
        this.parValue = parValue;
    }

    public StockSymbol getSymbol() {
        return symbol;
    }

    public StockType getType() {
        return type;
    }

    public double getLastDividend() {
        return lastDividend;
    }

    public double getFixedDividend() {
        return fixedDividend;
    }

    public double getParValue() {
        return parValue;
    }
}

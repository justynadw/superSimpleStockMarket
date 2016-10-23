package com.company.sssm;

/**
 * Created by justynadworakowska on 22.10.2016.
 */
public class Formulas {

    public double dividendYield (StockSymbol stockSymbol, double price){
        double lastDividend = 0.0;
        double fixedDividend = 0.0;
        double parValue = 0.0;

        return StockType.COMMON == checkStockType(stockSymbol)
                ? Math.commonDividendYield(price, lastDividend)
                : Math.preferredDividendYield(price, fixedDividend, parValue);
    }

    private StockType checkStockType(StockSymbol stockSymbol) {
        return null;
    }

//    public double dividedYield (StockSymbol stockSymbol, double price){
//
//    }
}

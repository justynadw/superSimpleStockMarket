package com.company.sssm;

import java.math.BigDecimal;

/**
 * Created by justynadworakowska on 22.10.2016.
 */
public class Formulas {

    public BigDecimal dividendYield (StockSymbol stockSymbol, BigDecimal price){
        BigDecimal lastDividend = BigDecimal.valueOf(0.0);
        BigDecimal fixedDividend = BigDecimal.valueOf(0.0);
        BigDecimal parValue = BigDecimal.valueOf(0.0);

        return StockType.COMMON == checkStockType(stockSymbol)
                ? Mathematics.commonDividendYield(price, lastDividend)
                : Mathematics.preferredDividendYield(price, fixedDividend, parValue);
    }

    private StockType checkStockType(StockSymbol stockSymbol) {
        return null;
    }

//    public double dividedYield (StockSymbol stockSymbol, double price){
//
//    }
}

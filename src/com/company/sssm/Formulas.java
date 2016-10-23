package com.company.sssm;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;

/**
 * Created by justynadworakowska on 22.10.2016.
 */
public class Formulas {

    public static BigDecimal dividendYield(StockSymbol stockSymbol, BigDecimal price){

        return StockType.COMMON == checkStockType(stockSymbol)
                ? Mathematics.commonDividendYield(price, StockMarket.getLastDividendForStock(stockSymbol))
                : Mathematics.preferredDividendYield(price, StockMarket.getFixedDividendForStock(stockSymbol),
                StockMarket.getParValueForStock(stockSymbol));
    }

    private static StockType checkStockType(StockSymbol stockSymbol) {
        return StockMarket.getTypeForStock(stockSymbol);
    }

    public static BigDecimal peRatio(StockSymbol stockSymbol, BigDecimal price){
        BigDecimal dividendYield = dividendYield(stockSymbol, price);
        return Mathematics.peRatio(price, dividendYield);
    }

    public void recordATrade (HashMap<Timestamp, Trade> stockTrade, Trade trade) {
        stockTrade.put(new Timestamp(System.currentTimeMillis()), trade);

    }

    public BigDecimal geometricMean () {
        return null;
    }

    public BigDecimal volumeWeightedStockPrice () {
        return null;
    }
}

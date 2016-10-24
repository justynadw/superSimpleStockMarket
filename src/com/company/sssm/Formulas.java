package com.company.sssm;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Stack;

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

    public static void recordATrade(StockSymbol stockSymbol, Trade trade) {
        Stack<Trade> stockTrades = chooseDataStructure(stockSymbol);
        stockTrades.push(trade);

    }

    public BigDecimal geometricMean () {
        return null;
    }

    public static BigDecimal volumeWeightedStockPrice(StockSymbol stockSymbol) {
        Stack<Trade> dataStructure = chooseDataStructure(stockSymbol);

        BigInteger now = BigInteger.valueOf(System.currentTimeMillis());
        System.out.println(now);
        System.out.println(new Timestamp(now.longValue()));
        System.out.println(new Timestamp(System.currentTimeMillis()));
        System.out.println(new Timestamp(System.currentTimeMillis() - 15*60*1000));
        Timestamp minutesFromNow = new Timestamp(System.currentTimeMillis() - 15*60*1000);
        Timestamp minutesFromNowInNano = new Timestamp(minutesFromNow.getNanos());
        Timestamp minutesFromNowBack = new Timestamp(minutesFromNowInNano.compareTo(minutesFromNow));

        System.out.println(minutesFromNow);
        System.out.println(minutesFromNowInNano);
        System.out.println(minutesFromNowBack);
        return null;
    }

    private static Stack<Trade> chooseDataStructure(StockSymbol stockSymbol) {
        return Trades.DataStructure.getStockTrades(stockSymbol);
    }
}

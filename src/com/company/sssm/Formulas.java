package com.company.sssm;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
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
        Stack<Trade> stockTrades = chooseDataStructure(stockSymbol);
        return volumeWeightedStockPrice(stockTrades);
    }

    public static BigDecimal volumeWeightedStockPrice(Stack<Trade> stockTrades) {
        Timestamp minutes15FromNow  = new Timestamp(System.currentTimeMillis() - 15*60*1000);
        ArrayList<BigDecimal[]> tradeList = new ArrayList();

        Trade trade;
        int trades = stockTrades.size();
        while (trades != 0){
            trade = stockTrades.pop();
            if (trade.getTimestamp().before(minutes15FromNow)) { break;}
            BigDecimal [] tradeTab ={
                    trade.getTradePrice(),
                    new BigDecimal(trade.getQuantityOfShares())
            };

            tradeList.add(tradeTab);
            trades --;
        }
        return Mathematics.volumeWeightedStockPrice(tradeList);
    }

    private static Stack<Trade> chooseDataStructure(StockSymbol stockSymbol) {
        return Trades.DataStructure.getStockTrades(stockSymbol);
    }
}

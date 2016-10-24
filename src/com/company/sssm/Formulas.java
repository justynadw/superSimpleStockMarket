package com.company.sssm;

import com.company.sssm.data.*;
import com.company.sssm.math.Mathematics;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;

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

    public static Stack<Trade> recordATrade(Stack<Trade> trades, Trade trade) {
        trades.push(trade);
        return trades;
    }

    public static BigDecimal geometricMean(Stack<Trade> trades) {
        ArrayList<BigDecimal> prices = trades.stream().map(Trade::getTradePrice)
                .collect(Collectors.toCollection(ArrayList::new));
        return Mathematics.geometricMean(prices);
    }

    public static BigDecimal geometricMean(Stack<Trade>... stackTrades) {
        BigDecimal geometricMean = new BigDecimal("0.0");
        for (Stack<Trade> stactTrade : stackTrades) {
            geometricMean = geometricMean.add(geometricMean(stactTrade));
        }

        return geometricMean;
    }

    public static BigDecimal volumeWeightedStockPrice(Stack<Trade> stockTrades) {
        Timestamp minutes15FromNow  = new Timestamp(System.currentTimeMillis() - 15*60*1000);
        ArrayList<BigDecimal[]> tradeList = new ArrayList();

        ArrayList<Trade> selectedTrades = stockTrades.stream()
                .filter(trade -> minutes15FromNow.before(trade.getTimestamp()))
                .collect(Collectors.toCollection(ArrayList::new));

        for (Trade trade: selectedTrades) {
            BigDecimal [] tradeTab ={
                    trade.getTradePrice(),
                    new BigDecimal(trade.getQuantityOfShares())
            };
            tradeList.add(tradeTab);
        }

        return Mathematics.volumeWeightedStockPrice(tradeList);
    }

}

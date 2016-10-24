package com.company.sssm.data;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by justynadworakowska on 23.10.2016.
 */
public final class Trades {

    final static Stack<Trade> teaTrades = new Stack<>();
    static Stack<Trade> popTrades = new Stack<>();
    static Stack<Trade> aleTrades = new Stack<>();
    static Stack<Trade> ginTrades = new Stack<>();
    static Stack<Trade> joeTrades = new Stack<>();

    public enum DataStructure {
        TEA_TRADES(StockSymbol.TEA, teaTrades),
        POP_TRADES(StockSymbol.POP, popTrades),
        ALE_TRADES(StockSymbol.ALE, aleTrades),
        GIN_TRADES(StockSymbol.GIN, ginTrades),
        JOE_TRADES(StockSymbol.JOE, joeTrades),
        ;

        public static Stack<Trade> getStockTrades (StockSymbol stockSymbol) {
            return Arrays.asList(values()).stream().filter(dataStructure -> (dataStructure.stockSymbol == stockSymbol))
                    .collect(Collectors.toList()).get(0).stockTrades;
        }

        private StockSymbol stockSymbol;
        private Stack<Trade> stockTrades;

        DataStructure(StockSymbol stockSymbol, Stack<Trade> stockTrades) {
            this.stockSymbol = stockSymbol;
            this.stockTrades = stockTrades;
        }
    }
}

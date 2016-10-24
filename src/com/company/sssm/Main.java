package com.company.sssm;

import com.company.sssm.data.StockSymbol;
import com.company.sssm.data.Trade;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Trade> tradesTEA = new Stack<>();
        Stack<Trade> tradesPOP = new Stack<>();
        Stack<Trade> tradesGIN = new Stack<>();

        System.out.println("Super Simple Stock Market");
        System.out.println();

        BigDecimal commonDividendYield = Formulas.dividendYield(StockSymbol.POP, new BigDecimal("1.20"));
        BigDecimal preferredDividendYield = Formulas.dividendYield(StockSymbol.GIN, new BigDecimal("1.32"));

        System.out.println("commonDividendYield = " + commonDividendYield);
        System.out.println("preferredDividendYield = " + preferredDividendYield);

        BigDecimal commonPeRatio = Formulas.peRatio(StockSymbol.GIN, new BigDecimal("1.32"));
        BigDecimal preferredPeRatio = Formulas.peRatio(StockSymbol.JOE, new BigDecimal("2.20"));

        System.out.println("commonPeRatio = " + commonPeRatio);
        System.out.println("preferredPeRatio = " + preferredPeRatio);

        tradesTEA = Formulas.recordATrade(tradesTEA, new Trade(new BigInteger("20"), Trade.Indicator.BUY, new BigDecimal("1.10")));
        tradesTEA = Formulas.recordATrade(tradesTEA, new Trade(new BigInteger("25"), Trade.Indicator.BUY, new BigDecimal("1.00")));
        tradesTEA = Formulas.recordATrade(tradesTEA, new Trade(new BigInteger("23"), Trade.Indicator.SELL, new BigDecimal("0.90")));
        tradesTEA = Formulas.recordATrade(tradesTEA, new Trade(new BigInteger("35"), Trade.Indicator.SELL, new BigDecimal("0.97")));
        tradesTEA = Formulas.recordATrade(tradesTEA, new Trade(new BigInteger("55"), Trade.Indicator.BUY, new BigDecimal("1.05")));
        tradesTEA = Formulas.recordATrade(tradesTEA, new Trade(new BigInteger("21"), Trade.Indicator.BUY, new BigDecimal("1.20")));

        tradesPOP = Formulas.recordATrade(tradesPOP, new Trade(new BigInteger("23"), Trade.Indicator.SELL, new BigDecimal("1.00")));
        tradesPOP = Formulas.recordATrade(tradesPOP, new Trade(new BigInteger("27"), Trade.Indicator.BUY, new BigDecimal("1.20")));
        tradesPOP = Formulas.recordATrade(tradesPOP, new Trade(new BigInteger("30"), Trade.Indicator.SELL, new BigDecimal("1.10")));
        tradesPOP = Formulas.recordATrade(tradesPOP, new Trade(new BigInteger("40"), Trade.Indicator.SELL, new BigDecimal("0.89")));
        tradesPOP = Formulas.recordATrade(tradesPOP, new Trade(new BigInteger("45"), Trade.Indicator.BUY, new BigDecimal("1.15")));
        tradesPOP = Formulas.recordATrade(tradesPOP, new Trade(new BigInteger("23"), Trade.Indicator.BUY, new BigDecimal("1.10")));


        tradesGIN = Formulas.recordATrade(tradesGIN, new Trade(new BigInteger("34"), Trade.Indicator.BUY, new BigDecimal("1.30")));
        tradesGIN = Formulas.recordATrade(tradesGIN, new Trade(new BigInteger("44"), Trade.Indicator.BUY, new BigDecimal("1.20")));
        tradesGIN = Formulas.recordATrade(tradesGIN, new Trade(new BigInteger("26"), Trade.Indicator.BUY, new BigDecimal("0.90")));
        tradesGIN = Formulas.recordATrade(tradesGIN, new Trade(new BigInteger("23"), Trade.Indicator.BUY, new BigDecimal("1.14")));
        tradesGIN = Formulas.recordATrade(tradesGIN, new Trade(new BigInteger("42"), Trade.Indicator.SELL, new BigDecimal("1.02")));
        tradesGIN = Formulas.recordATrade(tradesGIN, new Trade(new BigInteger("53"), Trade.Indicator.SELL, new BigDecimal("1.04")));
        tradesGIN = Formulas.recordATrade(tradesGIN, new Trade(new BigInteger("27"), Trade.Indicator.SELL, new BigDecimal("1.00")));

        System.out.println("Tea trades = " + tradesTEA.size());
        System.out.println("Pop trades = " + tradesPOP.size());
        System.out.println("Gin trades = " + tradesGIN.size());

        BigDecimal geometricMean = Formulas.geometricMean(tradesTEA, tradesPOP, tradesGIN);

        System.out.println("geometricMean = " + geometricMean);

        BigDecimal vwspTea = Formulas.volumeWeightedStockPrice(tradesTEA);
        BigDecimal vwspPop = Formulas.volumeWeightedStockPrice(tradesPOP);
        BigDecimal vwspGin = Formulas.volumeWeightedStockPrice(tradesGIN);

        System.out.println("Tea trades = " + tradesTEA.size());

        System.out.println("vwspTea = " + vwspTea);
        System.out.println("vwspPop = " + vwspPop);
        System.out.println("vwspGin = " + vwspGin);

    }
}

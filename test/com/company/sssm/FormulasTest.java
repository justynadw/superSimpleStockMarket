package com.company.sssm;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by justynadworakowska on 23.10.2016.
 */
public class FormulasTest {
    @Test
    public void dividendYield() throws Exception {
        //given
        StockSymbol aleStockSymbol = StockSymbol.ALE;
        BigDecimal alePrice = new BigDecimal("0.80");
        BigDecimal commonDividendYieldExpected = new BigDecimal("0.29");


        StockSymbol ginStockSymbol = StockSymbol.GIN;
        BigDecimal ginPrice = new BigDecimal("1.20");
        BigDecimal preferredDividendYieldExpected = new BigDecimal("0.0167");

        //when
        BigDecimal commonDividendYield = Formulas.dividendYield(aleStockSymbol, alePrice);
        BigDecimal preferredDividendYield = Formulas.dividendYield(ginStockSymbol, ginPrice);

        //then
        assertEquals(commonDividendYieldExpected, commonDividendYield);
        assertEquals(preferredDividendYieldExpected, preferredDividendYield);
        //TODO check if the method commonDividendYield was called
    }

    @Test
    public void peRatio() throws Exception {
        //given
        StockSymbol aleStockSymbol = StockSymbol.ALE;
        BigDecimal alePrice = new BigDecimal("0.80");
        BigDecimal commonPeRatioExpected = new BigDecimal("2.76");


        StockSymbol ginStockSymbol = StockSymbol.GIN;
        BigDecimal ginPrice = new BigDecimal("1.20");
        BigDecimal preferredPeRatioExpected = new BigDecimal("71.86");

        //when
        BigDecimal commonPeRatio = Formulas.peRatio(aleStockSymbol, alePrice);
        BigDecimal preferredPeRatio = Formulas.peRatio(ginStockSymbol, ginPrice);

        //then
        assertEquals(commonPeRatioExpected, commonPeRatio);
        assertEquals(preferredPeRatioExpected, preferredPeRatio);
        //TODO check if the method commonDividendYield was called
    }

    @Test
    public void recordATrade() throws Exception {
        //given

        //when

        //then

    }

    @Test
    public void geometricMean() throws Exception {
        //given

        //when

        //then

    }

    @Test
    public void volumeWeightedStockPrice() throws Exception {
        //given

        //when

        //then

    }

}
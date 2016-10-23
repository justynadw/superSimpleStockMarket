package com.company.sssm;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by justynadworakowska on 22.10.2016.
 */

public class MathTest {

    @org.junit.Test
    public void commonDividendYield() throws Exception {
        //given
        BigDecimal [] lastDividends = {
                BigDecimal.valueOf(0.00),
                BigDecimal.valueOf(0.08),
                BigDecimal.valueOf(0.23),
                BigDecimal.valueOf(0.03),
                BigDecimal.valueOf(0.13)
        };
        BigDecimal [] prices = {
                BigDecimal.valueOf(1.50),
                BigDecimal.valueOf(0.60),
                BigDecimal.valueOf(2.25),
                BigDecimal.valueOf(1.00),
                BigDecimal.valueOf(2.40)
        };

        BigDecimal dividendYieldExpected [] = {
                BigDecimal.valueOf(0),
                BigDecimal.valueOf(0.13),
                BigDecimal.valueOf(0.10),
                BigDecimal.valueOf(0.03),
                BigDecimal.valueOf(0.05)
        };

        //when
        BigDecimal dividendYield_0 = Mathematics.commonDividendYield(prices[0], lastDividends[0]);
        BigDecimal dividendYield_1 = Mathematics.commonDividendYield(prices[1], lastDividends[1]);
        BigDecimal dividendYield_2 = Mathematics.commonDividendYield(prices[2], lastDividends[2]);
        BigDecimal dividendYield_3 = Mathematics.commonDividendYield(prices[3], lastDividends[3]);
        BigDecimal dividendYield_4 = Mathematics.commonDividendYield(prices[4], lastDividends[4]);

        //then
        assertEquals(dividendYieldExpected[0], dividendYield_0);
        assertEquals(dividendYieldExpected[0], dividendYield_0);
        assertEquals(dividendYieldExpected[0], dividendYield_0);
        assertEquals(dividendYieldExpected[0], dividendYield_0);
        assertEquals(dividendYieldExpected[0], dividendYield_0);

    }

    @org.junit.Test
    public void preferredDividendYield() throws Exception {

    }

}
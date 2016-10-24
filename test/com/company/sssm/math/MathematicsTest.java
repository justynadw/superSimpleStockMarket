package com.company.sssm.math;

import com.company.sssm.math.Mathematics;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by justynadworakowska on 22.10.2016.
 */

public class MathematicsTest {

    public static final BigDecimal[] PRICES = new BigDecimal[]{
            new BigDecimal("1.50"),
            new BigDecimal("0.60"),
            new BigDecimal("2.25"),
            new BigDecimal("1.00"),
            new BigDecimal("2.40"),
    };
    public static final BigDecimal[] COMMON_DIVIDEND_YIELD_EXPECTED = new BigDecimal[]{
            new BigDecimal("0.0"),
            new BigDecimal("0.13"),
            new BigDecimal("0.10"),
            new BigDecimal("0.03"),
            new BigDecimal("0.05")
    };
    public static final BigDecimal[] PREFERRED_DIVIDEND_YIELD_EXPECTED = new BigDecimal[]{
            new BigDecimal("0.0133"),
            new BigDecimal("0.1333"),
            new BigDecimal("0.0080"),
            new BigDecimal("0.0900"),
            new BigDecimal("0.1146")
    };

    @Test
    public void commonDividendYield() throws Exception {
        //given
        BigDecimal [] lastDividends = {
                new BigDecimal("0.0"),
                new BigDecimal("0.08"),
                new BigDecimal("0.23"),
                new BigDecimal("0.03"),
                new BigDecimal("0.13")
        };

        //when
        BigDecimal dividendYield_0 = Mathematics.commonDividendYield(PRICES[0], lastDividends[0]);
        BigDecimal dividendYield_1 = Mathematics.commonDividendYield(PRICES[1], lastDividends[1]);
        BigDecimal dividendYield_2 = Mathematics.commonDividendYield(PRICES[2], lastDividends[2]);
        BigDecimal dividendYield_3 = Mathematics.commonDividendYield(PRICES[3], lastDividends[3]);
        BigDecimal dividendYield_4 = Mathematics.commonDividendYield(PRICES[4], lastDividends[4]);

        //then
        assertEquals(COMMON_DIVIDEND_YIELD_EXPECTED[0], dividendYield_0);
        assertEquals(COMMON_DIVIDEND_YIELD_EXPECTED[1], dividendYield_1);
        assertEquals(COMMON_DIVIDEND_YIELD_EXPECTED[2], dividendYield_2);
        assertEquals(COMMON_DIVIDEND_YIELD_EXPECTED[3], dividendYield_3);
        assertEquals(COMMON_DIVIDEND_YIELD_EXPECTED[4], dividendYield_4);

    }

    @Test
    public void preferredDividendYield() throws Exception {

        //given
        BigDecimal [] fixedDividends = {
                new BigDecimal("0.02"),
                new BigDecimal("0.08"),
                new BigDecimal("0.03"),
                new BigDecimal("0.06"),
                new BigDecimal("0.11")
        };

        BigDecimal [] parValues = {
                new BigDecimal("1.00"),
                new BigDecimal("1.00"),
                new BigDecimal("0.60"),
                new BigDecimal("1.50"),
                new BigDecimal("2.50")
        };

        //when
        BigDecimal dividendYield_0 = Mathematics.preferredDividendYield(PRICES[0], fixedDividends[0], parValues[0]);
        BigDecimal dividendYield_1 = Mathematics.preferredDividendYield(PRICES[1], fixedDividends[1], parValues[1]);
        BigDecimal dividendYield_2 = Mathematics.preferredDividendYield(PRICES[2], fixedDividends[2], parValues[2]);
        BigDecimal dividendYield_3 = Mathematics.preferredDividendYield(PRICES[3], fixedDividends[3], parValues[3]);
        BigDecimal dividendYield_4 = Mathematics.preferredDividendYield(PRICES[4], fixedDividends[4], parValues[4]);

        //then
          assertEquals(PREFERRED_DIVIDEND_YIELD_EXPECTED[0], dividendYield_0);
          assertEquals(PREFERRED_DIVIDEND_YIELD_EXPECTED[1], dividendYield_1);
          assertEquals(PREFERRED_DIVIDEND_YIELD_EXPECTED[2], dividendYield_2);
          assertEquals(PREFERRED_DIVIDEND_YIELD_EXPECTED[3], dividendYield_3);
          assertEquals(PREFERRED_DIVIDEND_YIELD_EXPECTED[4], dividendYield_4);
    }

    @Test
    public void peRatio() throws Exception {
        //given
        BigDecimal[] PE_RATIO_EXPECTED = new BigDecimal[]{
                new BigDecimal("0"),
                new BigDecimal("4.62"),
                new BigDecimal("22.50"),
                new BigDecimal("33.33"),
                new BigDecimal("48.00")
        };

        //when
        BigDecimal peRatio_0 = Mathematics.peRatio(PRICES[0], COMMON_DIVIDEND_YIELD_EXPECTED[0]);
        BigDecimal peRatio_1 = Mathematics.peRatio(PRICES[1], COMMON_DIVIDEND_YIELD_EXPECTED[1]);
        BigDecimal peRatio_2 = Mathematics.peRatio(PRICES[2], COMMON_DIVIDEND_YIELD_EXPECTED[2]);
        BigDecimal peRatio_3 = Mathematics.peRatio(PRICES[3], COMMON_DIVIDEND_YIELD_EXPECTED[3]);
        BigDecimal peRatio_4 = Mathematics.peRatio(PRICES[4], COMMON_DIVIDEND_YIELD_EXPECTED[4]);

        //then
        assertEquals(PE_RATIO_EXPECTED[0], peRatio_0);
        assertEquals(PE_RATIO_EXPECTED[1], peRatio_1);
        assertEquals(PE_RATIO_EXPECTED[2], peRatio_2);
        assertEquals(PE_RATIO_EXPECTED[3], peRatio_3);
        assertEquals(PE_RATIO_EXPECTED[4], peRatio_4);
    }

    @Test
    public void geometricMean() throws Exception {
        //given
        ArrayList<BigDecimal> priceList = new ArrayList<>();
        priceList.add(PRICES[0]);
        priceList.add(PRICES[1]);
        priceList.add(PRICES[2]);
        priceList.add(PRICES[3]);
        priceList.add(PRICES[4]);

        BigDecimal geometricMeanExpected = new BigDecimal("1.371915");
        //when
        BigDecimal geometricMean = Mathematics.geometricMean(priceList);

        //then
        assertEquals(geometricMeanExpected, geometricMean);
    }

    @Test
    public void volumeWeightedStockPrice() throws Exception {
        //given
        ArrayList<BigDecimal[]> tradedPricesAndQuantities = new ArrayList<>();
        tradedPricesAndQuantities.add(new BigDecimal [] {
                new BigDecimal("2.50"),
                new BigDecimal("50")
        });
        tradedPricesAndQuantities.add(new BigDecimal [] {
                new BigDecimal("1.40"),
                new BigDecimal("26")
        });
        tradedPricesAndQuantities.add(new BigDecimal [] {
                new BigDecimal("2.10"),
                new BigDecimal("13")
        });

        BigDecimal volumeWeightedStockPriceExpected = new BigDecimal("2.12");

        //when
        BigDecimal volumeWeightedStockPrice = Mathematics.volumeWeightedStockPrice(tradedPricesAndQuantities);

        //then
        assertEquals(volumeWeightedStockPriceExpected, volumeWeightedStockPrice);
    }
}
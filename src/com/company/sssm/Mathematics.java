package com.company.sssm;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by justynadworakowska on 22.10.2016.
 */
public class Mathematics {

    public static BigDecimal commonDividendYield(BigDecimal price, BigDecimal lastDividend) {
        if (price.equals(BigDecimal.ZERO)) return BigDecimal.ZERO;
        return lastDividend.divide(price, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal preferredDividendYield(BigDecimal price, BigDecimal fixedDividend, BigDecimal parValue) {
        if (price.equals(BigDecimal.ZERO)) return BigDecimal.ZERO;
        return fixedDividend.multiply(parValue).divide(price, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal peRatio(BigDecimal price, BigDecimal dividend) {
        if (dividend.equals(new BigDecimal("0.0"))) return BigDecimal.ZERO;
        return price.divide(dividend, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal geometricMean(BigDecimal ... prices) {
        int n = prices.length;
        Iterator<BigDecimal> it = Arrays.asList(prices).iterator();
        BigDecimal multiplication = BigDecimal.ONE;

        while (it.hasNext()){
            BigDecimal price = it.next();
            multiplication = multiplication.multiply(price);
        }

        double power = new BigDecimal("1.00").divide(new BigDecimal(n), BigDecimal.ROUND_HALF_UP).doubleValue();
        return new BigDecimal(Math.pow(multiplication.doubleValue(), power)).round(MathContext.DECIMAL32);
    }

    public static BigDecimal volumeWeightedStockPrice (BigDecimal [] ... tradedPricesAndQuantities) {
        Iterator<BigDecimal[]> it = Arrays.asList(tradedPricesAndQuantities).iterator();
        BigDecimal tradedPricesAndQuantitiesSUM = BigDecimal.ZERO;
        BigDecimal quantitiesSUM = BigDecimal.ZERO;

        while (it.hasNext()){
            BigDecimal[] priceAndQuantity = it.next();
            System.out.println(priceAndQuantity[0].multiply(priceAndQuantity[1]));
            tradedPricesAndQuantitiesSUM = tradedPricesAndQuantitiesSUM.add(priceAndQuantity[0].multiply(priceAndQuantity[1]));
            System.out.println(tradedPricesAndQuantitiesSUM);
            quantitiesSUM = quantitiesSUM.add(priceAndQuantity[1], MathContext.DECIMAL32);
        }

        System.out.println(tradedPricesAndQuantitiesSUM);
        System.out.println(quantitiesSUM);
        return tradedPricesAndQuantitiesSUM.divide(quantitiesSUM, BigDecimal.ROUND_HALF_UP);
    }
}

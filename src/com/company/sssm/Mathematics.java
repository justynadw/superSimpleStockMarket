package com.company.sssm;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by justynadworakowska on 22.10.2016.
 */
public class Mathematics {
    public static BigDecimal commonDividendYield(BigDecimal price, BigDecimal lastDividend) {
        return lastDividend.divide(price);
    }

    public static BigDecimal preferredDividendYield(BigDecimal price, BigDecimal fixedDividend, BigDecimal parValue) {
        return fixedDividend.multiply(parValue).divide(price);
    }

    public static BigDecimal peRatio(BigDecimal price, BigDecimal dividend) {
        return price.divide(dividend);
    }

    public static BigDecimal geometricMean(BigDecimal ... prices) {
        int n = prices.length;
        Iterator<BigDecimal> it = Arrays.asList(prices).iterator();
        BigDecimal multiplication = BigDecimal.ONE;

        while (it.hasNext()){
            multiplication.multiply(it.next());
        }

        BigDecimal geometricMean = multiplication.pow(1/n);
        return geometricMean;
    }
}

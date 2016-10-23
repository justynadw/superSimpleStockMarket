package com.company.sssm;

/**
 * Created by justynadworakowska on 22.10.2016.
 */
public class Math {
    public static double commonDividendYield(double price, double lastDividend) {
        return lastDividend / price;
    }

    public static double preferredDividendYield(double price, double fixedDividend, double parValue) {
        return (fixedDividend * parValue) / price;
    }
}

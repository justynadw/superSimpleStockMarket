package com.company.sssm;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by justynadworakowska on 23.10.2016.
 */
public class Trade {

    public enum Indicator{
        BUY,SELL;
    }

    private BigInteger quantityOfShares;
    private Indicator indicator;
    private BigDecimal tradePrice;

    public Trade(BigInteger quantityOfShares, Indicator indicator, BigDecimal tradePrice) {
        this.quantityOfShares = quantityOfShares;
        this.indicator = indicator;
        this.tradePrice = tradePrice;
    }
}



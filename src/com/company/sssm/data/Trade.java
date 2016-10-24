package com.company.sssm.data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by justynadworakowska on 23.10.2016.
 */
public class Trade {

    public enum Indicator{
        BUY,SELL;
    }

    private Timestamp timestamp;
    private BigInteger quantityOfShares;
    private Indicator indicator;
    private BigDecimal tradePrice;

    public Trade(BigInteger quantityOfShares, Indicator indicator, BigDecimal tradePrice) {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.quantityOfShares = quantityOfShares;
        this.indicator = indicator;
        this.tradePrice = tradePrice;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public BigInteger getQuantityOfShares() {
        return quantityOfShares;
    }

    public Indicator getIndicator() {
        return indicator;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }
}



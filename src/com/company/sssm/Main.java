package com.company.sssm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");
        Stock[] stocks = {
                new Stock(StockSymbol.TEA, StockType.COMMON, 0, 1),
                new Stock(StockSymbol.POP, StockType.COMMON, 0.08, 1),
                new Stock(StockSymbol.ALE, StockType.COMMON, 0.23, 0.6),
                new Stock(StockSymbol.GIN, StockType.PREFERRED, 0.08, 2, 1),
                new Stock(StockSymbol.JOE, StockType.COMMON, 0.13, 2.5),
        };

    }
}

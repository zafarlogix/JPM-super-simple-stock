package com.jpm.stock.executer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.jpm.stock.Stock;
import com.jpm.stock.Trade;
import com.jpm.stock.util.Util;

/**
 * 
 * @author Zafar 
 * Stock Executor a singleton class This class contain the Hash Map to keep and display (if required) all the stocks objects
 * Calculate All Share Index Value
 *
 */
public class StockExecuter {

	// Singleton instance
	private static StockExecuter stockExecuterInstance;
	// HashMap to keep all the stock object against Symbol String key.
	private static final Map<String, Stock> stockMap = new HashMap<>();

	private StockExecuter() {
	}

	// To access Singleton instance
	public static StockExecuter getStockExecuterInstance() {
		if (null == stockExecuterInstance) {
			stockExecuterInstance = new StockExecuter();
		}
		return stockExecuterInstance;
	}

	synchronized public static Map<String, Stock> getStockMap() {
		return stockMap;
	}

	// Stock data insertion method
	synchronized public static void addStock(String stockName, Stock stockObj) {
		getStockMap().put(stockName, stockObj);

	}

	// Calculate All Share Index Value from stock map
	public static double getAllShareIndex() {

		double stockPriceYield = 1;
		int stockMapSize = stockMap.entrySet().size();
		Set<Map.Entry<String, Stock>> setValue = stockMap.entrySet();

		for (Map.Entry<String, Stock> setEntry : setValue) {

			stockPriceYield = stockPriceYield * (setEntry.getValue().getLastTradePrice());
		}
		if (stockPriceYield <= 0) {
			return 0;
		}
		return Util.roundFunc(Math.pow(stockPriceYield, (1.0 / (stockMapSize))), 2);

	}

	// Round method
	public static double roundFunc(double geometricMean, int decimalPoint) {
		if (decimalPoint < 0) {
			decimalPoint = 0;
		}

		BigDecimal roundedGeometricMean = new BigDecimal(geometricMean);
		roundedGeometricMean = roundedGeometricMean.setScale(decimalPoint, RoundingMode.HALF_EVEN);
		return roundedGeometricMean.doubleValue();
	}

	// On console display of all stocks objects
	public static void displayAllStocks() {

		Set<Map.Entry<String, Stock>> setValue = stockMap.entrySet();

		for (Map.Entry<String, Stock> stock : setValue) {

			System.out.println(stock.toString());
		}
	}

}

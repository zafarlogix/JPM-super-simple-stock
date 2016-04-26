package com.jpm.stock.util;

import com.jpm.stock.Trade;
import com.jpm.stock.Trade.Side;
import com.jpm.stock.executer.StockExecuter;
import com.jpm.stock.executer.TradeExecuter;

public class MenuHandler {

	public static void menuMethod(String inputStr) {
		try {

			String commandStr[] = inputStr.split(" ");
			String command = commandStr[0];

			if (ApplicationConstants.MENU.equals(command) && commandStr.length == 1) {
				System.out.println(ApplicationConstants.MENU_STR);
			} else if (ApplicationConstants.DIVIDENT_YIELD.equals(command) && commandStr.length == 3) {
				System.out.println("Dividend Yield:" + StockExecuter.getStockMap().get(commandStr[1])
						.calculateDividendYield(Integer.parseInt(commandStr[2])));
			} else if (ApplicationConstants.PE_RATIO.equals(command) && commandStr.length == 3) {
				System.out.println("P/E Ratio:" + StockExecuter.getStockMap().get(commandStr[1])
						.calculatePERatio(Integer.parseInt(commandStr[2])));
			} else if (ApplicationConstants.TRADE_IN.equals(command) && commandStr.length == 5) {
				Side side;
				if ("BUY".equals(commandStr[2])) {
					side = Trade.Side.BUY;
				} else {
					side = Trade.Side.SELL;
				}
				Trade trade = new Trade(StockExecuter.getStockMap().get(commandStr[1]), side,
						Integer.parseInt(commandStr[3]), Double.parseDouble(commandStr[4]));
				TradeExecuter.getTradeExecuterInstance().addTradesToList(trade);
				StockExecuter.getStockMap().get(commandStr[1]).setLastTradePrice(trade.getPrice());
				System.out.println(trade.toString());
			} else if (ApplicationConstants.STOCK_PRICE.equals(command) && commandStr.length == 2) {
				System.out.println(TradeExecuter.getTradeExecuterInstance().getStockPrice(commandStr[1]));
			} else if (ApplicationConstants.GBCE_INDEX.equals(command) && commandStr.length == 1) {
				System.out.println(StockExecuter.getAllShareIndex());
			} else if (ApplicationConstants.DISPLAY_ALL_STOCKS.equals(command) && commandStr.length == 1) {
				StockExecuter.displayAllStocks();
			} else if (ApplicationConstants.EXIT.equals(command) && commandStr.length == 1) {
				System.exit(0);
			} else {
				System.out.println("Invalid command: " + ApplicationConstants.STARTUP_STR);
			}
		} catch (Exception e) {
			System.out.println("Invalid command: " + ApplicationConstants.STARTUP_STR);
		}
	}
}

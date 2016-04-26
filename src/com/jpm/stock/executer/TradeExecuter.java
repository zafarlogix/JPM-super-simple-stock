package com.jpm.stock.executer;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.jpm.stock.Trade;
import com.jpm.stock.util.Util;

/**
 * 
 * @author Zafar
 * This class contain the Link List to keep and display (if required) the recent 15 trades object
 * This contain an inner class RemoveTradeFromList which extends the TimerTask and schedule to run run after 15 minz
 * Calculate the Stock price only for the recent 15 minz trades
 *
 */

public class TradeExecuter {

	//Singleton instance
	private static TradeExecuter tradeExecuterInstance;
	//Link List to keep 15 minutes trades
	private List<Trade> TradesList = new LinkedList<>();
	//Milliseconds for 15 minutes
	public static final int TRADE_DELETION_TIME_MILLI_SECS = 900000;
	//Timer object
	private Timer timer = new Timer();
	//Inner class RemoveTradeFromList which extends TimerTask and remove the trade from LinkList after 15 minutes
	private class RemoveTradeFromList extends TimerTask {

		Trade trade;

		RemoveTradeFromList(Trade trade) {
			this.trade = trade;
		}

		@Override
		public void run() {
			//Synchronized the Trade Link List for safety 
			synchronized (TradesList) {

				TradesList.remove(trade);
			}

		}

	}

	private TradeExecuter() {

	}
	//To access Singleton instance
	public static TradeExecuter getTradeExecuterInstance() {
		if (tradeExecuterInstance == null) {
			tradeExecuterInstance = new TradeExecuter();
		}

		return tradeExecuterInstance;
	}
	
	//Add new trade trade into Link List and attached timer task thread to remove the trade after 15 minz  
	public synchronized void addTradesToList(Trade trade) {

		if (trade != null) {
			//synchronized
			synchronized (TradesList) {

				TradesList.add(trade);

			}
			
			RemoveTradeFromList task = new RemoveTradeFromList(trade);
			//Timer schedule
			timer.schedule(task, TRADE_DELETION_TIME_MILLI_SECS);
		}

	}
	//Return array of trades
	public synchronized Trade[] getArrayOfTrades() {

		Trade trades[];
		synchronized (TradesList) {
			trades = new Trade[TradesList.size()];
			trades = TradesList.toArray(trades);
		}

		return trades;
	}
	//Return number of trades in Link List
	public int numTradesInCache() {
		synchronized (TradesList) {

			return TradesList.size();

		}
	}

	//Calculate the Stock price only for the recent 15 minutes trades
	public double getStockPrice(String stockname) {
		double numerator = 0.0;
		double denominator = 0.0;
		double stockPrice = 0.0;

		if (!TradesList.isEmpty()) {

			for (Trade trade : TradesList) {
				if (trade.getStock().getSymbol().equals(stockname)) {
					numerator = numerator + (trade.getPrice() * trade.getShareQuatity());
					denominator = denominator + trade.getShareQuatity();
				}
			}
			stockPrice = Util.roundFunc(numerator / denominator, 2);
		} else {
			stockPrice = 0.0;
		}
		return stockPrice;
	}

	//Return  latest 15 minutes trades
	public void displayAllTrades() {
		for (Trade trade : TradesList) {
			System.out.println(trade.toString());
		}
	}

}

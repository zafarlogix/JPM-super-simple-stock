package com.jpm.stock.executer;

import java.util.ArrayList;
import java.util.List;

import com.jpm.stock.Trade;
/**
 * 
 * @author Zafar
 * AllTradesCollection a singleton class
 * This class contain the Array List to keep and display (if required) all the trades recodes
 * Data in this Array List never removed 
 */
public class AllTradesCollection {

	//Singleton instance
	private static AllTradesCollection allTradesCollectionsInstance;
	//Array List to keep all the trades object
	private static List<Trade> allTradesList = new ArrayList<>();

	//To access Singleton instance
	public static AllTradesCollection getAllTradesCollectionsInstance() {
		if (allTradesCollectionsInstance == null) {
			allTradesCollectionsInstance = new AllTradesCollection();
		}

		return allTradesCollectionsInstance;
	}

	//Trade data insertion method
	public static void addToCollection(Trade trade) {

		if (trade != null) {
			{
				allTradesList.add(trade);
				//Trade data being input into Trade Array List object which only stay for 15 minutes
				TradeExecuter.getTradeExecuterInstance().addTradesToList(trade);
			}

		}

	}
	// On console display of all trades objects
	public static void displayAllTrades() {
		for (Trade trade : allTradesList) {
			System.out.println(trade.toString());
		}
	}

}

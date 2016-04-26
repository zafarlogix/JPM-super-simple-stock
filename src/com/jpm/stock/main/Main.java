package com.jpm.stock.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.jpm.stock.Stock;
import com.jpm.stock.executer.StockExecuter;
import com.jpm.stock.util.ApplicationConstants;
import com.jpm.stock.util.MenuHandler;

/**
 * 
 * @author Zafar 
 * This is main class of JPM Super Stock project. 
 * This class also enter the initial stock to memory.
 */
public class Main {

	public static void main(String[] args) {
		// Adding stock
		StockExecuter.addStock("TEA", new Stock("TEA", Stock.Type.COMMON, 0.0, 0.0f, 100));
		StockExecuter.addStock("POP", new Stock("POP", Stock.Type.COMMON, 8, 0.0f, 100));
		StockExecuter.addStock("ALE", new Stock("ALE", Stock.Type.COMMON, 23, 0.0f, 60));
		StockExecuter.addStock("GIN", new Stock("GIN", Stock.Type.PREFERRED, 8, 2.00f, 100));
		StockExecuter.addStock("JOE", new Stock("JOE", Stock.Type.COMMON, 13, 0.0f, 250));

		// Menu keywords
		System.out.println(ApplicationConstants.MENU_STR);

		try {
			String inputStr = "";
			while (!ApplicationConstants.EXIT.equals(inputStr)) {
				BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
				inputStr = input.readLine();
				if (inputStr == null) {
					System.out.println(ApplicationConstants.INVALID_INPUT);
				} else {
					MenuHandler.menuMethod(inputStr);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

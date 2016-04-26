package com.jpm.stock.util;

public class ApplicationConstants {
	//Constant values to handle program menu
	public static final String MENU = "M";
	public static final String DIVIDENT_YIELD = "DY";
	public static final String PE_RATIO = "PER";
	public static final String TRADE_IN = "TRDIN";
	public static final String STOCK_PRICE = "LSP";
	public static final String GBCE_INDEX = "GBCE";
	public static final String DISPLAY_ALL_STOCKS="DAS";
	public static final String EXIT = "X";
	public static final String INVALID_INPUT = "Invalid input";
	
	public static final String MENU_STR = "Please provide the following commands to proceed:\n"
			+ "\tCalculate Dividend Yield:\tDY [STOCK NAME] [TICKER PRICE]\n"
			+ "\ttCalculate P/E Ratio:\t\tPER [STOCK NAME] [TICKER PRICE]\n"
			+ "\tInput A Trade:\t\t\tTRDIN [STOCK NAME] [BUY/SELL] [SHARE QUANTITY] [TICKER PRICE]\n"
			+ "\tLatest 15 Min Stock Price:\tLSP [STOCK NAME]\n" + "\tGBCE All Share Index:\t\tGBCE\n" 
			+ "\tDisplay All stocks:\t\tDAS\n" 
			+ "\tExit:\t\t\t\tX\n";
	
	public static final String STARTUP_STR = "Please type [M] for menue:\n";
	
}

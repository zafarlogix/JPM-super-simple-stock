package com.jpm.stock;

/**
 * 
 * @author Zafar
 * Stock class to represent the Stock object 
 * Calculate the Dividend Yield for given price
 * Calculate P/E Ratio for given price 
 */

public class Stock {

	public static enum Type {
		COMMON, PREFERRED
	}

	private String symbol;
	private Type type;
	private double lastDividend;
	private double fixedDividend;
	private int parValue;
	// We assume the last prices for all stock at 100
	private double lastTradePrice = 100;

	public double getLastTradePrice() {
		return lastTradePrice;
	}

	public void setLastTradePrice(double d) {
		this.lastTradePrice = d;
	}

	public Stock(String symbol, Type type, double lastDividend, double fixedDividend, int parValue) {
		this.symbol = symbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}

	private Stock(Builder builder) {

		this(builder.symbol, builder.type, builder.lastDividend, builder.fixedDividend, builder.parValue);
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", type=" + type + ", lastDividend=" + lastDividend + ", fixedDividend="
				+ fixedDividend + ", parValue=" + parValue + ", lastTradePrice=" + lastTradePrice + "]";
	}

	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public void setParValue(int parValue) {
		this.parValue = parValue;
	}

	public String getSymbol() {
		return symbol;
	}

	public Type getType() {
		return type;
	}

	public double getLastDividend() {
		return lastDividend;
	}

	public double getFixedDividend() {
		return fixedDividend;
	}

	public int getParValue() {
		return parValue;
	}
	
	//Calculate the Dividend Yield for given price
	public double calculateDividendYield(int tickerPrice) {
		double dividendYield = 0.0;

		if (type != null) {
			//Implement the formula depending on stock type to calculate P/E Ratio 
			if (type != null && type.equals(Type.COMMON)) {

				if (lastDividend != 0.0) {
					dividendYield = lastDividend / tickerPrice;
				}
			} else {
				dividendYield = ((fixedDividend * parValue) / tickerPrice);
			}

		}
		return dividendYield;
	}
	//Calculate P/E Ratio for given price
	public double calculatePERatio(int tickerPrice) {
		double peRatio = 0.0;

		if (type != null) {
			//Check if Last Dividend Value is zero 
			if (lastDividend != 0.0) {
				peRatio = tickerPrice / lastDividend;
			}
		}
		return peRatio;
	}
	
	//Builder class to build the class object
	public static class Builder {

		private String symbol;
		private Type type;
		private double lastDividend;
		private double fixedDividend;
		private int parValue;

		public Builder symbol(String symbol) {
			this.symbol = symbol;
			return this;
		}

		public Builder lastDividend(double lastDividend) {
			this.lastDividend = lastDividend;
			return this;
		}

		public Builder fixedDividend(double fixedDividend) {
			this.fixedDividend = fixedDividend;
			return this;
		}

		public Builder parValue(int parValue) {
			this.parValue = parValue;
			return this;
		}

		public Builder type(Type type) {
			this.type = type;
			return this;
		}

		public Stock build() {
			return new Stock(this);
		}

	}

}

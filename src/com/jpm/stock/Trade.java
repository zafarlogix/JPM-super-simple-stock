package com.jpm.stock;

import java.sql.Timestamp;

import com.jpm.stock.util.Util;
/**
 * 
 * @author Zafar
 * Trade class to represent the Trade object
 */
public class Trade {
	// Enumeration for BUY/SELL side
	public static enum Side {
		BUY, SELL
	}

	private Stock stock;
	private Timestamp timestamp;
	private int shareQuatity;
	private double price;
	private Side side;

	//String representation of Trade Object used to display the trade object 
	@Override
	public String toString() {
		return "Trade [stock=" + stock.getSymbol() + ", timestamp=" + timestamp + ", shareQuatity=" + shareQuatity
				+ ", price=" + price + ", side=" + side + "]";
	}

	public Trade(Stock stock, Side side, int shareQuantity, double price) {
		this.stock = stock;
		this.side = side;
		this.shareQuatity = shareQuantity;
		this.price = price;
		setTimestamp(Util.getCurrentTimestamp());
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	private Trade(Builder builder) {
		this(builder.stock, builder.side, builder.shareQuatity, builder.price);
	}

	public int getShareQuatity() {
		return shareQuatity;
	}

	public void setShareQuatity(int shareQuatity) {
		this.shareQuatity = shareQuatity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}
	
	//Builder class to build the class object
	public static class Builder {

		private int shareQuatity;
		private double price;
		private Stock stock;
		private Side side;

		public Builder stock(Stock stock) {
			this.stock = stock;
			return this;
		}

		public Builder price(double price) {
			this.price = price;
			return this;
		}

		public Builder side(Side side) {
			this.side = side;
			return this;
		}

		public Builder shareQuantity(int shareQuantity) {
			this.shareQuatity = shareQuantity;
			return this;

		}

		public Trade build() {
			return new Trade(this);
		}

	}
}

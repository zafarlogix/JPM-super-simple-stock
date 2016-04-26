package com.jpm.stock.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;

public class Util {

	synchronized public static Timestamp getCurrentTimestamp() {
		java.util.Date date = new java.util.Date();
		return new Timestamp(date.getTime());
	}

	public static double roundFunc(double Val, int decimalPoint) {
		if (decimalPoint < 0) {
			decimalPoint = 0;
		}

		BigDecimal roundedGeometricMean = new BigDecimal(Val);
		roundedGeometricMean = roundedGeometricMean.setScale(decimalPoint, RoundingMode.HALF_EVEN);
		return roundedGeometricMean.doubleValue();
	}
}

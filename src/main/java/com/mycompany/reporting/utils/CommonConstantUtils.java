package com.mycompany.reporting.utils;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.google.common.collect.Lists;

public class CommonConstantUtils {
	public static final String CURR_AED = "AED";
	public static final String CURR_SAR = "SAR";
	public static final String CODE_GENERATOR_KEY = "ABC";
	public static final List<String> currencyList = Lists.newArrayList();
	static {
		currencyList.add("AUD");
		currencyList.add("AED");
		currencyList.add("SAR");
		currencyList.add("USD");
		currencyList.add("INR");
		currencyList.add("GBP");
		currencyList.add("SGD");
		currencyList.add("AIR");
		currencyList.add("RIA");
		currencyList.add("STP");

	}

	public static String createRandomCode(int codeLength) {
		return createRandomCode(3, CODE_GENERATOR_KEY);
	}

	public static String createRandomCurrency() {
		Double index = Math.random() * 10;
		return currencyList.get(index.intValue());
	}

	public static String createRandomCode(int codeLength, String id) {
		char[] chars = id.toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new SecureRandom();
		for (int i = 0; i < codeLength; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		System.out.println(output);
		return output;
	}

	public static Date createNormalizedDateObject(int year, int month, int day) {
		Calendar currentDate = Calendar.getInstance(Locale.US);
		currentDate.set(Calendar.AM_PM, Calendar.AM);
		currentDate.set(Calendar.HOUR, 0);
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);
		currentDate.set(Calendar.MILLISECOND, 0);
		// Setting this to Saturday
		currentDate.set(year, month, day);

		return currentDate.getTime();
	}
}

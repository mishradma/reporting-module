/**
 *
 */
package com.mycompany.reporting.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * @author mishradma
 *
 */
public class DateUtils {
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
	private static final SimpleDateFormat DEFAULT_DATE_FORMAT_FORMATTER = new SimpleDateFormat(
			DateUtils.DEFAULT_DATE_FORMAT);

	/**
	 * @return the defaultDateFormatFormatter
	 */
	public static SimpleDateFormat getDefaultDateFormatFormatter() {
		return DEFAULT_DATE_FORMAT_FORMATTER;
	};

	/**
	 * @return the customDateFormatFormatter
	 */
	public static SimpleDateFormat constructDateFormatFormatter(String pattern) {
		return new SimpleDateFormat(pattern);
	};

	public static Date parseDate(String dateStr, String format) throws ParseException {
		Date parsedDate;
		if (StringUtils.isNotBlank(dateStr)) {
			if (StringUtils.isNotBlank(format)) {
				parsedDate = new SimpleDateFormat(format).parse(dateStr);
			} else {
				parsedDate = getDefaultDateFormatFormatter().parse(dateStr);
			}
		} else {
			parsedDate = null;
		}
		return parsedDate;
	}

	public static Date createEffectiveWorkingDate(String currency, Date date) {
		Calendar effectiveDate = Calendar.getInstance();
		effectiveDate.setTime(date);
		effectiveDate.set(Calendar.HOUR, 0);
		effectiveDate.set(Calendar.MINUTE, 0);
		effectiveDate.set(Calendar.SECOND, 0);
		effectiveDate.set(Calendar.MILLISECOND, 0);
		effectiveDate.set(Calendar.AM_PM, Calendar.AM);
		int currentDayOfWeek = effectiveDate.get(Calendar.DAY_OF_WEEK);
		if (StringUtils.equalsIgnoreCase(CommonConstantUtils.CURR_AED, currency)
				|| StringUtils.equalsIgnoreCase(CommonConstantUtils.CURR_SAR, currency)) {
			if (currentDayOfWeek > 5) {
				effectiveDate.add(Calendar.DAY_OF_WEEK, 8 - currentDayOfWeek);
			}
		} else {
			if (currentDayOfWeek == 7) {
				effectiveDate.add(Calendar.DAY_OF_WEEK, 2);
			} else if (currentDayOfWeek == 1) {
				effectiveDate.add(Calendar.DAY_OF_WEEK, 1);
			}
		}
		return effectiveDate.getTime();
	}

}

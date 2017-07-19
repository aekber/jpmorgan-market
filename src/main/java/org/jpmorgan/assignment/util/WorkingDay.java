package org.jpmorgan.assignment.util;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used for whether given date is holiday or not by currency
 * @author ekber
 *
 */
public class WorkingDay {

	private static Map<String, List<Integer>> arabicWorkingDays = new HashMap<String, List<Integer>>();
	private static List<Integer> defaultWorkingDays = Arrays.asList(Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY);

	static {
		List<Integer> arabicWorkDays = Arrays.asList(Calendar.SUNDAY, Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY);
		arabicWorkingDays.put("SAR", arabicWorkDays);
		arabicWorkingDays.put("AED", arabicWorkDays);
	}

	public static Date getClosestWorkingDay(String currency, Date date) {
		while (!isWorkingDay(currency, date)) {
			date = addDay(date);
		}
		return date;
	}

	private static boolean isWorkingDay(String currency, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		return getWorkingDays(currency).contains(cal.get(Calendar.DAY_OF_WEEK));
	}

	private static List<Integer> getWorkingDays(String currency) {
		return arabicWorkingDays.containsKey(currency) ? arabicWorkingDays.get(currency) : defaultWorkingDays;
	}

	private static Date addDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}
}

package com.util;

import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjUtil {
	public static boolean isNullOrEmpty(Object o) {
		return o == null || o.equals("") || o.equals("null");
	}

	public static boolean isNullOrEmpty(List<?> l) {
		return l == null || l.size() == 0;
	}

	public static String strValue(Object o) {
		String s = "";
		try {
			s = o.toString();
		} catch (Exception e) {

		}
		return s;
	}

	public static Integer intValue(Object o) {
		int i = 0;
		try {
			i = Integer.valueOf(o.toString());
		} catch (Exception e) {

		}
		return i;
	}

	public static Double decValue(Object o) {
		double d = 0;
		try {
			d = Double.valueOf(o.toString());
		} catch (Exception e) {

		}
		return d;
	}

	public static boolean booValue(Object o) {
		boolean b = false;
		try {
			b = Boolean.valueOf(o.toString());
		} catch (Exception e) {

		}
		return b;
	}

	public static String getMatchStr(String source, String reg) {
		String str = null;
		Pattern pattern = null;
		Matcher matcher = null;
		pattern = Pattern.compile(reg, Pattern.DOTALL);
		matcher = pattern.matcher(source);
		boolean found = matcher.find();
		if (found)
			str = matcher.group();
		return str;
	}

	public static String fillStr(Object o, int size, String fill) {
		String s = strValue(o);
		int length = s.length();
		if (length > size) {
			return s.substring(0, size);
		}
		for (int i = length; i < size; i++) {
			s = fill + s;
		}
		return s;
	}

	public static String fillStr(Object o, int size) {
		String fill = "0";
		String s = strValue(o);
		int length = s.length();
		if (length > size) {
			return s.substring(0, size);
		}
		for (int i = length; i < size; i++) {
			s = fill + s;
		}
		return s;
	}

	public static String fillIPAddr(String ipAddr) {
		String s = "";
		StringTokenizer st = new StringTokenizer(ipAddr.trim(), ".");
		while (st.hasMoreTokens()) {
			s += "." + fillStr(st.nextToken(), 3);
		}
		if (!isNullOrEmpty(s)) {
			s = s.substring(1);
		}
		return s;
	}
}

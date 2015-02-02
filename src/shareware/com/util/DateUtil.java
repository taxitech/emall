package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static SimpleDateFormat format_date = new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat format_time = new SimpleDateFormat("HH:mm");
	static SimpleDateFormat format_min = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");
	static SimpleDateFormat format_mon_min = new SimpleDateFormat("MM-dd HH:mm");
	static SimpleDateFormat format_date_min = new SimpleDateFormat("dd HH:mm");
	static SimpleDateFormat format_us = new SimpleDateFormat(
			"MMM dd,yyyy hh:mm:ss aaa", Locale.US);
	static SimpleDateFormat format_gmt_cn = new SimpleDateFormat(
			"EEE MMM dd yyyy HH:mm:ss' GMT'Z' (中国标准时间)'", Locale.ENGLISH);
	static SimpleDateFormat format_gmt = new SimpleDateFormat(
			"EEE MMM dd yyyy HH:mm:ss' GMT'Z", Locale.ENGLISH);
	static SimpleDateFormat format_utc = new SimpleDateFormat(
			"EEE MMM dd HH:mm:ss' UTC'Z yyyy", Locale.ENGLISH);
	static SimpleDateFormat format_cn = new SimpleDateFormat("yyyy年MM月dd日");

	public static String format(Date date) {
		return format.format(date);
	}
	
	public static String format_date(Date date) {
		return format_date.format(date);
	}
	
	public static String format_date_us(Date date) {
		return format_us.format(date);
	}
	
	public static String format_date_en(Date date) {
		return format_gmt_cn.format(date);
	}
	
	public static String format_date_cn(Date date) {
		return format_cn.format(date);
	}

	public static Date parse(String source) {
		Date date = null;
		try {
			date = format.parse(source);
			return date;
		} catch (Exception e) {
		}
		try {
			date = format_date.parse(source);
			return date;
		} catch (Exception e) {
		}
		try {
			date = format_us.parse(source);
			return date;
		} catch (Exception e) {
		}
		try {
			date = format_gmt_cn.parse(source);
			return date;
		} catch (Exception e) {
		}
		try {
			date = format_gmt.parse(source);
			return date;
		} catch (Exception e) {
		}
		try {
			date = format_utc.parse(source);
			return date;
		} catch (Exception e) {
		}
		try {
			date = format_cn.parse(source);
			return date;
		} catch (Exception e) {
		}
		return date;
	}
}

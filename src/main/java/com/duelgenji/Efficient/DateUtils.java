package com.duelgenji.Efficient;

import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.commons.lang3.time.FastDateParser;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
	
	static String[] patterns = {"MM/dd/yyyy","yyyy/MM/dd","dd-MMM-yy","dd MMMM yyyy","yyyyMMdd",
			"MM-dd-yyyy","yyyy-MM-dd"};

	static SimpleDateFormat parse = null;
	static SimpleDateFormat result = new SimpleDateFormat("MM/dd/yyyy",Locale.US);

	static long startTime = System.currentTimeMillis();

	static TimeZone tz = TimeZone.getDefault();
	static Locale lcl = Locale.US;
	static Calendar calendar = Calendar.getInstance(tz, lcl);
	static ParsePosition pos = new ParsePosition(0);
	static FastDateFormat fdf = null;

	static{
		calendar.setLenient(false);
	}


	/**
	 * @Description: 把多种日期格式统一处理为一种,不支持除英语之外的其他语言 比如：八月，必须是Aug或者August
	 *     不支持的格式返回原输入
	 * @author knight.wang
	 */
	public static String parseDate(String input) {
		if(input!=null && !input.equals("")) {

			if(fdf!=null){
				pos = new ParsePosition(0);
				try {
					if (fdf.parse(input, pos, calendar) && pos.getIndex() == input.length()) {
						return result.format(calendar.getTime());
					}
				} catch (IllegalArgumentException e) {
					//
				}
			}


			for(String pattern:patterns){

				fdf = FastDateFormat.getInstance(pattern,tz,lcl);
				pos = new ParsePosition(0);
				try {
					if (fdf.parse(input, pos, calendar) && pos.getIndex() == input.length()) {
						return result.format(calendar.getTime());
					}
				} catch (IllegalArgumentException e) {
					//
				}
			}
		}

		return input;
	}

	public static String parseDate2(String input) {

		if(input!=null && !input.equals("")) {
			Date d;
			if (parse!=null) {
				pos = new ParsePosition(0);
				d = parse.parse(input,pos);
				if (d != null) {
					return result.format(d);
				}
			}

			for(String pattern:patterns){
				parse = new SimpleDateFormat(pattern, Locale.US);
				parse.setLenient(false);
				pos = new ParsePosition(0);
				d = parse.parse(input,pos);
				if(d!=null){
					return result.format(d);
				}

			}
		}

		return input;
	}

	public static void main(String[] args) {


		List<String> list = new LinkedList<>();


		for(int i=0; i<100000;i++){
			list.add("1997-10-20");
		}

		for(int i=0; i<100000;i++){
			list.add("20001130");
		}

		for(int i=0; i<100000;i++){
			list.add("1999/12/30");
		}
		for(int i=0; i<100000;i++){
			list.add("01-Aug-11");
		}


		System.out.println("1 cost :" + (System.currentTimeMillis()-startTime) + "ms");


		startTime = System.currentTimeMillis();
		for (String s : list) {
//			System.out.println(DateUtils.parseDate(s));
			DateUtils.parseDate(s);
		}

		System.out.println("2 cost :" + (System.currentTimeMillis()-startTime) + "ms");


		startTime = System.currentTimeMillis();
		for (String s : list) {
//			System.out.println(DateUtils.parseDate2(s));
			DateUtils.parseDate2(s);
		}

		System.out.println("3 cost :" + (System.currentTimeMillis()-startTime) + "ms");


	}


}

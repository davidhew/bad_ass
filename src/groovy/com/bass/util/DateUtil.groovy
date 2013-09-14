package com.bass.util

import java.text.SimpleDateFormat;

class DateUtil {
	
	public static final String yyyyMMddFormat = "yyyyMMdd";
	public static Date generateDate(String strDate,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(strDate);
	}
	
	/**
	 * 以yyyyMMdd格式产生date
	 * @param strDate
	 * @return
	 */
	public static Date generateSimpleDate(String strDate){
		return generateDate(strDate,yyyyMMddFormat);
	}

}

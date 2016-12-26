package com.lin.spring.demo.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class MyDateFormatter implements Formatter<Date> {

	@Override
	public String print(Date object, Locale locale) {
		return null;
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(text);
	}

}

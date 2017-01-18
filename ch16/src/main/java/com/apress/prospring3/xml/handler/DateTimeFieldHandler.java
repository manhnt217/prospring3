package com.apress.prospring3.xml.handler;

import java.util.Properties;

import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.exolab.castor.mapping.ValidityException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTimeFieldHandler extends GeneralizedFieldHandler {

	private static String dateFormatPattern;

	@Override
	public void setConfiguration(Properties config) throws ValidityException {

		dateFormatPattern = config.getProperty("date-format");
	}

	@Override
	public Object convertUponGet(Object value) {

		DateTime dateTime = (DateTime) value;
		return format(dateTime);
	}

	private Object format(DateTime dateTime) {

		if (dateTime != null) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateFormatPattern);
			return dateTimeFormatter.print(dateTime);
		}
		return "";
	}

	@Override
	public Object convertUponSet(Object value) {

		String dateTimeString = (String) value;
		return parse(dateTimeString);
	}

	private Object parse(String dateTimeString) {

		if(dateTimeString != null) {
			
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateFormatPattern);
			return dateTimeFormatter.parseDateTime(dateTimeString);
		}
		return new DateTime();
	}

	@Override
	public Class<?> getFieldType() {

		return DateTime.class;
	}

}

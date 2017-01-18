package com.apress.prospring3.converter;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToDateTimeConverter implements Converter<String, DateTime> {

	private static final String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd";

	private String dateTimePattern = DEFAULT_DATE_TIME_PATTERN;

	private DateTimeFormatter dateTimeFormatter;

	@PostConstruct
	private void init() {

		this.dateTimeFormatter = DateTimeFormat.forPattern(dateTimePattern);
	}

	public String getDateTimePattern() {

		return dateTimePattern;
	}

	@Autowired(required = false)
	public void setDateTimePattern(String dateTimePattern) {

		this.dateTimePattern = dateTimePattern;
	}

	public DateTime convert(String source) {

		return dateTimeFormatter.parseDateTime(source);
	}

}

package com.apress.prospring3.formatter;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

public class DateTimeConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	final Logger logger = LoggerFactory.getLogger(DateTimeConversionServiceFactoryBean.class);
	
	private static final String DEFAULT_DATE_PATTERN = "EEEE, MMMM dd, YYYY";
	private String datePattern = DEFAULT_DATE_PATTERN;
	private DateTimeFormatter dateFormat;
	
	private Set<Formatter<?>> formatters = new HashSet<Formatter<?>>();

	public String getDatePattern() {

		return datePattern;
	}

	@Autowired(required = false)
	public void setDatePattern(String datePattern) {

		this.datePattern = datePattern;
	}

	@PostConstruct
	public void init() {

		dateFormat = DateTimeFormat.forPattern(datePattern);
		formatters.add(getDateTimeFormatter());
		setFormatters(formatters);
	}

	private Formatter<DateTime> getDateTimeFormatter() {

		return new Formatter<DateTime>() {

			public String print(DateTime dateTime, Locale locale) {

				logger.info("Formatting " + dateTime);
				return dateFormat.print(dateTime);
			}

			public DateTime parse(String dateTimeString, Locale locale) throws ParseException {

				logger.info("Parsing date string: " + dateTimeString);
				return dateFormat.parseDateTime(dateTimeString);
			}
		};
	}
}

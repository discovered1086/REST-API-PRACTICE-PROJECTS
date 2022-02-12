package com.konvergion.personalfinance.expenseplansapi.model.dto.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateDeSerializer extends StdDeserializer<LocalDate> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3202949066610693761L;

	protected DateDeSerializer(Class<?> vc) {
		super(vc);
	}

	@SuppressWarnings("unused")
	public DateDeSerializer() {
		this(null);
	}

	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		String dateTime = p.getText();
		return LocalDate.parse(dateTime, DateTimeFormatter.ISO_DATE);

	}

}

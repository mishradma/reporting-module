/**
 *
 */
package com.mycompany.reporting.web.dto.serializer;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.mycompany.reporting.utils.DateUtils;

/**
 * @author mishradma
 *
 */
@JsonComponent
public class CustomDateJsonDeserializer extends JsonDeserializer<Date> {
	/*
	 * (non-Javadoc)**
	 * 
	 * @see
	 * com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.
	 * jackson.core.JsonParser,
	 * com.fasterxml.jackson.databind.DeserializationContext)
	 */

	@Override
	public Date deserialize(final JsonParser p, final DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Date tempDate = null;
		final String formattedValue = p.getText();
		try {
			if (StringUtils.isNotBlank(formattedValue)) {
				tempDate = DateUtils.parseDate(StringUtils.trim(formattedValue), null);

			}
		} catch (final ParseException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
		return tempDate;

	}

	@Override
	public Class<Date> handledType() {
		return Date.class;
	}

}

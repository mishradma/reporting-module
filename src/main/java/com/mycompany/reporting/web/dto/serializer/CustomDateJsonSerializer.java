/**
 *
 */
package com.mycompany.reporting.web.dto.serializer;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mycompany.reporting.utils.DateUtils;

/**
 * @author mishradma
 *
 */
@JsonComponent
public class CustomDateJsonSerializer extends JsonSerializer<Date> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object,
	 * com.fasterxml.jackson.core.JsonGenerator,
	 * com.fasterxml.jackson.databind.SerializerProvider)
	 */
	@Override
	public void serialize(final Date value, final JsonGenerator gen, final SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		try {
			String formattedValue = StringUtils.EMPTY;
			if (Objects.nonNull(value)) {
				formattedValue = DateUtils.getDefaultDateFormatFormatter().format(value);
			}
			gen.writeString(formattedValue);

		} catch (final Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public Class<Date> handledType() {
		return Date.class;
	}

}

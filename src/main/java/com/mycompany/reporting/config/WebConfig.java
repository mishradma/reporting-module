package com.mycompany.reporting.config;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mycompany.reporting.web.dto.serializer.CustomDateJsonDeserializer;
import com.mycompany.reporting.web.dto.serializer.CustomDateJsonSerializer;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		SimpleModule m = new SimpleModule();
		CustomDateJsonSerializer ser = new CustomDateJsonSerializer();
		m.addSerializer(Date.class, ser);
		CustomDateJsonDeserializer deser = new CustomDateJsonDeserializer();
		m.addDeserializer(Date.class, deser);

		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder().modules(m);
		builder.serializers(ser).deserializers(deser).featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
	}
}

/**
 *
 */
package com.mycompany.reporting.web.dto;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author mishradma
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class WebResponse<T extends Serializable> implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1023560102488003521L;
	private T data;
	@Autowired
	private Status status;

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(final T data) {
		this.data = data;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(final Status status) {
		this.status = status;
	}

}

/**
 *
 */
package com.mycompany.reporting.web.dto;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author mishradma
 *
 */
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class Status implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 6278898121013042526L;
	private Boolean success = Boolean.TRUE;
	private String reason = StringUtils.EMPTY;

	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(final Boolean success) {
		this.success = success;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason
	 *            the reason to set
	 */
	public void setReason(final String reason) {
		this.reason = reason;
	}
}

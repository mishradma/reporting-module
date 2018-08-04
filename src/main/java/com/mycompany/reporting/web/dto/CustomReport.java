package com.mycompany.reporting.web.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mycompany.reporting.utils.DateUtils;
import com.mycompany.reporting.web.dto.serializer.CustomDateJsonDeserializer;
import com.mycompany.reporting.web.dto.serializer.CustomDateJsonSerializer;

public class CustomReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8265528305447043896L;
	private String entity;
	private Date settlementDate;
	private String buySell;
	private Double totalValue;
	private Integer totalTransactions;
	private String currency;

	public CustomReport(String entity, Date settlementDate, String buySell, Double totalValue) {
		super();
		this.entity = entity;
		this.settlementDate = settlementDate;
		this.buySell = buySell;
		this.totalValue = totalValue;
	}

	public CustomReport(String entity, Date settlementDate, String buySell, Double totalValue,
			Integer totalTransactions) {
		super();
		this.entity = entity;
		this.settlementDate = settlementDate;
		this.buySell = buySell;
		this.totalValue = totalValue;
		this.setTotalTransactions(totalTransactions);
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	@JsonSerialize(using = CustomDateJsonSerializer.class)
	public Date getSettlementDate() {
		return settlementDate;
	}

	@JsonDeserialize(using = CustomDateJsonDeserializer.class)
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getBuySell() {
		return buySell;
	}

	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public Integer getTotalTransactions() {
		return totalTransactions;
	}

	public void setTotalTransactions(Integer totalTransactions) {
		this.totalTransactions = totalTransactions;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Transient
	@JsonSerialize(using = CustomDateJsonSerializer.class)
	public Date getEffectiveSettlementDate() {
		return DateUtils.createEffectiveWorkingDate(currency, settlementDate);
	}

}

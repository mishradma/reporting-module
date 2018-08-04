/**
 *
 */
package com.mycompany.reporting.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.ObjectUtils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mycompany.reporting.utils.DateUtils;
import com.mycompany.reporting.web.dto.serializer.CustomDateJsonDeserializer;
import com.mycompany.reporting.web.dto.serializer.CustomDateJsonSerializer;

/**
 * @author mishradma
 *
 */
@Entity
@Table(name = "T_TRANSACTION")
@AttributeOverride(name = "uniqueDBID", column = @Column(unique = true, name = "TRANSACTION_ID", nullable = false))
public class Transaction extends PersistableEntity implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -6037911238020169507L;
	private String entity;
	private String buySell;
	private String currency;
	private Double agreedFx;
	private Date instructionDate;
	private Date settlementDate;
	private Double units;
	private Double pricePerUnit;

	/**
	 * @param entity
	 * @param buySell
	 * @param agreedFx
	 * @param currency
	 *            TODO
	 * @param instructionDate
	 * @param settlementDate
	 * @param units
	 * @param pricePerUnit
	 */
	public Transaction(String entity, String buySell, Double agreedFx, String currency, Date instructionDate,
			Date settlementDate, Double units, Double pricePerUnit) {
		super();
		this.entity = entity;
		this.buySell = buySell;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.units = units;
		this.pricePerUnit = pricePerUnit;
	}

	/**
	 *
	 */
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getBuySell() {
		return buySell;
	}

	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getAgreedFx() {
		return ObjectUtils.defaultIfNull(agreedFx, Double.valueOf(1));
	}

	public void setAgreedFx(Double agreedFx) {
		this.agreedFx = agreedFx;
	}

	public Date getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}

	@JsonSerialize(using = CustomDateJsonSerializer.class)
	public Date getSettlementDate() {
		return settlementDate;
	}

	@JsonDeserialize(using = CustomDateJsonDeserializer.class)
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public Double getUnits() {
		return ObjectUtils.defaultIfNull(units, Double.valueOf(0));
	}

	public void setUnits(Double units) {
		this.units = units;
	}

	public Double getPricePerUnit() {
		return ObjectUtils.defaultIfNull(pricePerUnit, Double.valueOf(0));
	}

	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	/**
	 * @return the transactionId
	 */
	@Transient
	public long getTransactionId() {
		return this.getUniqueDBID();
	}

	/**
	 * @param transactionId
	 *            the producId to set
	 */
	@Transient
	public void setTransactionId(final long transactionId) {
		this.setUniqueDBID(transactionId);
	}

	@Transient
	public Double getTotalAmountInUSD() {
		return getPricePerUnit() * getAgreedFx() * getUnits();
	}

	@Transient
	@JsonSerialize(using = CustomDateJsonSerializer.class)
	public Date getEffectiveSettlementDate() {
		return DateUtils.createEffectiveWorkingDate(getCurrency(), getSettlementDate());
	}

}

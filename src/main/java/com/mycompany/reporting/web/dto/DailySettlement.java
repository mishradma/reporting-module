package com.mycompany.reporting.web.dto;

import java.io.Serializable;
import java.util.Collection;

public class DailySettlement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2770373961431911931L;

	private Collection<CustomReport> report;

	public Collection<CustomReport> getReport() {
		return report;
		/*
		 * Collections.sort(report, (item1, item2) -> { return
		 * item1.getTotalValue().compareTo(item2.getTotalValue()); });
		 */
	}

	public void setReport(Collection<CustomReport> report) {
		this.report = report;
	}

}

package com.mycompany.reporting.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mycompany.reporting.repositories.TransactionRepository;
import com.mycompany.reporting.web.dto.CustomReport;
import com.mycompany.reporting.web.dto.DailySettlement;

@Service
public class DailyReportService {
	@Autowired
	TransactionRepository transRepository;

	public DailySettlement generateSettlementReport() {
		final DailySettlement report = new DailySettlement();
		// report.setReport(transRepository.createReport());
		Map<String, CustomReport> map = Maps.newHashMap();
		transRepository.findAll().forEach(item -> {
			String key = StringUtils.join(item.getBuySell(), "_", item.getEntity(),
					DateFormatUtils.format(item.getEffectiveSettlementDate(), "ddMMyyyy"));
			CustomReport record = ObjectUtils.defaultIfNull(map.get(key), new CustomReport(item.getEntity(),
					item.getSettlementDate(), item.getBuySell(), Double.valueOf(0), 0));
			map.put(key, record);
			record.setCurrency(item.getCurrency());
			record.setTotalValue(record.getTotalValue() + item.getTotalAmountInUSD());
			record.setTotalTransactions(record.getTotalTransactions() + 1);
		});
		List<CustomReport> rep = Lists.newArrayList(map.values());
		rep.sort((item1, item2) -> {
			int returnValue = item1.getBuySell().compareTo(item2.getBuySell());
			if (returnValue == 0) {
				returnValue = item1.getTotalValue().compareTo(item2.getTotalValue());
			}
			return returnValue;
		});
		report.setReport(rep);

		return report;
	};
}

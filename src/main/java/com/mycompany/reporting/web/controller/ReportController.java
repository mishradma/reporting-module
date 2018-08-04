package com.mycompany.reporting.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.reporting.service.DailyReportService;
import com.mycompany.reporting.web.dto.DailySettlement;
import com.mycompany.reporting.web.dto.WebResponse;

@RestController
@RequestMapping(value = "report")
public class ReportController extends AbstractController {
	@Autowired
	DailyReportService service;

	@RequestMapping(value = "daily/settlement", method = { RequestMethod.GET })
	public WebResponse<DailySettlement> generateDailySettlementReport() {
		WebResponse<DailySettlement> response = createResponse();
		response.setData(service.generateSettlementReport());
		return response;

	}
}

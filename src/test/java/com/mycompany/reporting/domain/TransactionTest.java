package com.mycompany.reporting.domain;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mycompany.reporting.utils.CommonConstantUtils;

public class TransactionTest {

	@Test
	public void testGetEffectiveSettlementDateForAED_Or_SAR() throws JsonProcessingException {
		Transaction tr = new Transaction();
		// ObjectMapper mapper = new ObjectMapper();
		Date currentDate = CommonConstantUtils.createNormalizedDateObject(2018, 07, 4);
		tr.setSettlementDate(currentDate);
		tr.setCurrency("AED");
		// System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tr));
		Assert.assertTrue(tr.getEffectiveSettlementDate().equals(CommonConstantUtils.createNormalizedDateObject(2018, 07, 5)));
	}

	@Test
	public void testGetEffectiveSettlementDateForNonAED_Or_SAR() throws JsonProcessingException {
		Transaction tr = new Transaction();
		// ObjectMapper mapper = new ObjectMapper();
		Date currentDate = CommonConstantUtils.createNormalizedDateObject(2018, 07, 4);
		tr.setSettlementDate(currentDate);
		tr.setCurrency("AUD");
		// System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tr));
		Assert.assertTrue(tr.getEffectiveSettlementDate().equals(CommonConstantUtils.createNormalizedDateObject(2018, 07, 6)));
		System.out.println(CommonConstantUtils.createRandomCode(3));
		System.out.println(CommonConstantUtils.createRandomCode(3));
	}

}

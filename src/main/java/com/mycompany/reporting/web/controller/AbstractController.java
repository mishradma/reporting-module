package com.mycompany.reporting.web.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Lookup;

import com.mycompany.reporting.web.dto.Status;
import com.mycompany.reporting.web.dto.WebResponse;

public class AbstractController {
	@Lookup
	protected <T extends Serializable> WebResponse<T> createResponse() {
		WebResponse<T> obj = new WebResponse<>();
		obj.setStatus(new Status());
		return obj;
	};
}

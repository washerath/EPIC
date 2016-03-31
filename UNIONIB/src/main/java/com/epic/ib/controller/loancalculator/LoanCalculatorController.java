package com.epic.ib.controller.loancalculator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : Saminda Peramuna
 * @Date Time : Mar 22, 2016:3:59:01 PM
 * @Class :LoanCalculator.java
 **/
@Controller
@Scope("request")
public class LoanCalculatorController {
	private final Log logger = LogFactory.getLog(getClass());

	@RequestMapping("/loanCalculator")
	public ModelAndView loadPage() {
		ModelAndView defaultView;
		logger.info("GET request of loan calculator...");
		defaultView = new ModelAndView("loancalculator/loancalculator");

		return defaultView;
	}
}
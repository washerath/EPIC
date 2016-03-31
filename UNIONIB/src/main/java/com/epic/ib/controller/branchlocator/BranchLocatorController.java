package com.epic.ib.controller.branchlocator;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epic.ib.bean.branchlocator.BranchLocatorInputBean;
import com.epic.ib.dao.branchatm.BranchAtmDAO;
import com.epic.ib.mapping.BranchAtm;

/**
 * @author : Saminda Peramuna
 * @Date Time : Mar 21, 2016:8:50:05 PM
 * @Class :BranchLocatorController.java
 **/
@Controller
@Scope("request")
public class BranchLocatorController {
	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	BranchAtmDAO branchAtmDao;

	/**
	 * Initial view display of the ATM Locator.
	 * 
	 * @param inputData
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ATMLocator")
	public ModelAndView searchQuery(@ModelAttribute("searchForm") BranchLocatorInputBean inputData, ModelMap model) {
		ModelAndView defaultView;
		logger.info("GET request of branch locator ..");
		List<BranchAtm> allBranches = branchAtmDao.getBranchAtmCollection();
		inputData.setBranches(allBranches);
		defaultView = new ModelAndView("branchlocator/branchlocator", "searchForm", inputData);
		
		return defaultView;
	}
}

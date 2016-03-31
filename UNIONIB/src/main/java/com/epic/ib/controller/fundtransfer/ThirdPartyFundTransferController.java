package com.epic.ib.controller.fundtransfer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epic.ib.bean.fundtransfer.ThirdPartyTransfersInputBean;
import com.epic.ib.bean.fundtransfer.ThirdPartyTransfersOutputBean;
import com.epic.ib.bean.session.SessionBean;
import com.epic.ib.dao.common.CommonDAO;
import com.epic.ib.dao.fundtransfer.FundTransferDAO;
import com.epic.ib.mapping.Ibmobuser;
import com.epic.ib.mapping.UserAccount;

/**
 * @author : Saminda Peramuna
 * @Date Time : Mar 27, 2016:10:55:25 AM
 * @Class :ThirdPartyFundTransferController.java
 **/
@Controller
@Scope("request")
public class ThirdPartyFundTransferController {
	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	SessionBean session;
	
	@Autowired 
	FundTransferDAO fundTransferDao;
	
	@Autowired
	CommonDAO commonDao;
	
	/**
	 * GET method which is used to transfer the page load data.
	 * 
	 * @param outPutData
	 * @param model
	 * @return
	 */
	@RequestMapping(value="fundTransfers/thirdParty", method=RequestMethod.GET)
	public ModelAndView loadPage(@ModelAttribute("pageLoadData") ThirdPartyTransfersOutputBean outPutData, ModelMap model) {
		ModelAndView defaultView;
		Ibmobuser user = session.getIbmobuser();
		UserAccount userAccounts;
		
		fundTransferDao.getUserAccountCollection();
		logger.info("GET method of third party fund transfers ...");
		outPutData.setBanks(commonDao.getBankCollection());
		
		//outPutData.setOwnAccounts(fundTransferDao.get);
		
		defaultView = new ModelAndView("fundtransfers/thirdparty", "pageLoadData", outPutData);
		
		return defaultView;
	}
	
	@RequestMapping(value = "fundTransfers/thirdPartyPOST", method = RequestMethod.POST)
	public ModelAndView postPage(@ModelAttribute("thirdPartyForm") ThirdPartyTransfersInputBean inputData,
			ModelMap model) {
		ModelAndView defaultView;
		logger.info("POST method of third party fund trasnsfers ...");
		defaultView = new ModelAndView("fundtransfers/thirdparty", "thirdPartyFrom", inputData);

		return defaultView;
	}
}

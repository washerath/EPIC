package com.epic.ib.controller.home;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epic.ib.bean.session.SessionBean;
import com.epic.ib.dao.login.UserFavouritesDAO;
import com.epic.ib.dao.menu.CommonMenuDAO;

/**
*@author : Bilal AK
*@Date Time : Mar 23, 2016:4:17:44 PM
*@Class :HomeController.java
**/

@Controller
public class HomeController {
private final Log logger =  LogFactory.getLog(getClass());

@Autowired
UserFavouritesDAO favDAO;
@Autowired
CommonMenuDAO menuDAO;
@Autowired
SessionBean session;

	@RequestMapping(value = "/home", method = {RequestMethod.GET})
	public ModelAndView getHome(ModelMap favAttribute,HttpSession commonSession){
		logger.info("in the main Controller");
		/**
		 * insert an image to your profile with this method!
		 */
		//favDAO.insertImage();
		long userid=session.getIbmobuser().getUserid();
		session.setFavouritesMap(favDAO.getUserFavourites(userid));
		session.setMenuSectionMap(menuDAO.getMenuSections());
		session.setMenuPagesMap(menuDAO.getPageBySection(session.getMenuSectionMap()));
		commonSession.setAttribute("userimage", session.getImage());
		favAttribute.put("userFavourites", session.getFavouritesMap());
		commonSession.setAttribute("menuSection",session.getMenuSectionMap());
		logger.info("Pages in the menu are:"+menuDAO.getPageBySection(session.getMenuSectionMap()));
		commonSession.setAttribute("menuPages",session.getMenuPagesMap());
		return new ModelAndView("home/home");
	}
	
}

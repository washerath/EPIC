package com.epic.ib.controller.login;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epic.ib.bean.login.LoginInputBean;
import com.epic.ib.bean.session.SessionBean;
import com.epic.ib.dao.login.LoginDAO;

/**
 * @author : Asitha Perera
 * @Date Time : Mar 17, 2016:5:19:18 PM
 * @Class :LoginController.java
 **/
/**
 * @author Bilal AK
 *
 */
@Controller
@Scope("request")
public class LoginController {
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	SessionBean session;

	@Autowired
	LoginDAO loginDao;

	@Autowired
	private MessageSource messageSource;

	/**
	 * Welcome login function
	 * 
	 * @param model
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelMap model) {

		ModelAndView mv = new ModelAndView("login/login", "loginform",
				new LoginInputBean());
		return mv;
	}

	/**
	 * Logging out function
	 * 
	 * @param error
	 * @param model
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(
			@RequestParam(value = "error", required = false) Integer error,
			ModelMap model,HttpSession ses) {
		logger.info("Logging out.");
		logger.info("Error : " + error);
		if (error != null) {
			session.setIbmobuser(null);
			session.setImage(null);
			session.getFavouritesMap().clear();
			session.getMenuPagesMap().clear();
			session.getMenuPagesMap().clear();
			session.logout();
			ses.invalidate();
			session=null;
			
			
			if (error == 1) {
				// access denied.
			}
		}
		ModelAndView mv = new ModelAndView("login/login", "loginform",
				new LoginInputBean());
		return mv;
	}

	/**
	 * Check Username function
	 * 
	 * @param logindata
	 * @param model
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/checkUsername", method = { RequestMethod.POST })
	public ModelAndView checkUsername(@ModelAttribute("loginform") LoginInputBean logindata, ModelMap model,
			Locale locale) {
		String user = logindata.getUsername();
		logger.info(user + "---From Controller---");
		// get user details
		// set user details to session
		ModelAndView mv = null;
		if (loginDao.getUser(user)) {
			logger.info("Username is available");
			session.setUsername(user);
			String encodedString="";
			try{
			byte [] encodedImage=Base64.encodeBase64(loginDao.getUserImage());
			encodedString = new String(encodedImage);
			logger.info("image from db:"+encodedString.length());
			session.setImage(encodedString);
			}catch(Exception e){
				logger.error(e);
			}
			model.put("title",loginDao.getTitle());
			model.put("firstname", loginDao.getFirstname());
			model.put("lastname", loginDao.getLastname());
			model.put("userimage",encodedString);
			mv = new ModelAndView("login/login_pass", "loginform", logindata);
		} else {

			logger.info("Wrong username..");
			logger.info("Current locale " + locale.toString());
			String errorMessage = messageSource.getMessage("error.username", new Object[] {user}, locale);
			Map<String, String> message = new HashMap<String, String>();
			message.put("message", errorMessage);
			mv = new ModelAndView("login/login");
			mv.addObject("message", message);
		}

		return mv;
	}
	
	

	/**
	 * Check password function
	 * 
	 * @param logindata
	 * @param model
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/checkPassword", method = { RequestMethod.POST })
	public String checkPassword(@ModelAttribute("loginform") LoginInputBean logindata, ModelMap model, Locale locale, RedirectAttributes redirectAttributes) {
		String mv = null;
		if (session != null || !session.getUsername().equals("")) {
			String username = session.getUsername();			
			logger.info("Username from the previous form:" + username);
			logger.info(logindata.getPassword());
			if (loginDao.getUserPassword(username, logindata.getPassword())) {
				session.setUsername("");
				session.setIbmobuser(loginDao.getUserProfile(username, logindata.getPassword()));
				
				logger.info("Ibmobuser is set successfully in the session.");
				mv = "redirect:home.htm";
			} else {
				logger.info("Wrong password");
				redirectAttributes.addAttribute("success", "false");
				mv = "redirect:login_pass.htm";
			}

		} else {
			mv = "redirect:login_pass.htm";
		}

		return mv;
	}
	
	@RequestMapping(value = "/loginerror", method = RequestMethod.GET)
	public ModelAndView loginError() {

		ModelAndView mv = new ModelAndView("login/loginerror");
		return mv;
	}
	
	@RequestMapping(value = "/checkUsername", method = RequestMethod.GET)
	public ModelAndView checkUsername(Model model) {

		ModelAndView mv = new ModelAndView("login/login");
		model.addAttribute("loginform", new LoginInputBean()); 
		return mv;
	}
	
	@RequestMapping(value = "/login_pass", method = RequestMethod.GET)
	public ModelAndView loginPassword(@ModelAttribute("loginform") LoginInputBean logindata,ModelMap model, @RequestParam(required=false) boolean success, Locale locale) {

		logger.info("user name ========= "+ session.getUsername());
		logindata.setUsername(session.getUsername());
		ModelAndView mv = new ModelAndView("login/login_pass","loginform", logindata);
		logger.info("success message " +success);
		String user = session.getUsername();
		if (loginDao.getUser(user)) {
			logger.info("Username is available");
			String encodedString="";
			try{
			byte [] encodedImage=Base64.encodeBase64(loginDao.getUserImage());
			encodedString = new String(encodedImage);
			logger.info("image from db:"+encodedString.length());
			session.setImage(encodedString);
			}catch(Exception e){
				logger.error(e);
			}
			model.put("title",loginDao.getTitle());
			model.put("firstname", loginDao.getFirstname());
			model.put("lastname", loginDao.getLastname());
			model.put("userimage",encodedString);
		}
		if(!success){
			String errorMessage = messageSource.getMessage("error.password", null, locale);
			Map<String, String> message = new HashMap<String, String>();
			message.put("message", errorMessage);
			mv.addObject("message", message);
		}
		return mv;
	}


}

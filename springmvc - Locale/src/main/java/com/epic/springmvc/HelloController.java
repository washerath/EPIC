package com.epic.springmvc;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		ModelAndView model = new ModelAndView("LocalePage");
		return model;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		// binder.setDisallowedFields(new String[] {"studentMobile"});
		// SimpleDateFormat dateFormat = new
		// SimpleDateFormat("yyyy****MM****dd");
		// binder.registerCustomEditor(Date.class, "studentDOB", new
		// CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}

	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {

		ModelAndView model1 = new ModelAndView("AdmissionForm");

		return model1;
	}

	@ModelAttribute
	public void addingCommonObjects(Model model1) {

		model1.addAttribute("headerMessage", "Gontu College of Engineering, India");
	}

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1") Student student, BindingResult result,
			Locale locale) {

		if (result.hasErrors()) {

			ModelAndView model1 = new ModelAndView("AdmissionForm");
			String errorMessage = messageSource.getMessage("error.message", null, locale);
			Map<String, String> message = new HashMap<String, String>();
			message.put("message", errorMessage);
			model1.addObject("message", message);

			return model1;
		}

		ModelAndView model1 = new ModelAndView("AdmissionSuccess");
		return model1;
	}
	
	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.GET)
	public ModelAndView submitAdmissionForm() {

		ModelAndView model1 = new ModelAndView("AdmissionForm");
		return model1;
	}

}

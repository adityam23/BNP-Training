package com.project.SpringProject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.SpringProject.model.Feedback;
import com.project.SpringProject.service.FeedbackService;

@Controller
@SessionAttributes("feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackService feedServe;
	
	@RequestMapping(value = "/feedback", method = RequestMethod.GET)
	public String showFeedbackPage(ModelMap model) {
		Feedback fb = new Feedback();
		model.addAttribute("feedback", fb);
		return "feedback";
	}
	
	@RequestMapping(value = "/add-feedback", method = RequestMethod.POST)
	public String takeFeedback(ModelMap model, @Valid Feedback fb, BindingResult result) {
		if(result.hasErrors()) {
			return "error";
		}
		//String name = (String)result.getFieldValue("name");
		feedServe.addFeedback(fb.getUserName(), fb.getFeedbackText(), fb.getRating(), fb.getEmail());
		return "complete";
	}
}

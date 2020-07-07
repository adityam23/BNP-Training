package com.project.SpringProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SpringProject.dao.MyProjectRepo;
import com.project.SpringProject.model.Feedback;

@Service
public class FeedbackService {
	private static List<Feedback> feedbacks = new ArrayList<Feedback>();
	@Autowired
	private MyProjectRepo mpr;
	
	public void addFeedback(String name, String text, String rating, String email) {
		Feedback fb = new Feedback();
		fb.setEmail(email);
		fb.setUserName(name);
		fb.setFeedbackText(text);
		fb.setRating(rating);
		feedbacks.add(fb);
		mpr.saveAll(feedbacks);
	}
}

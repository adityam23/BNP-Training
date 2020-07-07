package com.project.SpringProject.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Feedback {
	@Id
	@GeneratedValue
	private int feedbackId;
	private String userName;
	private String feedbackText;
	private String rating;
	private String email;
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFeedbackText() {
		return feedbackText;
	}
	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}

	
	
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", userName=" + userName + ", feedbackText=" + feedbackText
				+ ", rating=" + rating + ", email=" + email + "]";
	}
	/*
	 * public Feedback(String userName, String feedbackText, int rating, String
	 * email) { super(); this.userName = userName; this.feedbackText = feedbackText;
	 * this.rating = rating; this.email = email; }
	 */
	
	
}

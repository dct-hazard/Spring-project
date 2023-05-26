package com.studentrating.response.dto;


import java.util.ArrayList;

public class answerresponse {

	
	private String subject;
	private ArrayList<Pair> ans= new ArrayList<Pair>();
	private double overall;
	public answerresponse(String subject, ArrayList<Pair> ans, double overall) {
		super();
		this.subject = subject;
		this.ans = ans;
		this.overall = overall;
	}
	public double getOverall() {
		return overall;
	}
	public void setOverall(double overall) {
		this.overall = overall;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public ArrayList<Pair> getAns() {
		return ans;
	}
	public void setAns(ArrayList<Pair> ans) {
		this.ans = ans;
	}
	public answerresponse(String subject, ArrayList<Pair> ans) {
		super();
		this.subject = subject;
		this.ans = ans;
	}
	@Override
	public String toString() {
		return "answerresponse [subject=" + subject + ", ans=" + ans + ", overall=" + overall + "]";
	}
	public answerresponse() {
		super();
	}
	
	
}
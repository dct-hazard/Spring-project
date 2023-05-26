package com.studentrating.response.dto;

import java.util.ArrayList;

public class ansresponse {

	
	private String studentname;
	private ArrayList<Pair> ans=new ArrayList<Pair>();
	
	private double overall;

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public ArrayList<Pair> getAns() {
		return ans;
	}

	public void setAns(ArrayList<Pair> ans) {
		this.ans = ans;
	}

	public double getOverall() {
		return overall;
	}

	public void setOverall(double overall) {
		this.overall = overall;
	}

	@Override
	public String toString() {
		return "ansresponse [studentname=" + studentname + ", ans=" + ans + ", overall=" + overall + "]";
	}

	public ansresponse(String studentname, ArrayList<Pair> ans, double overall) {
		super();
		this.studentname = studentname;
		this.ans = ans;
		this.overall = overall;
	}

	public ansresponse() {
		super();
	}
	
	
	
	
	
}

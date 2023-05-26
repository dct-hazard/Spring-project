package com.studentrating.response.dto;

public class Pair {
	
	private String assignmentname;
	private double average;

	
	public Pair(String as,double avg)
	{
		assignmentname=as;
		average=avg;
		
	}
	

	@Override
	public String toString() {
		return "Pair [assignmentname=" + assignmentname + ", average=" + average + "]";
	}

	public String getAssignmentname() {
		return assignmentname;
	}

	public void setAssignmentname(String assignmentname) {
		this.assignmentname = assignmentname;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

}

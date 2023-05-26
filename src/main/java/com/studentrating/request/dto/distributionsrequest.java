package com.studentrating.request.dto;

public class distributionsrequest {

	private String assignmentcategory;
	private float weight;
	
	
	public distributionsrequest() {
		super();
	}
	public distributionsrequest(String assignmentcategory, float weight) {
		super();
		this.assignmentcategory = assignmentcategory;
		this.weight = weight;
	}
	public String getAssignmentcategory() {
		return assignmentcategory;
	}
	public void setAssignmentcategory(String assignmentcategory) {
		this.assignmentcategory = assignmentcategory;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "distributionsrequest [assignmentcategory=" + assignmentcategory + ", weight=" + weight + "]";
	}

	
}

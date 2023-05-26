package com.studentrating.response.dto;

public class distributionsresponse {

	private String assignmentcategory;
	private float weight;
	
	
	public distributionsresponse() {
		super();
	}
	public distributionsresponse(String assignmentcategory, float weight) {
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
		return "distributionsresponse [assignmentcategory=" + assignmentcategory + ", weight=" + weight + "]";
	}

	
}

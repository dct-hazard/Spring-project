package com.studentrating.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Distributions")
public class distributions {
	
	

	public distributions() {
		super();
	}

	public distributions(String assignmentcategory, float weight) {
		super();
		this.assignmentcategory = assignmentcategory;
		this.weight = weight;
	}

	@Id
	@Column(name="Assignment_category")
	private String assignmentcategory;
	
	@Column
	private float weight;

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
		return "distributions [assignmentcategory=" + assignmentcategory + ", weight=" + weight + "]";
	}


	
	
	
}

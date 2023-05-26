package com.studentrating.response.dto;

import java.util.Date;

public class assignmentsresponse {

	private int serialno;
	private String studentname;
	private String subject;
	private String assignmentcategory;
	private Date dateofsubmission;
	private int points;
	public int getSerialno() {
		return serialno;
	}
	public void setSerialno(int serialno) {
		this.serialno = serialno;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAssignmentcategory() {
		return assignmentcategory;
	}
	public void setAssignmentcategory(String assignmentcategory) {
		this.assignmentcategory = assignmentcategory;
	}
	public Date getDateofsubmission() {
		return dateofsubmission;
	}
	public void setDateofsubmission(Date dateofsubmission) {
		this.dateofsubmission = dateofsubmission;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "assignmentsresponse [serialno=" + serialno + ", studentname=" + studentname + ", subject=" + subject
				+ ", assignmentcategory=" + assignmentcategory + ", dateofsubmission=" + dateofsubmission + ", points="
				+ points + "]";
	}
	

	

	
}

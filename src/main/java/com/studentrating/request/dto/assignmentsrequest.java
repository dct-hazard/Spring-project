package com.studentrating.request.dto;

public class assignmentsrequest {

	private  String studentname;
	private String subject;
	private String assignmentcategory;
	
	public assignmentsrequest() {
		super();
	}
	public assignmentsrequest(String studentname, String subject, String assignmentcategory) {
		super();
		this.studentname = studentname;
		this.subject = subject;
		this.assignmentcategory = assignmentcategory;
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
	@Override
	public String toString() {
		return "assignmentsrequest [studentname=" + studentname + ", subject=" + subject + ", assignmentcategory="
				+ assignmentcategory + "]";
	}
	
	
}

package com.studentrating.models;

//import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.Transient;

@Entity
@Table(name="Assignments")
public class assignments {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="serial_no")
	private int serialno;
	
	
	@Column(name="student_name")
	private String studentname;
	

	@Column
	private String subject;
	

	@Column(name="assignment_category")
	private String assignmentcategory;
	
	@Column(name="date_of_submission")
	@Temporal(TemporalType.TIMESTAMP)
    private Date dateofsubmission;
	
	
	
	public assignments(String studentname, String subject, String assignmentcategory) {
		super();
		this.studentname = studentname;
		this.subject = subject;
		this.assignmentcategory = assignmentcategory;
	}

	public assignments() {
		super();
	}

	public assignments(int serialno, String studentname, String subject, String assignmentcategory,
			Date dateofsubmission, int points) {
		super();
		this.serialno = serialno;
		this.studentname = studentname;
		this.subject = subject;
		this.assignmentcategory = assignmentcategory;
		this.dateofsubmission = dateofsubmission;
		this.points = points;
	}

	@Column
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
	
	
	
}

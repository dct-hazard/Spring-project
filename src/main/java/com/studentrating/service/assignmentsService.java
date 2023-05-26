package com.studentrating.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.studentrating.exceptions.DuplicateCategories;
import com.studentrating.exceptions.ResourceNotFoundException;
import com.studentrating.models.assignments;
import com.studentrating.request.dto.assignmentsrequest;
import com.studentrating.response.dto.ansresponse;
import com.studentrating.response.dto.answerresponse;
import com.studentrating.response.dto.assignmentsresponse;

public interface assignmentsService {

	//CFREATE 
	public assignments savestudents(assignmentsrequest students) throws DuplicateCategories;
	
	//READ
	public List<assignmentsresponse> studentsinfo() throws ResourceNotFoundException;
	
	
	//UPDATE INFO'S
	public void updatestudentname(String oldname,String newname) throws ResourceNotFoundException;
	
	public void updatesubjectname(String subjectname, String newsubjectname) throws ResourceNotFoundException;
	

	
	public void updateassignmentcategoryname(String uscn, String newuscn) throws ResourceNotFoundException;
	
	//UPDATE DATE OF SUBMISSION
	public assignments updatedateofsubmission(assignmentsrequest asreq,Date date) throws ResourceNotFoundException;
	
	//UPDATE POINTS
	public assignments updatepoints(assignmentsrequest asreq, int points) throws ResourceNotFoundException;
	
	//DELETE 
	public assignments deleterecord(int serialno) throws ResourceNotFoundException;
	
	public ArrayList<answerresponse> getanswerbyname(String studentname);
	
	public ArrayList<ansresponse> getanswerbysubjectname(String studentname);
	
	public assignments updatestudent(int id,assignmentsrequest as) throws ResourceNotFoundException;
	
	
	
	
	
}

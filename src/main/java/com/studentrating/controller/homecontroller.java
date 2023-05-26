package com.studentrating.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.studentrating.request.dto.*;
import com.studentrating.response.dto.ansresponse;
import com.studentrating.response.dto.answerresponse;
import com.studentrating.response.dto.assignmentsresponse;
import com.studentrating.response.dto.distributionsresponse;
import com.studentrating.service.assignmentsService;
import com.studentrating.service.distributionsService;
import com.studentrating.dto.converter.assignmentsconverter;
import com.studentrating.dto.converter.distributionsconverter;
import com.studentrating.exceptions.DuplicateCategories;

import com.studentrating.exceptions.ResourceNotFoundException;
import com.studentrating.models.assignments;
import com.studentrating.models.distributions;
@RestController
public class homecontroller {

	
	
	@Autowired
	distributionsService dsrser;
	
	@Autowired
	assignmentsService asrser;
	
	@Autowired
	private distributionsconverter discon;
	
	@Autowired
	private assignmentsconverter ascon;
	
	
	// TO ADD A CATEGORY IN DISTRIBUTIONS TABLE (ADDING CATEGORY ONE BY ONE USING "UI FORM")
	
	@PostMapping(path="/addcategory")
	public ResponseEntity<distributionsresponse> savecategories(@RequestBody distributionsrequest cat) throws DuplicateCategories
	{
		distributions category=dsrser.savecategory(cat);
		return new ResponseEntity<distributionsresponse>(discon.entityToDto(category),HttpStatus.CREATED);
	}
	
	
	
	// TO VIEW DISTRIBUTIONS TABLE
	
	@GetMapping("/distributions")
	public ResponseEntity<List<distributionsresponse>> allcategories() throws ResourceNotFoundException
	{
		List<distributions> list=dsrser.distributions();
			
		return new ResponseEntity<List<distributionsresponse>>(discon.entityToDto(list),HttpStatus.OK);
	}
	
	
	
	//DELETING A CATEGORY FROM DISTRIBUTIONS TABLE
	
	@DeleteMapping("/deletecategory/{id}")
	public ResponseEntity<distributionsresponse> deletecategories(@PathVariable String id) throws ResourceNotFoundException
	{
		distributions del=dsrser.deletecategory(id);
		return new ResponseEntity<distributionsresponse>(discon.entityToDto(del),HttpStatus.ACCEPTED);
	}
	
	
	
	// ENROLLING STUDENTS FOR SUBJECT WITH ASSIGNMENT CATEGORY 
	
	@PostMapping(path="/addstudents")
	public ResponseEntity<assignmentsresponse> savestudents(@RequestBody assignmentsrequest asreq) throws DuplicateCategories
	{
		assignments as=asrser.savestudents(asreq);
		
		return new ResponseEntity<assignmentsresponse>(ascon.entityToDto(as),HttpStatus.CREATED);
		
	}
	
	//VIEWING ASSIGNMENTS TABLE
	
	@GetMapping("/studentsinfo")
	public ResponseEntity<List<assignmentsresponse>> studentsinfo() throws ResourceNotFoundException
	{
		List<assignmentsresponse> list=asrser.studentsinfo();
		
		return new ResponseEntity<List<assignmentsresponse>>(list,HttpStatus.OK);
	}
	
	
	
	//UPDATING DATE OF SUBMISSION OF ASSIGNMENT
	
	@PutMapping(path="/updatedateofsubmission")
	public ResponseEntity<assignmentsresponse> updatedos(@RequestBody assignmentsrequest asreq,@RequestParam Date date) throws ResourceNotFoundException
	{
		
		assignments as= asrser.updatedateofsubmission(asreq, date);

		return new ResponseEntity<assignmentsresponse>(ascon.entityToDto(as),HttpStatus.OK);
		
	}
	
	//UPDATING POINTS 
	
	@PutMapping(path="/updatepoints")
	public ResponseEntity<assignmentsresponse> updatepoints(@RequestBody assignmentsrequest asreq,@RequestParam int points) throws ResourceNotFoundException
	{
		assignments as=asrser.updatepoints(asreq, points);

		return new ResponseEntity<assignmentsresponse>(ascon.entityToDto(as),HttpStatus.OK);
		
	}
	
	//UPDATE STUDENT INFO
	
	@PutMapping(path="/updatestudents")
	public ResponseEntity<assignmentsresponse> updatestudent(@RequestParam int id,@RequestBody assignmentsrequest asreq) throws ResourceNotFoundException
	{
		assignments as=asrser.updatestudent(id, asreq);
		
		return new ResponseEntity<assignmentsresponse>(ascon.entityToDto(as),HttpStatus.OK);
	}
	
	//UPDATING STUDENT NAME (Extra)
	
	@PutMapping(path="/updatestudentname")
	public ResponseEntity<String> updatestudentname(@RequestParam String oldname,@RequestParam String newname) throws ResourceNotFoundException
	{
		asrser.updatestudentname(oldname, newname);
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
	
	//UPDATING SUBJECT NAME (Extra)
	
	@PutMapping(path="/updatesubject")
	public ResponseEntity<String> updatesubject(@RequestParam String oldsubject,@RequestParam String newsubject) throws ResourceNotFoundException
	{
		asrser.updatesubjectname(oldsubject, newsubject);
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
	
	//UPDATING ASSIGNMENT CATEGORY (Extra)
	
	@PutMapping(path="/updateassignmemntname")
	public ResponseEntity<String> updateassignmentname(@RequestParam String oldname,@RequestParam String newname) throws ResourceNotFoundException
	{
		asrser.updateassignmentcategoryname(oldname, newname);
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
	
	//
	
	@DeleteMapping(path="/deletestudentrecord/{serialno}")
	public ResponseEntity<assignmentsresponse> deletestudentrecord(@PathVariable int serialno) throws ResourceNotFoundException
	{
		assignments del=asrser.deleterecord(serialno);
		return new ResponseEntity<assignmentsresponse>(ascon.entityToDto(del),HttpStatus.ACCEPTED);
	}
	

		
	@GetMapping(path="/getanswer/{studentname}")
	public ResponseEntity<ArrayList<answerresponse>> getanswer(@PathVariable String studentname) throws ResourceNotFoundException
	{
		ArrayList<answerresponse> al=asrser.getanswerbyname(studentname);
				if(al.isEmpty())
					throw new ResourceNotFoundException("No info Found");
		return new ResponseEntity<ArrayList<answerresponse>>(al,HttpStatus.OK);
	}
	
	
	@GetMapping(path="/getanswerbysubject/{subjectname}")
	public ResponseEntity<ArrayList<ansresponse>> getanswers(@PathVariable String subjectname) throws ResourceNotFoundException
	{
		ArrayList<ansresponse> al=asrser.getanswerbysubjectname(subjectname);	
		if(al.isEmpty())
			throw new ResourceNotFoundException("No info Found");
		 return new ResponseEntity<ArrayList<ansresponse>>(al,HttpStatus.OK);
		
	}
	
	
	
	
}





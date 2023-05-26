package com.studentrating.dto.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.studentrating.models.assignments;
import com.studentrating.request.dto.assignmentsrequest;
import com.studentrating.response.dto.assignmentsresponse;

@Component
public class assignmentsconverter {

	public assignments dtoToEntity(assignmentsrequest asreq)
	{
		assignments asnmt=new assignments();
		asnmt.setStudentname(asreq.getStudentname());
		asnmt.setSubject(asreq.getSubject());
		asnmt.setAssignmentcategory(asreq.getAssignmentcategory());
		
		
		return asnmt;
	}
	
	public assignmentsresponse entityToDto(assignments as)
	{
		assignmentsresponse asres=new assignmentsresponse();
		
		asres.setSerialno(as.getSerialno());
		asres.setStudentname(as.getStudentname());
		asres.setSubject(as.getSubject());
		asres.setAssignmentcategory(as.getAssignmentcategory());
		asres.setDateofsubmission(as.getDateofsubmission());
		asres.setPoints(as.getPoints());
		return asres;
	}
	
	public List<assignments> dtoToEntity(List<assignmentsrequest> asr)
	{
		
		return asr.stream().map( x -> dtoToEntity(x)).collect(Collectors.toList());
		
	}
	
	public List<assignmentsresponse> entityToDto(List<assignments> as)
	{
		return as.stream().map( x -> entityToDto(x)).collect(Collectors.toList());
	}
}

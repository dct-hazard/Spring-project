package com.studentrating.serviceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import java.util.LinkedHashSet;
//import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentrating.dto.converter.assignmentsconverter;
import com.studentrating.exceptions.DuplicateCategories;
import com.studentrating.exceptions.ResourceNotFoundException;
import com.studentrating.models.assignments;
import com.studentrating.models.distributions;
import com.studentrating.repository.assignmentsrepo;
import com.studentrating.repository.distributionsrepo;
import com.studentrating.request.dto.assignmentsrequest;
import com.studentrating.response.dto.Pair;
import com.studentrating.response.dto.ansresponse;
import com.studentrating.response.dto.answerresponse;
import com.studentrating.response.dto.assignmentsresponse;
import com.studentrating.service.assignmentsService;

@Service
public class assignmentsServiceImpl implements assignmentsService{

	@Autowired
	assignmentsrepo asrepo;
	
	@Autowired
	distributionsrepo dsrepo;
	
	@Autowired
	assignmentsconverter ascon;
	
	
	//Saving Student
	
	@Override
	public assignments savestudents(assignmentsrequest students) throws DuplicateCategories {
		// TODO Auto-generated method stub
		Optional<assignments> find=Optional.ofNullable(asrepo.findByStudentnameAndSubjectAndAssignmentcategory(students.getStudentname(),students.getSubject(),students.getAssignmentcategory()));
		assignments as=null;
		if(!find.isPresent())
		{
				 as=ascon.dtoToEntity(students);
				 asrepo.save(as);
		}
		else
			throw new DuplicateCategories("Record already exists");
		return as;
		
	}

	//Getting Student info
	
	@Override
	public List<assignmentsresponse> studentsinfo() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<List<assignments>> find=Optional.ofNullable(asrepo.findAll());
		List<assignments> as=null;
		if(find.isPresent())
		{
			as=find.get();
		}
		else throw new ResourceNotFoundException("Student Record Does Not Exists !");
		return ascon.entityToDto(as);
	}
	
	//Update Student
	
	@Override
	public assignments updatestudent(int id,assignmentsrequest asreq) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<assignments> find=asrepo.findById(id);
		assignments as=null;
		if(find.isPresent())
		{
			as=find.get();
			as.setAssignmentcategory(asreq.getAssignmentcategory());
			as.setSubject(asreq.getSubject());
			as.setStudentname(asreq.getStudentname());
			asrepo.save(as);
		}else
			throw new ResourceNotFoundException("Record does not exist to update!");
		
		
		return as;
	}

	//Update Date Of Submission
	
	@Override
	public assignments updatedateofsubmission(assignmentsrequest asreq,Date date) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Optional<assignments> find=Optional.ofNullable(asrepo.findByStudentnameAndSubjectAndAssignmentcategory(asreq.getStudentname(),asreq.getSubject(),asreq.getAssignmentcategory()));
		assignments as=null;
		if(find.isPresent())
		{
			as=find.get();
			as.setDateofsubmission(date);
			asrepo.save(as);
		}
		else
			throw new ResourceNotFoundException("Record does not exist to update!");

		return as;
	}
	
	//Update POINTs
	
	@Override
	public assignments updatepoints(assignmentsrequest asreq,int points) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		//assignments as=asrepo.findByStudentnameAndSubjectAndAssignmentcategory(asreq.getStudentname(),asreq.getSubject(),asreq.getAssignmentcategory());
/**/		Optional<assignments> find=Optional.ofNullable(asrepo.findByStudentnameAndSubjectAndAssignmentcategory(asreq.getStudentname(),asreq.getSubject(),asreq.getAssignmentcategory()));
		assignments as=null;
		if(find.isPresent())
		{
			as=find.get();
			as.setPoints(points);
			asrepo.save(as);
		}else
			throw new ResourceNotFoundException("Record does not exist to update!");
	return as;
		
	}
	
	@Override
	public void updatestudentname(String oldname,String newname) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		List<assignments> find=asrepo.findByStudentname(oldname);
		

		if(find.isEmpty())
		{
			throw new ResourceNotFoundException("Student does not exist to update!");
		}
		
				for(assignments as: find)
				{
					as.setStudentname(newname);
					asrepo.save(as);
				}
		}

	

	@Override
	public void updatesubjectname(String subjectname,String newsubjectname) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		List<assignments> as=asrepo.findBySubject(subjectname);
	
		if(as.isEmpty())
		{
			throw new ResourceNotFoundException("Subject does not exist to update!");
		}
		
			for(assignments assignment: as)
			{
				assignment.setSubject(newsubjectname);
				asrepo.save(assignment);
			}
		}
		
		
		
		
	

	@Override
	public void updateassignmentcategoryname(String oldname, String newname) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		List<assignments> as= asrepo.findByAssignmentcategory(oldname);
	
		if(as.isEmpty())
		{
			throw new ResourceNotFoundException("Assignment Category does not exist to update!");
		}
		
			for(assignments a: as)
			{
				a.setAssignmentcategory(newname);
				asrepo.save(a);
			}
		
	}

	

	@Override
	public assignments deleterecord(int serialno) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		assignments as=asrepo.findBySerialno(serialno);
		if(as==null)
			throw new ResourceNotFoundException("Record does not Exist to delete");
		asrepo.deleteById(serialno);
		return as;
	}

	
	
	
	
	

	
	
	
	
	
	
	public ArrayList<answerresponse> getanswerbyname(String studentname) {
	  double avgscore=0;
	  double overall=0;
	  
	  ArrayList<answerresponse> ans=new ArrayList<answerresponse>();
	  
	  //Step1: Finding out the record of students that matches with the given Name
	  
	  List<assignments> ass=asrepo.findByStudentname(studentname);
	  
	  //Step2: For that particular student Finding out the NAME OF SUBJECTS he is enrolled into using HashSet
	  
	  HashSet<String> hs=new LinkedHashSet<String>();
	  for(assignments x:ass)
	  {
		  hs.add(x.getSubject());
	  }
	  
	  //Step3:iterating to perform calculations For that student ->for each different subject
	  
	 for(String sub: hs)
	{
				 answerresponse ns=new answerresponse();
		ArrayList<Pair> pair=new ArrayList<Pair>();
		 ns.setSubject(sub);

		 
		 //Step4: Finding out all the assignment category 
		List<distributions> ds=dsrepo.findAll();
		
		
		for(int j=0;j<ds.size();j++)
		{
			//NOte: converting all assignments name to lower case and filtering first three letters for ex. lab work=lab, Project=pro 
			String s=ds.get(j).getAssignmentcategory().toLowerCase();

		//Step5.  Finding record for student name for each subject for each assignment
			List<assignments> as=asrepo.findByname(studentname,sub,s.substring(0,3));
		
		
			for(int k=0;k<as.size();k++)
			{
			//Step6. Finally calculating average score
			avgscore=avgscore+((ds.get(j).getWeight()/as.size())*as.get(k).getPoints());		
			}
		
			avgscore=avgscore/100;		
			pair.add(new Pair(ds.get(j).getAssignmentcategory(),avgscore));
			avgscore=0;	
		}
		
		ns.setAns(pair);
		
		for(Pair it:pair)
		{
			overall=overall+it.getAverage();
		}
		ns.setOverall(overall);
	
		ans.add(ns);
		overall=0;
		
	}
	 
	 return ans;
}

	@Override
	public ArrayList<ansresponse> getanswerbysubjectname(String subjectname) {
		// TODO Auto-generated method stub
		
		double avgscore=0;
		  double overall=0;
		  
		  ArrayList<ansresponse> ans=new ArrayList<ansresponse>();
		  
		  List<assignments> ass=asrepo.findBySubject(subjectname);
		  
		  HashSet<String> hs=new LinkedHashSet<String>();
		  for(assignments x:ass)
		  {
			  hs.add(x.getStudentname());
		  }
		  for(String sub: hs)
			{
			  System.out.println(sub);
			  
			  ansresponse ns=new ansresponse();
				ArrayList<Pair> pair=new ArrayList<Pair>();
				ns.setStudentname(sub);
				
			  
			  List<distributions> ds=dsrepo.findAll();
			  

				for(int j=0;j<ds.size();j++)
				{
					String s=ds.get(j).getAssignmentcategory().toLowerCase();
					
					List<assignments> as=asrepo.findByname(sub,subjectname,s.substring(0,3));
					
					for(int k=0;k<as.size();k++)
					{
						avgscore=avgscore+((ds.get(j).getWeight()/as.size())*as.get(k).getPoints());		
					}
					avgscore=avgscore/100;	
					//System.out.println(ds.get(j).getAssignmentcategory()+" 	"+avgscore);
					pair.add(new Pair(ds.get(j).getAssignmentcategory(),avgscore));
					avgscore=0;
					
					
				}
				ns.setAns(pair);
				
				for(Pair it:pair)
				{
					overall=overall+it.getAverage();
				}
				ns.setOverall(overall);
				ans.add(ns);
				overall=0;
			  
			  
			}
		  
		return ans;
	}

	
	
	
	}
	
	
	
	
	
	



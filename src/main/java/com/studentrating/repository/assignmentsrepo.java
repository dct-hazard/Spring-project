package com.studentrating.repository;

//import java.sql.Date;

//import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.studentrating.models.*;

@Repository
public interface assignmentsrepo extends JpaRepository<assignments,Integer> {

	
	public assignments findByStudentnameAndSubjectAndAssignmentcategory(String studentname,String subject,String assignmentcategory);
	
	@Query(value="SELECT * FROM assignments  WHERE student_name =?1 AND subject= ?2 AND assignment_category LIKE ?3%",nativeQuery=true)
	public List<assignments> findByname(String studentname,String subject,String assignmentcategory);
	
	
	public List<assignments> findByStudentname(String studentname);
	
	public List<assignments> findBySubject(String subject);
	
	public List<assignments> findByAssignmentcategory(String ascat);
	
	public assignments findBySerialno(int serialno);
	
	public void deleteBySerialno(int serialno);
	

	
	

}

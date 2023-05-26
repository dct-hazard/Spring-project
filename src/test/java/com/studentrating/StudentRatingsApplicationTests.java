package com.studentrating;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import com.studentrating.dto.converter.distributionsconverter;
import com.studentrating.exceptions.DuplicateCategories;
import com.studentrating.models.assignments;
import com.studentrating.models.distributions;
import com.studentrating.repository.assignmentsrepo;
import com.studentrating.repository.distributionsrepo;
import com.studentrating.request.dto.assignmentsrequest;
import com.studentrating.request.dto.distributionsrequest;
import com.studentrating.response.dto.distributionsresponse;
import com.studentrating.service.assignmentsService;
import com.studentrating.service.distributionsService;



@RunWith(SpringRunner.class)
@SpringBootTest
class StudentRatingsApplicationTests {

	 //@Test
	//void contextLoads() {
	//}
	@Autowired
	distributionsconverter discon;
	
	
	@Autowired
	private distributionsService service;
	
	@MockBean
	private distributionsrepo dsrepo;
	
	@Autowired
	private assignmentsService aservice;
	
	@MockBean
	private assignmentsrepo asrepo;
	
	
	@Test
	public void testupdatepoints()
	{
		
		
		
	}
	
	

	
	

}

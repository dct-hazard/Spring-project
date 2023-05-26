package com.studentrating.service;

import java.util.List;

import com.studentrating.exceptions.DuplicateCategories;
import com.studentrating.exceptions.ResourceNotFoundException;
import com.studentrating.request.dto.distributionsrequest;


public interface distributionsService {

	public com.studentrating.models.distributions savecategory(distributionsrequest categories) throws DuplicateCategories;
	
	public List<com.studentrating.models.distributions> distributions() throws ResourceNotFoundException;
	
	public com.studentrating.models.distributions deletecategory(String id) throws ResourceNotFoundException;
}

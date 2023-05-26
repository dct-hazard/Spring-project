package com.studentrating.serviceImpl;

import java.util.List;

import com.studentrating.models.distributions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.studentrating.dto.converter.distributionsconverter;
import com.studentrating.exceptions.DuplicateCategories;
import com.studentrating.exceptions.ResourceNotFoundException;
import com.studentrating.repository.distributionsrepo;
import com.studentrating.request.dto.distributionsrequest;

import com.studentrating.service.distributionsService;


@Service
public class distributionsserviceImpl implements distributionsService{

	@Autowired
	distributionsrepo dsr;
	
	
	@Autowired
	distributionsconverter discon;
	
	@Override
	public distributions savecategory(distributionsrequest category) throws DuplicateCategories {
		// TODO Auto-generated method stub
		int twt=0;
		
		///CHECKING FOR DUPLICATE ENTRIES
		
		List<distributions> cat=dsr.findAll();
		distributions categories=discon.dtoToEntity(category);
		
		
		distributions existing=dsr.findById(categories.getAssignmentcategory()).orElse(null);
		if(existing==null)
		{
			if(cat.size()!=0)
				twt=dsr.sumweight();
			
		twt=(int) (twt+categories.getWeight());
		
		if(twt<=100) {
			
			
				/*if(*/return dsr.save(categories); //!= null)
				//	return category;
				//else 
				//	return null;
		}
		else
			throw new DuplicateCategories("Category weight limit exceeded");
		//return category;
		
		}
		else
			//return "Value already exist";
			throw new DuplicateCategories("Category Already Exist"); 
		
			
		
	}

	@Override
	public List<distributions> distributions() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<List<distributions>> find=Optional.fromNullable(dsr.findAll());
		List<distributions> cat=null;
		if(find.isPresent())
		{
			cat=find.get();
		}
		else
			throw new ResourceNotFoundException("No Records Exist !");
	
		return cat;
		
	}

	@Override
	public distributions deletecategory(String id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		java.util.Optional<distributions> findById=dsr.findById(id);
		distributions cat=null;
		if(findById.isPresent())
		{
			cat=findById.get();
			dsr.deleteById(id);
		}
		else throw new ResourceNotFoundException("Record does not Exist to be deleted !");
	
		return cat;
		
	}

	
}

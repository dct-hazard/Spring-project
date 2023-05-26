package com.studentrating.dto.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.studentrating.models.distributions;
import com.studentrating.request.dto.distributionsrequest;
import com.studentrating.response.dto.distributionsresponse;

@Component
public class distributionsconverter {

	public distributions dtoToEntity(distributionsrequest dsr)
	{
		distributions distribution=new distributions();
		distribution.setAssignmentcategory(dsr.getAssignmentcategory());
		distribution.setWeight(dsr.getWeight());
		
		
		
		return distribution;
		
	}
	
	public distributionsresponse entityToDto(distributions dis)
	{
		distributionsresponse dsrres=new distributionsresponse();
		dsrres.setAssignmentcategory(dis.getAssignmentcategory());
		dsrres.setWeight(dis.getWeight());
		
		return dsrres;
		
	}

	public List<distributions> dtoToEntity(List<distributionsrequest> dsr)
	{
		return dsr.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
	
	public List<distributionsresponse> entityToDto(List<distributions> dsr)
	{
		return dsr.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
}

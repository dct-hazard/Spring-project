package com.studentrating.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentrating.models.distributions;


public interface distributionsrepo extends JpaRepository<distributions,String> {
	
	//To find live sum of all categories weight 
	
	@Query("select sum(d.weight) from distributions d")
	int sumweight();

}

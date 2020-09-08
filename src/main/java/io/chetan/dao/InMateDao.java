package io.chetan.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.chetan.model.InMate;

public interface InMateDao extends CrudRepository<InMate,Long>
{

	List<InMate> findByMyPg(long myPg);
	
	List<InMate> findByPhoneNumberAndMyPg(String phoneNumber,long myPg);

}

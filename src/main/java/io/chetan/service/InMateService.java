package io.chetan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.chetan.dao.InMateDao;
import io.chetan.model.InMate;

@Service
public class InMateService {

	@Autowired
	private InMateDao inMateDao ;
	
	public InMate create(InMate inMate)
	{
		System.out.println("\n InMateService createInMate()\n");
		
		return inMateDao.save(inMate);
	}
	
	public InMate findById(long inMateId)
	{
		System.out.println("\n InMateService findById()\n");

		Optional<InMate> inMateOptional = inMateDao.findById(inMateId);
		
		return inMateOptional.get() ;
	}
	
	public void update(InMate inMate)
	{
		
		inMateDao.save(inMate);
	}
	
	public void delete(long inMateId)
	{
		inMateDao.deleteById(inMateId);
	}

	public List<InMate> findInMatesOfAPg(long pgId) 
	{
		System.out.println("\n InMateService findInMatesOfAPg()\n");
		
		return inMateDao.findByMyPg(pgId);
	}
	
	
	
	
}
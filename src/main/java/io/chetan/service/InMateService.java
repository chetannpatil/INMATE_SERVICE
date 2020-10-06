package io.chetan.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.chetan.dao.InMateDao;
import io.chetan.model.InMate;

@Service
public class InMateService {

	private static final Logger LOGGER = Logger.getLogger(InMateService.class.getName());
	
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

		//Optional<InMate> findById = inMateDao.findById(inMateId);
		
		Optional<InMate> inMateOptional = inMateDao.findById(inMateId);
		
		InMate inMate = inMateOptional.get() ;
		
		//return inMateOptional.get() ;
		
		return inMate ;
	}
	
	public void update(InMate inMate)
	{
		System.out.println("\n InMateService update()\n");
		 //updating
		
		 System.out.println("\nupdated inmate  = \n "+inMateDao.save(inMate));
	}
	
	public void delete(long inMateId)
	{
		inMateDao.deleteById(inMateId);
	}

	public List<InMate> findInMatesOfAPg(long pgId) 
	{
		System.out.println("\n InMateService findInMatesOfAPg()\n");
		
		//List<InMate> findByMyPg = inMateDao.findByMyPg(pgId);
		
		return inMateDao.findByMyPg(pgId);
	}

	public boolean findInMateByPhoneNumberAndPgId(String phoneNumber, long pgId)
	{
		System.out.println("\n InMateService findInMateByPhoneNumberAndPgId()\n");
		List<InMate> list = inMateDao.findByPhoneNumberAndMyPg(phoneNumber, pgId);
		
		
		if(list != null && list.size() > 0)
		{
			//list contains only one value 
			System.out.println("\n InMateService findInMateByPhoneNumberAndPgId() -list contains only one value \n");
			//return list.get(0);
			
			return true ;
		}
		else
		{
			System.out.println("\n InMateService findInMateByPhoneNumberAndPgId() not found\n");
			//return null;
			return false ;
		}
		
	}

	public InMate searchInMateByPhoneNumberAndPassword(String phoneNumber, String password)
	{
		LOGGER.info("\n I.service -searchInMateByPhoneNumberAndPassword - with phone = \n"+phoneNumber+"\n  psw = \n "+password);
		
		return inMateDao.findByPhoneNumberAndPassword(phoneNumber,password);
	}

	

	public boolean isInMateExist(String phoneNumber) 
	{
		LOGGER.info("\n I.service -isInMateExist - with phone = \n"+phoneNumber);
       List<InMate> list = inMateDao.findByPhoneNumber(phoneNumber);
		
		if(list == null || list.isEmpty())
			return false;
		else
			return true ;
	}
	
	
	
	
}

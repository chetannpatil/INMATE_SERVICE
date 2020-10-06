package io.chetan.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.chetan.model.InMate;
import io.chetan.service.InMateService;

@RestController
@RequestMapping(value = "/inMate")
public class InMateController 
{

	@Autowired
	private InMateService inMateService ;
	
	private static final Logger LOGGER = Logger.getLogger(InMateController.class.getName());
	
	//CREATE
	@PostMapping(value = "/create")
	public InMate create(@RequestBody InMate inMate)
	{
		System.out.println("\n InMateController create()\n");
		return inMateService.create(inMate);
	
	}		

	
	//UPDATE
	@PutMapping(value = "/update")
	public void update(@RequestBody InMate inMate)
	{
		System.out.println("\n InMateController update()\n");
		
		inMateService.update(inMate);

	}
	
	//DELETE
	@DeleteMapping(value = "/delete/{inMateId}")
	public void delete(@PathVariable long inMateId)
	{
		System.out.println("\n InMateController delete()\n");
		
		inMateService.delete(inMateId);

	}
	
	//READ
	//search inmate by his id
		@GetMapping(value = "/find/{inMateId}")
		public InMate findById(@PathVariable long inMateId)
		{
			System.out.println("\n InMateController findById()\n");
			
			return inMateService.findById(inMateId);

		}
		
	//load all inmates of a pg
	@GetMapping(value = "/findAll/{pgId}")
	public List<InMate> findAllInMatesOfAPg(@PathVariable long pgId)
	{
		System.out.println("\n InMateController findInMatesOfAPg()\n");
		
		return inMateService.findInMatesOfAPg(pgId);

	}
	
	//search inmate by his phone number & his PgId
	//value = "/findRoomByRoomNumberAndMyPg/roomNumber/{roomNumber}/myPg/{myPg}
//	@GetMapping(value = "/find/phoneNumber/{phoneNumber}/pgId/{pgId}")
//	public InMate findInMateByPhoneNumberAndPgId(@RequestParam("phoneNumber") String phoneNumber,
//			@RequestParam("pgId") long pgId)
//	{
//		System.out.println("\n InMateController findInMatesOfAPg()\n");
//		
//		return inMateService.findInMateByPhoneNumberAndPgId(phoneNumber,pgId);
//	}
	
//	@GetMapping(value = "/find/{phoneNumber}/{pgId}")
//	public InMate findInMateByPhoneNumberAndPgId(@PathVariable("phoneNumber") String phoneNumber,
//			@PathVariable("pgId") long pgId)
//	{
//		System.out.println("\n InMateController findInMatesOfAPg()\n");
//		
//		return inMateService.findInMateByPhoneNumberAndPgId(phoneNumber,pgId);
//	}
	
	@GetMapping(value = "/find/{phoneNumber}/{pgId}")
	public boolean isInMateExist(@PathVariable("phoneNumber") String phoneNumber,
			@PathVariable("pgId") long pgId)
	{
		System.out.println("\n InMateController findInMatesOfAPg()\n");
		
		return inMateService.findInMateByPhoneNumberAndPgId(phoneNumber,pgId);
	}
	
	@GetMapping(value = "/find/phoneNumber/{phoneNumber}/password/{password}")
	public InMate searchInMateByPhoneNumberAndPassword(@PathVariable String phoneNumber,
			@PathVariable String password)
	{
		LOGGER.info("\n IC -searchInMateByPhoneNumberAndPassword - with phone = \n"+phoneNumber+"\n  psw = \n "+password);
		
		return inMateService.searchInMateByPhoneNumberAndPassword(phoneNumber,password);
	}
	@GetMapping(value = "/find/{phoneNumber}")
	public boolean isInMateExist(@PathVariable("phoneNumber") String phoneNumber)
	{
		LOGGER.info("\n IC -searchInMateByPhoneNumberAndPassword - with phone = \n"+phoneNumber+"\n  \n ");
		
		return inMateService.isInMateExist(phoneNumber);
	}
	
}

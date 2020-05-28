package io.chetan.controller;

import java.util.List;

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
import io.chetan.model.Pg;
import io.chetan.service.InMateService;

@RestController
@RequestMapping(value = "/inMate")
public class InMateController 
{

	@Autowired
	private InMateService inMateService ;
	
	@PostMapping(value = "/create")
	public InMate create(@RequestBody InMate inMate)
	{
		System.out.println("\n InMateController create()\n");
		return inMateService.create(inMate);
	
	}		

	
	@GetMapping(value = "/findById/{inMateId}")
	public InMate findById(@PathVariable long inMateId)
	{
		System.out.println("\n InMateController findById()\n");
		
		return inMateService.findById(inMateId);

	}
	
	@PutMapping(value = "/update")
	public void update(@RequestBody InMate inMate)
	{
		System.out.println("\n InMateController update()\n");
		
		inMateService.update(inMate);

	}
	
	@DeleteMapping(value = "/delete/{inMateId}")
	public void delete(@PathVariable long inMateId)
	{
		System.out.println("\n InMateController delete()\n");
		
		inMateService.delete(inMateId);

	}
	
	//load all inmates of a pg
	@GetMapping(value = "/findAllByPgId/{pgId}")
	public List<InMate> findInMatesOfAPg(@PathVariable long pgId)
	{
		System.out.println("\n InMateController findInMatesOfAPg()\n");
		
		return inMateService.findInMatesOfAPg(pgId);

	}
	
	
}

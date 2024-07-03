package com.example.mobieshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.mobieshop.model.Mobile;
import com.example.mobieshop.service.MobileService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HomeRestController {

	@Autowired
	private MobileService mobileservice;
	
	@GetMapping("/api/mobiles")
	public List<Mobile> getAllMobiles() {
		return mobileservice.showAllMobiles() ;
	}
	@GetMapping("/api/mobile/{id}")
	public Optional<Mobile> getMobile(@PathVariable("id") String model)
	{
		return mobileservice.searhMobile(model);		
	}
	@GetMapping("/api/mobiles/{brand}")
	public List<Mobile> getMobilesBrandwise(@PathVariable("brand") String brand)
	{
		return mobileservice.showMobileBrandWise(brand);	
	}	
	@PostMapping("/api/mobile")
	public Mobile addMobile(@RequestBody Mobile mobile)
	{
		Optional<Mobile> opt = mobileservice.searhMobile(mobile.getModel());
		if(opt.isEmpty())
			return mobileservice.addMobile(mobile);
		else
			return new Mobile();
		
	}
	@PutMapping("/api/mobile")
	public Mobile updateMobile(@RequestBody Mobile mobile)
	{
		Optional<Mobile> opt = mobileservice.searhMobile(mobile.getModel());
		if(opt.isPresent())
			return mobileservice.addMobile(mobile);
		else
			return new Mobile();
		
	}
	
	@DeleteMapping("/api/mobile/{id}")
	public Optional<Mobile> deleteMobile(@PathVariable("id") String model)
	{
		Optional<Mobile> opt = mobileservice.searhMobile(model);
		if(opt.isPresent())
		{
			mobileservice.deleteMobile(model);
			return opt;
		}
		else
			return opt;
			
	}
}

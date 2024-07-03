package com.example.mobieshop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mobieshop.model.Mobile;
import com.example.mobieshop.service.MobileService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	@Autowired
	private MobileService mobileservice;
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/mobile/view")
	public String viewPage(Model model) {
		model.addAttribute("allmobiles",mobileservice.showAllMobiles());
		return "MobileView";
	}
	
	@GetMapping("/mobile/add")
	public String addPage(Model model) {
		model.addAttribute("obj",new Mobile());
		return "MobileAdd";
	}
	
	@PostMapping("/mobile/add")
	public String addMobile(@ModelAttribute("obj") Mobile mobile) {
		Optional<Mobile> opt=mobileservice.searhMobile(mobile.getModel());
		
		if(opt.isEmpty())
		{
			mobileservice.addMobile(mobile);
			return "redirect:/mobile/view";
		}
		else
		{
			return "redirect:/mobile/add?failed";
		}
		
	}
	
	@GetMapping("/mobile/edit/{id}")
	public String editPage(@PathVariable("id") String model1, Model model)
	{
		model.addAttribute("obj", mobileservice.searhMobile(model1));
		return "MobileEdit";
	}
	
	@PostMapping("/mobile/edit")
	public String editMobile(@ModelAttribute("obj") Mobile mobile)
	{
		mobileservice.addMobile(mobile);
		return "redirect:/mobile/view";
	}
	
	@GetMapping("mobile/delete/{id}")
	public String deleteMobile(@PathVariable("id") String model )
	{
		mobileservice.deleteMobile(model);
		return "redirect:/mobile/view";
		
	}
	@GetMapping("mobile/search/{brand}")
	public String viewPhones(@PathVariable("brand")String brand,Model model) {
		model.addAttribute("allmobiles",mobileservice.showMobileBrandWise(brand));
		return "mobileView";
	}
	@GetMapping("mobile/search/higher/{price}")
	public String searchMobilePriceWise(@PathVariable("price") float price,Model model) {
		model.addAttribute("allmobiles",mobileservice.showHigherPriceMobiles(price));
		return "mobileView";
	}
	@GetMapping("/mobile/search")
	public String showMobiles(Model model)
	{
		model.addAttribute("allMobiles", mobileservice.showDataCustomQuery(50000.00f, "iphone"));
		return "mobileView";
	}
	
}

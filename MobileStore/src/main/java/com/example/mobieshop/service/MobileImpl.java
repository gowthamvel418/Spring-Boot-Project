package com.example.mobieshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mobieshop.model.Mobile;
import com.example.mobieshop.repository.MobileRepositoy;

@Service
public class MobileImpl implements MobileService{
	@Autowired
	private MobileRepositoy mobilerepository;
	
	@Override
	public List<Mobile> showAllMobiles(){
		return mobilerepository.findAll();
	}
	
	@Override
	public Optional<Mobile> searhMobile(String model){
		return mobilerepository.findById(model);
	}

	@Override
	public Mobile addMobile(Mobile newMobile) {
		return mobilerepository.save(newMobile);
	}

	@Override
	public void deleteMobile(String model) {
		mobilerepository.deleteById(model);
	}

	@Override
	public List<Mobile> showMobileBrandWise(String brand) {
		return mobilerepository.findByBrand(brand);
	}

	@Override
	public List<Mobile> showHigherPriceMobiles(float price) {
		return mobilerepository.findByPriceGreaterThan(price);
	}
	@Override
	public List<Mobile> showDataCustomQuery(float price, String brand) {
		
		return mobilerepository.findMobiles(price, brand);
	}
}

package com.example.mobieshop.service;

import java.util.List;
import java.util.Optional;

import com.example.mobieshop.model.Mobile;

public interface MobileService {

	List<Mobile> showAllMobiles();
	Optional<Mobile> searhMobile(String model);
	//is empty;
	Mobile addMobile(Mobile newMobile);
	
	void deleteMobile(String model);
	
	List<Mobile> showMobileBrandWise(String brand);
	List<Mobile> showHigherPriceMobiles(float price);
	
	List<Mobile> showDataCustomQuery(float price, String brand);
}

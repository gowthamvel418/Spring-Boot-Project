package com.example.mobieshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mobieshop.model.Mobile;

public interface MobileRepositoy extends JpaRepository<Mobile,String>{
	
	List<Mobile> findByBrand(String brand);// select * from mobile where brand = ?
	
	List<Mobile> findByPriceGreaterThan(float price);
	
	List<Mobile> findByBrandAndProcessor(String brand, String processor);
	
	@Query(value="select * from mobile where price<=?1 and brand=?2 ", nativeQuery=true)
	List<Mobile> findMobiles(float price,String brand);

}

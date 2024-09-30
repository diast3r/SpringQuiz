package com.quiz.lesson03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RestController
@RequestMapping("/lesson03/quiz01")
public class Lesson03Quiz01RestController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/1")
	public RealEstate quiz01(
			@RequestParam("id") int id) {
		return realEstateBO.getRealEstateById(id);
	}
	
	@RequestMapping("/2")
	public List<RealEstate> quiz02(
			@RequestParam(value = "rentPrice", required = false) int rentPrice) {
		
		return realEstateBO.getRealEstateByRentPrice(rentPrice);
	}
	
	@RequestMapping("/3")
	public List<RealEstate> quiz03(
			@RequestParam("area") int area, @RequestParam("price") int price) {
		Map<String, Object> parameterMap = new HashMap<>();
		parameterMap.put("area", area);
		parameterMap.put("price", price);
		
		return realEstateBO.getRealEstateByAreaAndPrice(parameterMap);
	}
}

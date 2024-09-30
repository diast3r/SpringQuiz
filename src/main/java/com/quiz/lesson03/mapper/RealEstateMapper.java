package com.quiz.lesson03.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {
	public RealEstate selectRealEstateById(int id);
	public List<RealEstate> selectRealEstateByRentPrice(int RentPrice);
	public List<RealEstate> selectRealEstateByAreaAndPrice(Map<String, Object> parameterMap);
}

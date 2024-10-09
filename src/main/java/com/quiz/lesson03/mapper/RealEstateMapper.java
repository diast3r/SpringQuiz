package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {
	
	// input: id(int)
	// output: RealEstate(DTO)
	public RealEstate selectRealEstateById(int id);
	
	// input: int(rentPrice)
	// output: List<RealEstate>
	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
	
	// input: area(int), price(int)
	// output: List<RealEstate>
	public List<RealEstate> selectRealEstateListByAreaPrice(
			// xml에 parameter 두 개 이상을 보낼 수 없다.
			// 그래서 하나의 맵으로 파라미터를 구성해야 하는데, @Param 어노테이션이 이 기능을 해줌.
			// @Param("key") 자료형 value
			@Param("area") int area, 
			@Param("price") int price);
	
	// input: RealEstate
	// output: int(성공한 행의 개수)
	public int insertRealEstate(RealEstate realEstate);
	
	// input: 여러 파라미터
	// output: int
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId, 
			@Param("address") String address, 
			@Param("area") int area, 
			@Param("type") String type, 
			@Param("price") int price, 
			@Param("rentPrice") Integer rentPrice);
	
	// input: id, type, price
	// output: int
	public int updateRealEstateById(
			@Param("id") int id,
			@Param("type") String type,
			@Param("price") int price);
	
	public void deleteRealEstateById(int id);
	
}

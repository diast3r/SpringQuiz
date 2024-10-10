package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson04.domain.Seller;

@Mapper
public interface SellerMapper {
	// 문제 1-1
	public int insertSeller(
			@Param("nickname") String nickname, // @Param: Mybatis가 제공하는 어노테이션.
			@Param("profileImageUrl") String profileImageUrl,
			@Param("temperature") Double temperature); 
	
	// 문제 1-2
	public Seller selectLatestSeller();
	
	// 문제 1-3
	public Seller selectSellerById(int id);

}

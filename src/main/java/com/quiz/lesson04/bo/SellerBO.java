package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	@Autowired // 의존성 주입.DI dependency injection
	private SellerMapper sellerMapper;
	
	// 문제 1-1
	public void addSeller(String nickname, String profileImageUrl, Double temperature) {
		sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	// 문제 1-2. (1-3번 풀면 사용하지 않을 코드.)
	public Seller getLatestSeller() {
		return sellerMapper.selectLatestSeller();
	}
	
	// 문제 1-3
	public Seller getSellerById(int id) {
		return sellerMapper.selectSellerById(id);
	}
}

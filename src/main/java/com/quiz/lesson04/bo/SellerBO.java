package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	@Autowired
	private SellerMapper sellerMapper;
	
	public void addSeller(String nickname, String profileImageUrl, Double temperature) {
		sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	public Seller getSeller() {
		return sellerMapper.selectSeller();
	}
	
	public Seller getSellerById(int id) {
		Seller seller = sellerMapper.selectSellerById(id);
		return seller == null? sellerMapper.selectSellerById(1) : seller;
	}
}

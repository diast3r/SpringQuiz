package com.quiz.store.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.store.domain.Review;
import com.quiz.store.mapper.ReviewMapper;

@Service
public class ReviewBO {
	@Autowired
	private ReviewMapper reviewMapper;
	
	public List<Review> getReviewListByStoreId(int storeId) {
		return reviewMapper.selectReviewListByStoreId(storeId);
	}
}

package com.quiz.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.store.domain.Review;

@Mapper
public interface ReviewMapper {
	public List<Review> selectReviewListByStoreId(int storeId);
}

package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service
public class StoreBO {
	
	@Autowired // DI (의존성 주입)
	private StoreMapper storeMapper;
	
	// input: X
	// output: List<Store>
	public List<Store> getStoreList() {
		return storeMapper.selectStoreList(); 
	}
	
	public Store getStoreById(int id) {
		return storeMapper.selectStoreById(id);
	}
}

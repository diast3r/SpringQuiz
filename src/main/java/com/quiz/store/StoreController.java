package com.quiz.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.store.bo.ReviewBO;

@Controller
@RequestMapping("/store")
public class StoreController {
	@Autowired
	private StoreBO storeBO;
	@Autowired
	private ReviewBO reviewBO;
	
	@GetMapping("/store-list")
	public String storeListView(Model model) {
		model.addAttribute("storeList", storeBO.getStoreList());
		
		return "store/storeList";
	}
	
	@GetMapping("/review")
	public String storeReview(
			Model model,
			@RequestParam("storeId") int storeId
			) {
		model.addAttribute("store", storeBO.getStoreById(storeId)); // 가게이름을 가져오기 위해 따로 id로 조회함.
		model.addAttribute("reviewList", reviewBO.getReviewListByStoreId(storeId));
		
		return "store/reviewList";
	}
}

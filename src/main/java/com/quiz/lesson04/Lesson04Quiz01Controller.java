package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@Controller
@RequestMapping("/lesson04/quiz01")
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;
	
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam(value = "temperature", required = false) Double temperature
			// @RequestParam(value = "temperature", defaultValue="36.5") double temperature
			) {
		
		// TODO db에 추가
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	// http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller"; // view 경로
	}
	
	// 문제 1-2, 1-3
	// 최근 가입자 화면(1-2), id로 검색(1-3)
	@GetMapping("/seller-info-view")
	public String sellerInfoView(Model model,
			@RequestParam(value = "id", required = false) Integer id) {
		Seller seller;
		// DB select
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		
		// 화면 이동
		return "lesson04/sellerInfo";
	}
}

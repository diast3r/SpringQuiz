package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;

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
			) {
		
		// db에 추가
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	@GetMapping("/add-seller-view")
	public String quiz01() {
		return "lesson04/addSeller";
	}
	
	
	@GetMapping("/seller-info-view")
	public String sellerInfo(Model model,
			@RequestParam(value = "id", defaultValue = "1") int id) {
		model.addAttribute("seller", sellerBO.getSellerById(id));
		model.addAttribute("requestId", (Integer)id);
		// 뷰로 보내기
		return "lesson04/sellerInfo";
	}
}

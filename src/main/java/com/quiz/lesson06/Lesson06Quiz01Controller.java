package com.quiz.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;

@Controller
public class Lesson06Quiz01Controller {
	@Autowired
	private BookmarkBO bookmarkBO;
	
	@GetMapping("/lesson06/bookmark-list")
	public String bookMarkList(Model model) {
		model.addAttribute("bookmarkList", bookmarkBO.getBookMarkList());
		
		return "lesson06/bookmarkList";
	}
	
	// 추가 화면
	@GetMapping("/lesson06/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	// 추가 기능 => AJAX 호출
	@ResponseBody
	@PostMapping("/lesson06/add-bookmark")
	public String addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url
			) {
		bookmarkBO.addBookmark(name, url);
		
		return "성공?";
	}
}

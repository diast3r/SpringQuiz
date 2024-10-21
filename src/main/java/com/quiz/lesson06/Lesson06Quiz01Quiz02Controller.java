package com.quiz.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;

@Controller
@RequestMapping("/lesson06/quiz01")
public class Lesson06Quiz01Quiz02Controller {
	@Autowired
	private BookmarkBO bookmarkBO;
	
	// 즐겨찾기 목록 화면
	@GetMapping("/bookmark-list-view")
	public String bookMarkList(Model model) {
		model.addAttribute("bookmarkList", bookmarkBO.getBookmarkList());
		
		return "lesson06/bookmarkList";
	}
	
	// 추가 화면
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	// 추가 기능 => AJAX 호출
	// @ResponseBody가 사용되면  Model을 쓸 수 없다.
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark( // Responsebody에 Map으로 보냄 => jackson 라이브러리가 json으로 변환해줌. 
			@RequestParam("name") String name,
			@RequestParam("url") String url
			) {
		bookmarkBO.addBookmark(name, url);
		
		// 성공 여부 JSON String
		// "{"code":200, "result":"성공"}"
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result",  "성공");
		// 아무 사이트 들어가서 페이지 로드할 때 네트워크 응답값에서 json으로 된 것들 살펴보기.
		return result;
	}
	
	
	// quiz 02
	// id로 삭제 - AJAX 요청
	@DeleteMapping("/delete-bookmark") // delete쿼리를 수행할 함수에 쓰는 어노테이션. post계열 메소드 중 하나.
	@ResponseBody
	public Map<String, Object> deleteBookmark(@RequestParam("id") int id) {
		
		Map<String, Object> result = new HashMap<>();
		if (bookmarkBO.deleteBookmarkById(id)) {
			result.put("code", 200);
			result.put("result",  "성공");
			return result;
		} else {
			result.put("code", 500); // 삭제 실패 코드 대충 500으로 정함.
			result.put("error_message",  "삭제 실패 이유");
			return result;
		}
	}
	
	@PostMapping("/is-duplicated-url")
	@ResponseBody
	public Map<String, Object> isDuplicatedUrl(
			@RequestParam("url") String url) {
		
		// db select 
		boolean isDuplicated = false;
		if (bookmarkBO.isDuplicatedUrl(url)) {
			isDuplicated = true;
		}
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		if (isDuplicated) {
			result.put("is_duplicated", true);
		} else {
			result.put("is_duplicated", false);
		}
		return result;
	}
}

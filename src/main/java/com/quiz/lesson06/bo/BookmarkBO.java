package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {
	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList(); 
	}
	
	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
	
	public boolean deleteBookmarkById(int id) {
		return bookmarkMapper.deleteBookmarkById(id) == 1;
	}
	
	// output: boolean
	public boolean isDuplicatedUrl(String url) {
		List<Bookmark> bookmarkList = bookmarkMapper.selectBookmarkByUrl(url);
		// List의 경우 mapper에서 select의 결과가 0행이면 null이 아니라 비어있는 리스트를 반환함.
		
		// 비어있으면 중복이 아니므로, empty true => false
		return bookmarkList.isEmpty() == false;
	}
}
